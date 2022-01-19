package com.techlead.biblioteca.services;

import com.techlead.biblioteca.components.UserSS;
import com.techlead.biblioteca.services.exceptions.DuplicateEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlead.biblioteca.dto.UserDTO;
import com.techlead.biblioteca.dto.UserInsertDTO;
import com.techlead.biblioteca.entities.User;
import com.techlead.biblioteca.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repository;

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User byEmail = repository.findByEmail(dto.getEmail());
		if(byEmail != null && byEmail.getId()>0)
			throw  new DuplicateEntityException("Email já cadastrado");


		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		User savedUser = repository.save(entity);
		repository.insertOnUserRole(savedUser.getId());

		return new UserDTO(entity);


	}

	private void copyDtoToEntity(UserDTO dto, User entity) {

		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " + username);
		return new UserSS(user.getId(), user.getEmail(), user.getPassword(), user.getRoles());
	}
}

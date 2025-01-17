package com.techlead.biblioteca.services;

import com.techlead.biblioteca.entities.User;
import com.techlead.biblioteca.repositories.UserRepository;
import com.techlead.biblioteca.services.exceptions.ForbidenException;
import com.techlead.biblioteca.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid User");
        }
    }

    public void validateSelf(Long userId) {
        User user = authenticated();

        if (!user.getId().equals(userId) && user.getRoles().stream()
                .noneMatch(role -> role.getAuthority().equals("ADMINISTRADOR"))) {
            throw new ForbidenException("Access denied");
        }

    }

}
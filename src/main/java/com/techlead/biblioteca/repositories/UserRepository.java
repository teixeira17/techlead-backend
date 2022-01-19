package com.techlead.biblioteca.repositories;

import com.techlead.biblioteca.dto.UserInsertDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlead.biblioteca.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	@Modifying
	@Query(nativeQuery = true, value = "insert into tb_user_role (user_id, role_id) values (:id, 1)" )
	void insertOnUserRole(Long id);
}
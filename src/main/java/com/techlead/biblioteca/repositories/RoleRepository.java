package com.techlead.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlead.biblioteca.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {


}
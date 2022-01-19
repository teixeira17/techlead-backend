package com.techlead.biblioteca.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.techlead.biblioteca.entities.Role;
import com.techlead.biblioteca.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo obrigatório")
	private String name;

	@Email(message = "Favor entrar um email válido")
	private String email;

	private String password;

	private Role role;

	public UserDTO() {
	}

	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		password = entity.getPassword();
		role = new Role(1L, "ROLE_CLIENTE");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}

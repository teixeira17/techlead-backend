package com.techlead.biblioteca.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.techlead.biblioteca.entities.Livro;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo requerido")
	private String nome;

	@NotBlank(message = "Campo requerido")
	private String autor;

	@PastOrPresent(message = "A data do produto não pode ser futura")
	private LocalDate date;

	private UserDTO user;

	public LivroDTO() {
	}

	public LivroDTO(Livro entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.autor = entity.getAutor();
		this.date = entity.getDataCadastro();
		user = new UserDTO(entity.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDate() {
		return date;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LivroDTO [nome=" + nome + ", autor=" + autor + "]";
	}

}

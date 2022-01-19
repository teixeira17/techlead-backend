package com.techlead.biblioteca.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techlead.biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	@Query("SELECT obj FROM Livro obj "
			+ "WHERE(:nome IS NULL OR LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome,'%'))) "
			+ "ORDER BY obj.nome ")
	Page<Livro> findByNome(String nome, Pageable pageable);

}
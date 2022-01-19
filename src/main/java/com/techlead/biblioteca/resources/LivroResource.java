package com.techlead.biblioteca.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techlead.biblioteca.dto.LivroDTO;
import com.techlead.biblioteca.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> findById(@PathVariable Long id) {
		LivroDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<Page<LivroDTO>> findByName(@RequestParam(value = "nome", defaultValue = "") String name,
			Pageable pageable) {

		Page<LivroDTO> list = service.findByName(name, pageable);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<LivroDTO> insert(@RequestBody LivroDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody LivroDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
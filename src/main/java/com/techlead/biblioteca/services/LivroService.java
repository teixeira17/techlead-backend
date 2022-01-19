package com.techlead.biblioteca.services;

import com.techlead.biblioteca.dto.LivroDTO;
import com.techlead.biblioteca.entities.Livro;
import com.techlead.biblioteca.entities.User;
import com.techlead.biblioteca.exceptions.DatabaseException;
import com.techlead.biblioteca.exceptions.ResourceNotFoundException;
import com.techlead.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public LivroDTO findById(Long id) {
        Optional<Livro> obj = repository.findById(id);
        Livro entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new LivroDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<LivroDTO> findByName(String name, Pageable pageable) {
        Page<Livro> page = repository.findByNome(name, pageable);
        return page.map(x -> new LivroDTO(x));
    }

    @Transactional
    public LivroDTO insert(LivroDTO dto) {


        User user = authService.authenticated();


        Livro entity = new Livro();
        entity.setNome(dto.getNome());
        entity.setAutor(dto.getAutor());
        entity.setDataCadastro(LocalDate.now());
        entity.setUser(user);
        entity = repository.save(entity);
        return new LivroDTO(entity);
    }

    @Transactional
    public LivroDTO update(Long id, LivroDTO dto) {
        try {

            Optional<Livro> entity = repository.findById(id);
            if (entity.isEmpty())
                throw new ResourceNotFoundException("Livro não encontrado");
            authService.validateSelf(entity.get().getUser().getId());

            var entity2 = entity.get();
            entity2.setId(id);
            entity2.setNome(dto.getNome());
            entity2.setAutor(dto.getAutor());
            entity2 = repository.save(entity2);
            return new LivroDTO(entity2);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        Optional<Livro> entity = repository.findById(id);
        if (entity.isEmpty())
            throw new ResourceNotFoundException("Livro não encontrado");
            authService.validateSelf(entity.get().getUser().getId());
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}

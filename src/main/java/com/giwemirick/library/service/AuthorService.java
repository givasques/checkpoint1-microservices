package com.giwemirick.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giwemirick.library.dto.AuthorRequestCreate;
import com.giwemirick.library.dto.AuthorRequestUpdate;
import com.giwemirick.library.model.Author;
import com.giwemirick.library.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor (AuthorRequestCreate dto) {
        return authorRepository.save(dto.toModel());
    }

    public Optional<Author> updateAuthor (Long id, AuthorRequestUpdate dto) {
        return authorRepository.findById(id).map(a ->
            authorRepository.save(dto.toModel(a))
        );
    }

    public Boolean deleteAuthor (Long id) {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
            return true; 
        }
        return false;
    }

    public Optional <Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAll () {
        return authorRepository.findAll();
    }
}

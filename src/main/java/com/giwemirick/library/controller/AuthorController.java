package com.giwemirick.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giwemirick.library.dto.AuthorRequestCreate;
import com.giwemirick.library.dto.AuthorRequestUpdate;
import com.giwemirick.library.dto.AuthorResponse;
import com.giwemirick.library.service.AuthorService;

@RestController
@RequestMapping ("authors")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor (@RequestBody AuthorRequestCreate dto) {
        return ResponseEntity.status(201).body(new AuthorResponse().toDto(authorService.createAuthor(dto)));
    }

    @PutMapping ("{id}")
    public ResponseEntity<AuthorResponse> updateAuthor (@PathVariable Long id, @RequestBody AuthorRequestUpdate dto) {
        return authorService.updateAuthor(id, dto)
        .map(a -> new AuthorResponse().toDto(a))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Void> deleteAuthor (@PathVariable Long id) {
        if (authorService.deleteAuthor(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping ("{id}")
    public ResponseEntity<AuthorResponse> getAuthorById (@PathVariable Long id) {
        return authorService.getAuthorById(id).
        map(a -> new AuthorResponse().toDto(a))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAll () {
        List <AuthorResponse> authors = authorService.getAll().stream().map(
            a -> new AuthorResponse().toDto(a)
        ).toList();

        return ResponseEntity.ok().body(authors);
    }
}

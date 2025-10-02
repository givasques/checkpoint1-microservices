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

import com.giwemirick.library.dto.BookRequestCreate;
import com.giwemirick.library.dto.BookRequestUpdate;
import com.giwemirick.library.dto.BookResponse;
import com.giwemirick.library.service.BookService;



@RestController
@RequestMapping ("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequestCreate dto) {
        return ResponseEntity.status(201).body(new BookResponse().toDto(bookService.createBook(dto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody BookRequestUpdate dto) {
        return bookService.updateBook(id, dto)
            .map(b -> new BookResponse().toDto(b))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
            .map(b -> new BookResponse().toDto(b))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAll() {
        List<BookResponse> books = bookService.getAll().stream()
            .map(b -> new BookResponse().toDto(b))
            .toList();

        return ResponseEntity.ok().body(books);
    }
}

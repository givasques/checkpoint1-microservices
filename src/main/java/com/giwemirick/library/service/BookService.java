package com.giwemirick.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giwemirick.library.dto.BookRequestCreate;
import com.giwemirick.library.dto.BookRequestUpdate;
import com.giwemirick.library.model.Author;
import com.giwemirick.library.model.Book;
import com.giwemirick.library.repository.AuthorRepository;
import com.giwemirick.library.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public Book createBook(BookRequestCreate dto) {
        Author author = authorRepository.findById(dto.getAuthorId())
        .orElseThrow(() -> new RuntimeException(
                        "Inexistent Author - ID: " + dto.getAuthorId()));
        
        Book book = dto.toModel(author);
        return bookRepository.save(book);        
    }

    public Optional<Book> updateBook(Long id, BookRequestUpdate dto) {
        return bookRepository.findById(id).map(
                b -> {
                    Author author = authorRepository.findById(dto.getAuthorId())
                            .orElseThrow(() -> new RuntimeException(
                                    "Inexistent Author!"));
                    return bookRepository.save(dto.toModel(b, author));
                });
    }

    public Boolean deleteBook(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}

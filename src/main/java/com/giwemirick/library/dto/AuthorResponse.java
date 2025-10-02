package com.giwemirick.library.dto;

import java.time.LocalDate;

import java.util.List;

import com.giwemirick.library.model.Author;

public class AuthorResponse {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private List<BookResponse> books;

    public AuthorResponse toDto (Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.birthDate = author.getBirthDate();
        this.books = author.getBooks().stream().map(b -> new BookResponse().toDto(b)).toList();
        return this;
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
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public List<BookResponse> getBooks() {
        return books;
    }
    public void setBooks(List<BookResponse> books) {
        this.books = books;
    }
}

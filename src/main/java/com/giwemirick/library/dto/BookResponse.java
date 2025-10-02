package com.giwemirick.library.dto;

import com.giwemirick.library.model.Book;

public class BookResponse {
    private Long id;
    private String title;
    private String description;
    private AuthorResponseWithoutBooks author;

    public BookResponse toDto (Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.author = new AuthorResponseWithoutBooks().toDto(book.getAuthor());
        return this;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public AuthorResponseWithoutBooks getAuthor() {
        return author;
    }
    public void setAuthor(AuthorResponseWithoutBooks author) {
        this.author = author;
    }
}

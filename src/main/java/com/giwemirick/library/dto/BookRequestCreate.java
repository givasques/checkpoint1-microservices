package com.giwemirick.library.dto;

import com.giwemirick.library.model.Author;
import com.giwemirick.library.model.Book;

public class BookRequestCreate {
    private String title;
    private String description;
    private Long authorId;

    public Book toModel(Author author) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(author);
        return book;
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

    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}

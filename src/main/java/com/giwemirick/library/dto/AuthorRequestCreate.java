package com.giwemirick.library.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.giwemirick.library.model.Author;

public class AuthorRequestCreate {
    private String name;
    private LocalDate birthDate;

    public Author toModel () {
        Author author = new Author();
        author.setName(name);
        author.setBirthDate(birthDate);
        author.setBooks(new ArrayList<>());
        return author;
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
}

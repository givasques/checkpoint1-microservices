package com.giwemirick.library.dto;

import java.time.LocalDate;

import com.giwemirick.library.model.Author;

public class AuthorRequestUpdate {
    private String name;
    private LocalDate birthDate;

    public Author toModel (Author author) {
        author.setName(name);
        author.setBirthDate(birthDate);
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

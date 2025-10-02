package com.giwemirick.library.dto;

import java.time.LocalDate;

import com.giwemirick.library.model.Author;

public class AuthorResponseWithoutBooks {
    private Long id;
    private String name;
    private LocalDate birthDate;


    public AuthorResponseWithoutBooks toDto (Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.birthDate = author.getBirthDate();
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
}

package com.giwemirick.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giwemirick.library.model.Author;

public interface AuthorRepository extends JpaRepository <Author, Long>{

}

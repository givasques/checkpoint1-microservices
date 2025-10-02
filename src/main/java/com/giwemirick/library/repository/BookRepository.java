package com.giwemirick.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giwemirick.library.model.Book;

public interface BookRepository extends JpaRepository <Book, Long>{

}

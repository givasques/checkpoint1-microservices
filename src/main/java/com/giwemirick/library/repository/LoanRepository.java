package com.giwemirick.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giwemirick.library.model.Loan;

public interface LoanRepository extends JpaRepository <Loan, Long>{

}

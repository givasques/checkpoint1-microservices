package com.giwemirick.library.dto;

import java.time.LocalDate;

import com.giwemirick.library.model.Book;
import com.giwemirick.library.model.Loan;

public class LoanRequestUpdate {
    private String borrowerName;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private Long bookId;

    public Loan toModel(Loan loan, Book book) {
        loan.setBorrowerName(borrowerName);
        loan.setLoanDate(loanDate);
        loan.setReturnDate(returnDate);
        loan.setBook(book);
        return loan;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}

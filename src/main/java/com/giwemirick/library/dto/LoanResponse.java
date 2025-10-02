    package com.giwemirick.library.dto;

    import java.time.LocalDate;

    import com.giwemirick.library.model.Loan;

    public class LoanResponse {
        private Long id;
        private String borrowerName;
        private LocalDate loanDate;
        private LocalDate returnDate;
        private BookResponse book;

        public LoanResponse toDto(Loan loan) {
            this.id = loan.getId();
            this.borrowerName = loan.getBorrowerName();
            this.loanDate = loan.getLoanDate();
            this.returnDate = loan.getReturnDate();
            this.book = new BookResponse().toDto(loan.getBook());
            return this;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

        public BookResponse getBook() {
            return book;
        }

        public void setBook(BookResponse bookResponse) {
            this.book = bookResponse;
        }
    }

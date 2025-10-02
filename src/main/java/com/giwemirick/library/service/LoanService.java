package com.giwemirick.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giwemirick.library.dto.LoanRequestCreate;
import com.giwemirick.library.dto.LoanRequestUpdate;
import com.giwemirick.library.model.Book;
import com.giwemirick.library.model.Loan;
import com.giwemirick.library.repository.BookRepository;
import com.giwemirick.library.repository.LoanRepository;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;

    public Loan createLoan (LoanRequestCreate dto) {
        Book book = bookRepository.findById(dto.getBookId())
        .orElseThrow(() -> new RuntimeException(
                        "Inexistent Book - ID: " + dto.getBookId()));

        return loanRepository.save(dto.toModel(book));
    }

    public Boolean deleteLoan (Long id) {
        if (loanRepository.findById(id).isPresent()) {
            loanRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Loan> updateLoan(Long id, LoanRequestUpdate dto) {
        return loanRepository.findById(id).map(
                l -> {
                    Book book = bookRepository.findById(dto.getBookId())
                            .orElseThrow(() -> new RuntimeException(
                                    "Inexistent Book! ID: "));
                    return loanRepository.save(dto.toModel(l, book));
                });
    }

    public Optional <Loan> getLoanById (Long id) {
        return loanRepository.findById(id);
    }

    public List<Loan> getAll () {
        return loanRepository.findAll();
    }

}

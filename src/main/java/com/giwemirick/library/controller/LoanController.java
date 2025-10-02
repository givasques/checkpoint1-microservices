package com.giwemirick.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giwemirick.library.dto.LoanRequestCreate;
import com.giwemirick.library.dto.LoanRequestUpdate;
import com.giwemirick.library.dto.LoanResponse;
import com.giwemirick.library.service.LoanService;

@RestController
@RequestMapping ("loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(@RequestBody LoanRequestCreate dto) {
        return ResponseEntity.status(201).body(new LoanResponse().toDto(loanService.createLoan(dto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<LoanResponse> updateLoan(@PathVariable Long id, @RequestBody LoanRequestUpdate dto) {
        return loanService.updateLoan(id, dto)
            .map(l -> new LoanResponse().toDto(l))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        if (loanService.deleteLoan(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<LoanResponse> getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id)
            .map(l -> new LoanResponse().toDto(l))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAll() {
        List<LoanResponse> loans = loanService.getAll().stream()
            .map(l -> new LoanResponse().toDto(l))
            .toList();

        return ResponseEntity.ok().body(loans);
    }
}


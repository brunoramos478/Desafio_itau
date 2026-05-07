package com.br.bruno.desafio.itau.adapter.in.web;

import com.br.bruno.desafio.itau.application.service.TransactionService;
import com.br.bruno.desafio.itau.shared.dto.TransactionDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        transactionService.createTransaction(transactionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        return ResponseEntity.noContent().build();
    }

}

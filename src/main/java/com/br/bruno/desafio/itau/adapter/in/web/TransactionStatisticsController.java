package com.br.bruno.desafio.itau.adapter.in.web;

import com.br.bruno.desafio.itau.application.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("estatistica")
public class TransactionStatisticsController {
    private final TransactionService transactionService;

    public TransactionStatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping
    public ResponseEntity<DoubleSummaryStatistics> getStatistics() {
        DoubleSummaryStatistics statistics = transactionService.getStatistics();
        return ResponseEntity.ok(statistics);
    }

}

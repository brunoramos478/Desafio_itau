package com.br.bruno.desafio.itau.adapter.in.web;

import com.br.bruno.desafio.itau.application.service.TransactionService;
import com.br.bruno.desafio.itau.shared.dto.StatisticsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
@RequiredArgsConstructor
public class TransactionStatisticsController {

    private final TransactionService transactionService;
    @GetMapping
    public ResponseEntity<StatisticsResponseDto> getStatistics() {
        StatisticsResponseDto response = transactionService.getStatistics();
        return ResponseEntity.ok(response);
    }

}

package com.br.bruno.desafio.itau.application.service;

import com.br.bruno.desafio.itau.shared.dto.StatisticsResponseDto;
import com.br.bruno.desafio.itau.shared.dto.TransactionDto;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService {

    private final Queue<TransactionDto> transaction = new ConcurrentLinkedDeque<>();

    public void createTransaction(TransactionDto transactionDto) {
        if (transactionDto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException();
        }
        transaction.add(transactionDto);
    }

    public void clearTransactions() {
        transaction.clear();
    }

    public StatisticsResponseDto getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();

        OffsetDateTime timeLimit = now.minusSeconds(60);
        transaction.removeIf(t -> t.dataHora().isBefore(timeLimit));

        DoubleSummaryStatistics stats = transaction.stream()
                .mapToDouble(t -> t.valor().doubleValue())
                .summaryStatistics();

        if (stats.getCount() == 0) {
            return StatisticsResponseDto.builder()
                    .sum(0.0)
                    .avg(0.0)
                    .max(0.0)
                    .min(0.0)
                    .count(0L)
                    .build();
        }

        return StatisticsResponseDto.builder()
                .sum(stats.getSum())
                .avg(stats.getAverage())
                .max(stats.getMax())
                .min(stats.getMin())
                .count(stats.getCount())
                .build();
    }
}

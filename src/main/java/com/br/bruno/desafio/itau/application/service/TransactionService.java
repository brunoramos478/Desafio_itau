package com.br.bruno.desafio.itau.application.service;

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
        if (transactionDto.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException();
        }
        transaction.add(transactionDto);
    }

    public void clearTransactions() {
        transaction.clear();
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        DoubleSummaryStatistics stats = transaction.stream()
                .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        if (stats.getCount() == 0) {
            return new DoubleSummaryStatistics();
        }

        return stats;
    }
}

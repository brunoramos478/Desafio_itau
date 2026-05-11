package com.br.bruno.desafio.itau.shared.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
public record TransactionDto(

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Positive
    @Getter
    BigDecimal valor,

    @NotNull
    @Getter
    OffsetDateTime dataHora

    ) {}

package com.br.bruno.desafio.itau.shared.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
public record TransactionDto(

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @PositiveOrZero
    BigDecimal valor,

    @NotNull
    OffsetDateTime dataHora

    ) {}

package com.br.bruno.desafio.itau.shared.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class TransactionDto {
    @NotNull
    @PositiveOrZero
    @DecimalMin(value = "0.0", inclusive = false)
    @Positive
    private BigDecimal valor;

    @NotNull
    private OffsetDateTime dataHora;

}

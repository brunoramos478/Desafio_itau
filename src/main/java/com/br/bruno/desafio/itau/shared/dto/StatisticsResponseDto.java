package com.br.bruno.desafio.itau.shared.dto;

import lombok.Builder;

@Builder
public record StatisticsResponseDto(
        Double sum,
        Double avg,
        Double max,
        Double min,
        Long count
) {}

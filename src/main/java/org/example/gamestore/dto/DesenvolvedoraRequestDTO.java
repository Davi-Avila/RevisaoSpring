package org.example.gamestore.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DesenvolvedoraRequestDTO(
        @NotBlank(message = "Insira o nome da desenvolvedora")
        String nome,

        @NotBlank(message = "Insira o país da desenvolvedora")
        String pais,

        @NotNull(message = "Insira um ano de fundação")
        @Min(value = 0, message = "Insira um ano válido(maior que 0)")
        @Max(value = 2026, message = "Insira um ano válido(menor que 2026)")
        Integer anoFundacao
) {}

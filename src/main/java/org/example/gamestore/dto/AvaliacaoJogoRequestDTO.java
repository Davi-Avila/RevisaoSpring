package org.example.gamestore.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoJogoRequestDTO(
        @DecimalMin("0.00")
        @DecimalMax("10.00")
        @NotNull(message = "Insira um nota para o jogo")
        Double nota,
        String comentario,

        @NotNull(message = "Insira o id do jogo")
        Long idJogo
) {
}

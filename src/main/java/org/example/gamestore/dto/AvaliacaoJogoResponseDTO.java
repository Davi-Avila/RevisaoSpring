package org.example.gamestore.dto;

public record AvaliacaoJogoResponseDTO(
        Double nota,
        String comentario,
        Long idJogo,
        String titulo
) {
}

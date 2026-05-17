package org.example.gamestore.dto;

public record JogoResponseDTO(
        String titulo,
        String genero,
        Double preco,
        Integer classificacaoIndicativa,
        String descricao,
        Long id
){}

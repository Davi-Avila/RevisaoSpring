package org.example.gamestore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JogoRequestDTO(
        @NotBlank(message = "Insira o título do jogo")
        String titulo,

        @NotBlank(message = "Insira o gênero do jogo")
        String genero,

        @NotNull(message = "Insira o preço do jogo")
        @Min(value = 0, message = "Insira um preço válido")
        Double preco,

        @NotNull(message = "Insira uma classifcação indicativa")
        @Min(value = 0, message = "Insira um classificação indicativa válida")
        Integer classificacaoIndicativa,

        String descricao,

        @NotNull(message = "Insira o id da desenvolvedora")
        Long id
){}

package org.example.gamestore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogo;

    private String titulo;
    private String genero;
    private Double preco;
    private Integer classificacaoIndicativa;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idDesenvolvedora")
    private Desenvolvedora desenvolvedora;
}

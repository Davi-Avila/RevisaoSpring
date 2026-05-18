package org.example.gamestore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AvaliacaoJogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    private Double nota;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idJogo")
    private Jogo jogo;
}

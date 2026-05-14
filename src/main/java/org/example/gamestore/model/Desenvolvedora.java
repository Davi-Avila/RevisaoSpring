package org.example.gamestore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Desenvolvedora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String pais;
    private Integer anoFundacao;

    @OneToMany(mappedBy = "desenvolvedora")
    private List<Jogo> jogos =new ArrayList<>();

    public Desenvolvedora(){}
}

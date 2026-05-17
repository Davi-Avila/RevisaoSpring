package org.example.gamestore.repository;

import org.example.gamestore.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository <Jogo, Long>{
    List<Jogo> findByDesenvolvedoraId(Long id);
}

package org.example.gamestore.repository;

import org.example.gamestore.model.AvaliacaoJogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoJogoRepository extends JpaRepository<AvaliacaoJogo, Long> {
    List<AvaliacaoJogo> findAvaliacaoJogoIdJogo(Long id);
}

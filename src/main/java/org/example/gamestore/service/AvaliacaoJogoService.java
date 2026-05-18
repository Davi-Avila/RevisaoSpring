package org.example.gamestore.service;

import org.example.gamestore.dto.AvaliacaoJogoRequestDTO;
import org.example.gamestore.dto.AvaliacaoJogoResponseDTO;
import org.example.gamestore.exception.RecursoNaoEncontradoException;
import org.example.gamestore.model.AvaliacaoJogo;
import org.example.gamestore.model.Jogo;
import org.example.gamestore.repository.AvaliacaoJogoRepository;
import org.example.gamestore.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoJogoService {
    @Autowired
    private AvaliacaoJogoRepository avaliacaoJogoRepository;
    private JogoService jogoService;
    private JogoRepository jogoRepository;

    public AvaliacaoJogoResponseDTO salvar(AvaliacaoJogoRequestDTO dto){
        AvaliacaoJogo avaliacaoJogo = toEntity(dto);
        AvaliacaoJogo salvo = avaliacaoJogoRepository.save(avaliacaoJogo);
        return toResponseDTO(salvo);
    }

    public List<AvaliacaoJogoResponseDTO> listarAvaliacoesPorId(Long id){
        jogoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Jogo não encontrado"));

        return avaliacaoJogoRepository.findAvaliacaoJogoIdJogo(id)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public AvaliacaoJogo toEntity(AvaliacaoJogoRequestDTO dto){
        Jogo jogo = jogoService.buscarEntidade(dto.idJogo());
        AvaliacaoJogo avaliacaoJogo = new AvaliacaoJogo();
        avaliacaoJogo.setNota(dto.nota());
        avaliacaoJogo.setComentario(dto.comentario());
        avaliacaoJogo.setJogo(jogo);
        return avaliacaoJogo;
    }

    public AvaliacaoJogoResponseDTO toResponseDTO(AvaliacaoJogo avaliacaoJogo){
        return new AvaliacaoJogoResponseDTO(
                avaliacaoJogo.getNota(),
                avaliacaoJogo.getComentario(),
                avaliacaoJogo.getJogo().getIdJogo(),
                avaliacaoJogo.getJogo().getTitulo()
        );
    }

}

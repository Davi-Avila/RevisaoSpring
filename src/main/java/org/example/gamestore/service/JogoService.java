package org.example.gamestore.service;

import org.example.gamestore.dto.JogoRequestDTO;
import org.example.gamestore.dto.JogoResponseDTO;
import org.example.gamestore.exception.RecursoNaoEncontradoException;
import org.example.gamestore.model.Desenvolvedora;
import org.example.gamestore.model.Jogo;
import org.example.gamestore.repository.DesenvolvedoraRepository;
import org.example.gamestore.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;
    private DesenvolvedoraService desenvolvedoraService;
    private DesenvolvedoraRepository desenvolvedoraRepository;

    public JogoResponseDTO salvar(JogoRequestDTO dto){
        Jogo jogo = toEntity(dto);
        Jogo salvo = jogoRepository.save(jogo);
        return toResponseDTO(salvo);
    }

    public List<JogoResponseDTO> listarPorDesenvolvedora(Long id){
        desenvolvedoraRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Desenvolvedora não encontrada"));

        return jogoRepository.findByDesenvolvedoraId(id)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private Jogo toEntity(JogoRequestDTO dto){
        Desenvolvedora desenvolvedora = desenvolvedoraService.buscarEntidade(dto.id());
        Jogo jogo = new Jogo();
        jogo.setTitulo(dto.titulo());
        jogo.setGenero(dto.genero());
        jogo.setPreco(dto.preco());
        jogo.setClassificacaoIndicativa(dto.classificacaoIndicativa());
        jogo.setDescricao(dto.descricao());
        jogo.setDesenvolvedora(desenvolvedora);
        return jogo;
    }

    private JogoResponseDTO toResponseDTO(Jogo jogo){
        return new JogoResponseDTO(
                jogo.getTitulo(),
                jogo.getGenero(),
                jogo.getPreco(),
                jogo.getClassificacaoIndicativa(),
                jogo.getDescricao(),
                jogo.getDesenvolvedora().getId()
        );
    }


}

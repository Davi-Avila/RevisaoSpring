package org.example.gamestore.service;

import org.example.gamestore.dto.DesenvolvedoraRequestDTO;
import org.example.gamestore.dto.DesenvolvedoraResponseDTO;
import org.example.gamestore.exception.RecursoNaoEncontradoException;
import org.example.gamestore.model.Desenvolvedora;
import org.example.gamestore.repository.DesenvolvedoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class DesenvolvedoraService {
    @Autowired
    private DesenvolvedoraRepository repository;

    public DesenvolvedoraResponseDTO salvar(DesenvolvedoraRequestDTO dto){
        Desenvolvedora desenvolvedora = toEntity(dto);
        Desenvolvedora salvo =repository.save(desenvolvedora);
        return toResponseDTO(salvo);

    }

    public DesenvolvedoraResponseDTO buscarPorId(Long id){
        Desenvolvedora desenvolvedora = repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Desenvolvedora não encontrada"));
        return toResponseDTO(desenvolvedora);
    }

    public List<DesenvolvedoraResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public DesenvolvedoraResponseDTO atualizar(Long id, DesenvolvedoraRequestDTO dto){
        Desenvolvedora existente = repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Desenvolvedora não encontrada"));
        existente.setNome(dto.nome());
        existente.setPais(dto.pais());
        existente.setAnoFundacao(dto.anoFundacao());
        Desenvolvedora atualizado = repository.save(existente);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long id){
        Desenvolvedora desenvolvedora =repository.findById(id).orElseThrow(() -> new RuntimeException("Desenvolvedora não encontrada"));
        repository.delete(desenvolvedora);
    }

    private Desenvolvedora toEntity(DesenvolvedoraRequestDTO dto) {
        Desenvolvedora desenvolvedora = new Desenvolvedora();
        desenvolvedora.setNome(dto.nome());
        desenvolvedora.setPais(dto.pais());
        desenvolvedora.setAnoFundacao(dto.anoFundacao());
        return desenvolvedora;
    }

    private DesenvolvedoraResponseDTO toResponseDTO(Desenvolvedora desenvolvedora){
        return new DesenvolvedoraResponseDTO(
                desenvolvedora.getId(),
                desenvolvedora.getNome(),
                desenvolvedora.getPais(),
                desenvolvedora.getAnoFundacao()
        );
    }


}

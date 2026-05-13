package org.example.gamestore.service;

import org.example.gamestore.dto.DesenvolvedoraRequestDTO;
import org.example.gamestore.dto.DesenvolvedoraResponseDTO;
import org.example.gamestore.model.Desenvolvedora;
import org.example.gamestore.repository.DesenvolvedoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesenvolvedoraService {
    @Autowired
    private DesenvolvedoraRepository repository;

    public DesenvolvedoraResponseDTO salvar(DesenvolvedoraRequestDTO dto){
        Desenvolvedora desenvolvedora = toEntity(dto);
        Desenvolvedora salvo =repository.save(desenvolvedora);
        return toResponseDTO(salvo);

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

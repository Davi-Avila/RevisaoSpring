package org.example.gamestore.controller;

import org.example.gamestore.dto.JogoRequestDTO;
import org.example.gamestore.dto.JogoResponseDTO;
import org.example.gamestore.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @PostMapping
    public JogoResponseDTO salvar(JogoRequestDTO dto){
        return jogoService.salvar(dto);
    }

    @GetMapping("/{id}/jogos")
    public List<JogoResponseDTO> listarPorDesenvolvedora(Long id){
        return jogoService.listarPorDesenvolvedora(id);
    }
}

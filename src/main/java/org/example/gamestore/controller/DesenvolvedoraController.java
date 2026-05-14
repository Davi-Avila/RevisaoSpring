package org.example.gamestore.controller;

import jakarta.validation.Valid;
import org.example.gamestore.dto.DesenvolvedoraRequestDTO;
import org.example.gamestore.dto.DesenvolvedoraResponseDTO;
import org.example.gamestore.model.Desenvolvedora;
import org.example.gamestore.service.DesenvolvedoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desenvolvedoras")
public class DesenvolvedoraController {
    @Autowired
    private DesenvolvedoraService service;

    @PostMapping
    public DesenvolvedoraResponseDTO salvar(@RequestBody DesenvolvedoraRequestDTO dto){
        return service.salvar(dto);
    }

    @GetMapping
    public List<DesenvolvedoraResponseDTO> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public DesenvolvedoraResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public DesenvolvedoraResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid DesenvolvedoraRequestDTO dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}

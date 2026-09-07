package com.gustadev.AutoPDF.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustadev.AutoPDF.DTO.MembroRequest;
import com.gustadev.AutoPDF.Model.Membro;
import com.gustadev.AutoPDF.Services.MembroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/membros")
public class MembroController {

    private final MembroService membroService;

    public MembroController(MembroService membroService){
        this.membroService = membroService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Membro> criar(@RequestBody @Valid MembroRequest dto){
        Membro membro = membroService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(membro);
    }
    @GetMapping ("/listar")
    public ResponseEntity<List<Membro>> listarTodos() {
        List <Membro> membros = membroService.listarTodos();
        return ResponseEntity.ok(membros);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Membro> deletar(@PathVariable Long id){
        membroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

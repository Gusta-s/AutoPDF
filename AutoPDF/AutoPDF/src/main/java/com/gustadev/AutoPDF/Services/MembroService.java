package com.gustadev.AutoPDF.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustadev.AutoPDF.DTO.MembroRequest;
import com.gustadev.AutoPDF.Model.Membro;
import com.gustadev.AutoPDF.Repository.MembroRepository;

import jakarta.transaction.Transactional;


@Service  
public class MembroService {
    private final MembroRepository membrorepository;

    public MembroService(MembroRepository membrorepository){
        this.membrorepository = membrorepository;
    }
    @Transactional 
    public Membro salvar(MembroRequest dto){
        if (membrorepository.existsByNomeAndCargo(dto.nome(),dto.cargo())) {
            throw new RuntimeException("Já existe um membro cadastrado");
        }
        Membro membro = new Membro();
        membro.setNome(dto.nome());
        membro.setCargo(dto.cargo());
        return membrorepository.save(membro);
    }
    public List<Membro> listarTodos(){
            return membrorepository.findAll();
        }
    @Transactional
    public void deletar(Long id){
        if (!membrorepository.existsById(id)) {
            throw new RuntimeException("Não existe um membro cadastrado com ID");
        }
        membrorepository.deleteById(id);
    }
    @Transactional
    public Membro alteraMembro(Long id,MembroRequest dto){
        if (!membrorepository.existsByNomeAndCargo(dto.nome(),dto.cargo())) {
            throw new RuntimeException("Não existe um membro cadastrado com esses dados: Nome e Cargo");
        }
        //tenta achar essa cara pelo id, senão conseguir manda erro
        Membro membro = membrorepository.findById(id).orElseThrow(() -> new RuntimeException("Membro não encontrado por ID"));
        membro.setNome(dto.nome());
        membro.setCargo(dto.cargo());
        return membrorepository.save(membro);
    }
}

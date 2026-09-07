package com.gustadev.AutoPDF.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity  
@Table (name="membro")
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100, message = "O nome deve ter no minimo 10 caracteres")
    @Column(length = 130, nullable = false)
    private String nome;

    @NotBlank
    @Size(min = 3, max = 100, message = "O nome deve ter no minimo 10 caracteres")
    @Column(length = 130, nullable = false)
    private String cargo;

    public Membro(){
    }
    public Membro(String nome, String cargo){
        this.nome = nome;
        this.cargo = cargo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    

}

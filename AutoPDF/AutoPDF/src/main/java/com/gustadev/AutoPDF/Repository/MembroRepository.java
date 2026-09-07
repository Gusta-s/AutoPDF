package com.gustadev.AutoPDF.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gustadev.AutoPDF.Model.Membro;


@Repository 
public interface MembroRepository extends JpaRepository<Membro, Long>{
    boolean existsByNomeAndCargo(String nome, String cargo);
}

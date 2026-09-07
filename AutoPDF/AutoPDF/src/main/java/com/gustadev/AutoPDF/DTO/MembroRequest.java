package com.gustadev.AutoPDF.DTO;

import jakarta.validation.constraints.NotBlank;

public record MembroRequest(
    @NotBlank 
    String nome,
    @NotBlank 
    String cargo
) {}
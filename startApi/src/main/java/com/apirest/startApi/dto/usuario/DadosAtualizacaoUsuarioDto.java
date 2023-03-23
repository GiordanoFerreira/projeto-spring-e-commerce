package com.apirest.startApi.dto.usuario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoUsuarioDto(
        @NotNull Long id,
        
        String email,
        
        String senha,
        
        @Pattern(regexp = "\\d{13}")
        String telefone) {

}

package com.apirest.startApi.dto.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuarioDto(
        @NotNull Long id,
        
        String email,
        
        String senha) {

}

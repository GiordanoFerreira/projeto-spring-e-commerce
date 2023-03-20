package com.apirest.startApi.models.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull Long id,
        
        String email,
        
        String senha) {

}

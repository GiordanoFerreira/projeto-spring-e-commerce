package com.apirest.startApi.dto.usuario;

import com.apirest.startApi.models.Usuario;

public record DadosListagemUsuarioDto(Long id, String nome, String email, String senha, String cpf, boolean ativo) {
    
    public DadosListagemUsuarioDto(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getCpf(), usuario.isAtivo());
    }
}

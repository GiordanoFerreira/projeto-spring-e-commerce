package com.apirest.startApi.models.usuario;

public record DadosListagemUsuario(Long id, String nome, String email, String senha, String cpf, boolean ativo) {
    
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getCpf(), usuario.isAtivo());
    }
}

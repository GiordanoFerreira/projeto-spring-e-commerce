package com.apirest.startApi.model.usuario;

import java.util.List;

import com.apirest.startApi.model.endereco.Endereco;

public record DadosCadastroUsuario(String nome, String email, String senha, String cpf, List<Endereco> enderecos) {

}

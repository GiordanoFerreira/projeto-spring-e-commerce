package com.apirest.startApi.model.usuario;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private boolean ativo;
    // private List<Endereco> enderecos;
}

package com.apirest.startApi.models.usuario;

import java.util.List;

import com.apirest.startApi.models.endereco.Endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(

        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senha,
        @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
        @NotNull @Valid List<Endereco> enderecos) {

}

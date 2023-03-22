package com.apirest.startApi.dto.usuario;

import java.util.List;

import com.apirest.startApi.models.Endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuarioDto(

        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senha,
        @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
        @NotNull @Valid List<Endereco> enderecos) {

}

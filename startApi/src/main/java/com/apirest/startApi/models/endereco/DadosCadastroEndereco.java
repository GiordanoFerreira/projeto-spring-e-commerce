package com.apirest.startApi.models.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(
        @NotBlank String logradouro,
        @NotBlank String cidade,
        @NotBlank String uf,
        String complemento,
        @NotBlank String numero,
        @NotBlank String bairro,
        @NotBlank @Pattern(regexp = "\\d{8}") String cep) {

}

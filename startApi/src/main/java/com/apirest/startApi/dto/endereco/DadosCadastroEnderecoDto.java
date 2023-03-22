package com.apirest.startApi.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEnderecoDto(
        @NotBlank String logradouro,
        @NotBlank String cidade,
        @NotBlank String uf,
        String complemento,
        @NotBlank String numero,
        @NotBlank String bairro,
        @NotBlank @Pattern(regexp = "\\d{8}") String cep) {

}

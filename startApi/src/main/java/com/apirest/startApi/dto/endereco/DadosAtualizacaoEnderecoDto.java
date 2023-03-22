package com.apirest.startApi.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEnderecoDto(
    
    
    @NotNull Long id,
    @NotBlank String logradouro,
    @NotBlank String cidade,
    @NotBlank String uf,
    String complemento,
    @NotBlank String numero,
    @NotBlank String bairro,
    @NotBlank String cep) {


}

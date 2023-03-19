package com.apirest.startApi.models.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
    
    
    @NotNull Long id,
    @NotBlank String logradouro,
    @NotBlank String cidade,
    @NotBlank String uf,
    String complemento,
    @NotBlank String numero,
    @NotBlank String bairro,
    @NotBlank String cep) {


}

package com.apirest.startApi.dto.fornecedor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFornecedorDto(
        @NotNull Long id,
        
        String nome,
        
        String cnpj_cpf) {

}

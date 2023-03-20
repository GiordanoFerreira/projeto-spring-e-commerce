package com.apirest.startApi.models.fornecedor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFornecedor(
        @NotNull Long id,
        
        String nome,
        
        String cnpj_cpf) {

}

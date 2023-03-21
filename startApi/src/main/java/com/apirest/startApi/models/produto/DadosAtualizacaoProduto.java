package com.apirest.startApi.models.produto;

import com.apirest.startApi.models.fornecedor.DadosAtualizacaoFornecedor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
        @NotNull Long id,
        
        String nome,
        
        String descricao,
        
        double preco,
        
        Integer estoque,
        
        DadosAtualizacaoFornecedor fornecedor) {

}

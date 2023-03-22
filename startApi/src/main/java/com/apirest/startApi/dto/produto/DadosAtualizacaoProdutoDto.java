package com.apirest.startApi.dto.produto;

import com.apirest.startApi.dto.fornecedor.DadosAtualizacaoFornecedorDto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProdutoDto(
        @NotNull Long id,
        
        String nome,
        
        String descricao,
        
        double preco,
        
        Integer estoque,
        
        DadosAtualizacaoFornecedorDto fornecedor) {

}

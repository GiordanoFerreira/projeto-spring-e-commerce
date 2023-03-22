package com.apirest.startApi.dto.produto;

import com.apirest.startApi.models.Produto;

public record DadosListagemProdutoDto(Long id, String nome, String descricao, double preco, Integer estoque) {
    
    public DadosListagemProdutoDto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getEstoque());
    }
}

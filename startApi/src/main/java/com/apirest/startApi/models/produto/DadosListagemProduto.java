package com.apirest.startApi.models.produto;

public record DadosListagemProduto(Long id, String nome, String descricao, double preco, Integer estoque) {
    
    public DadosListagemProduto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getEstoque());
    }
}

package com.apirest.startApi.models.fornecedor;

public record DadosListagemFornecedor(Long id, String nome, String cnpj_cpf) {

    public DadosListagemFornecedor(Fornecedor fornecedor){
        this(fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpj_cpf());
    }
}

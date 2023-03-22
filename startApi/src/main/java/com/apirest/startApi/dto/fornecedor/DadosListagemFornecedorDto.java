package com.apirest.startApi.dto.fornecedor;

import com.apirest.startApi.models.Fornecedor;

public record DadosListagemFornecedorDto(Long id, String nome, String cnpj_cpf) {

    public DadosListagemFornecedorDto(Fornecedor fornecedor){
        this(fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpj_cpf());
    }
}

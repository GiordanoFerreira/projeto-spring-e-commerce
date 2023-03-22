package com.apirest.startApi.dto.endereco;

import com.apirest.startApi.models.Endereco;

public record DadosListagemEnderecoDto(Long id, String logradouro, String cidade, String uf, String complemento, String numero, String bairro, String cep) {

    public DadosListagemEnderecoDto(Endereco endereco){
        this(endereco.getId(),  endereco.getLogradouro(),  endereco.getCidade(), endereco.getUf(), endereco.getComplemento(), endereco.getNumero(), endereco.getBairro(), endereco.getCep());
    }
}

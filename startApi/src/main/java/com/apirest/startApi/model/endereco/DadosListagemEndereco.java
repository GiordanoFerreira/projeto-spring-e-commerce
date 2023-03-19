package com.apirest.startApi.model.endereco;

public record DadosListagemEndereco(Long id, String logradouro, String cidade, String uf, String complemento, String numero, String bairro, String cep) {

    public DadosListagemEndereco(Endereco endereco){
        this(endereco.getId(), endereco.getUf(), endereco.getNumero(), endereco.getLogradouro(), endereco.getComplemento(), endereco.getCidade(), endereco.getCep(), endereco.getBairro());
    }
}

package com.apirest.startApi.model.endereco;

public record DadosListagemEndereco(Long id, String logradouro, String cidade, String uf, String complemento, String numero, String bairro, String cep) {

    public DadosListagemEndereco(Endereco endereco){
        this(endereco.getId(),  endereco.getLogradouro(),  endereco.getCidade(), endereco.getUf(), endereco.getComplemento(), endereco.getNumero(), endereco.getBairro(), endereco.getCep());
    }
}

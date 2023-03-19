package com.apirest.startApi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.model.endereco.DadosCadastroEndereco;
import com.apirest.startApi.model.endereco.DadosListagemEndereco;
import com.apirest.startApi.model.endereco.Endereco;
import com.apirest.startApi.repository.EnderecoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody DadosCadastroEndereco dados) {
        repository.save(new Endereco(dados));
    }

    @GetMapping
    public Page<DadosListagemEndereco> listar(@PageableDefault(sort = {"id"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemEndereco::new);
    }
}

package com.apirest.startApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.models.endereco.DadosAtualizacaoEndereco;
import com.apirest.startApi.models.endereco.DadosCadastroEndereco;
import com.apirest.startApi.models.endereco.DadosListagemEndereco;
import com.apirest.startApi.models.endereco.Endereco;
import com.apirest.startApi.repository.EnderecoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroEndereco dados) {
        repository.save(new Endereco(dados));
    }

    @GetMapping
    public Page<DadosListagemEndereco> listar(@PageableDefault(sort = {"id"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemEndereco::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoEndereco dados){
        var endereco = repository.getReferenceById(dados.id());
        endereco.atualizarEndereco(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.dto.endereco.DadosAtualizacaoEnderecoDto;
import com.apirest.startApi.dto.endereco.DadosCadastroEnderecoDto;
import com.apirest.startApi.dto.endereco.DadosListagemEnderecoDto;
import com.apirest.startApi.services.EnderecoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroEnderecoDto dados) {
        service.cadastro(dados);
    }

    @GetMapping
    public Page<DadosListagemEnderecoDto> listar(@PageableDefault(sort = { "id" }) Pageable paginacao) {
        Page<DadosListagemEnderecoDto> result = service.listar(paginacao);
        return result;
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoEnderecoDto dados) {
        service.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}

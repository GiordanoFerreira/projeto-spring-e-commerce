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

import com.apirest.startApi.dto.fornecedor.DadosAtualizacaoFornecedorDto;
import com.apirest.startApi.dto.fornecedor.DadosCadastroFornecedorDto;
import com.apirest.startApi.dto.fornecedor.DadosListagemFornecedorDto;
import com.apirest.startApi.services.FornecedorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorService service;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroFornecedorDto dados){
        service.cadastro(dados);;
    }

    @GetMapping
    public Page<DadosListagemFornecedorDto> listar(@PageableDefault(sort = {"id"}) Pageable paginacao){
        Page<DadosListagemFornecedorDto> result = service.listar(paginacao);
        return result;
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoFornecedorDto dados){
        service.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
}

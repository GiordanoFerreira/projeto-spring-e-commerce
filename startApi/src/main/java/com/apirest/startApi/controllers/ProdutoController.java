package com.apirest.startApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.dto.produto.DadosAtualizacaoProdutoDto;
import com.apirest.startApi.dto.produto.DadosCadastroProdutoDto;
import com.apirest.startApi.dto.produto.DadosListagemProdutoDto;
import com.apirest.startApi.services.ProdutoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroProdutoDto dados){
        service.cadastro(dados);
    }

    @GetMapping
    public Page<DadosListagemProdutoDto> listar(Pageable paginacao){
        Page<DadosListagemProdutoDto> result = service.listar(paginacao);
        return result;
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProdutoDto dados){
        service.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
}

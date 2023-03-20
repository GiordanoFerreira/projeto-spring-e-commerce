package com.apirest.startApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.models.produto.DadosCadastroProduto;
import com.apirest.startApi.models.produto.DadosListagemProduto;
import com.apirest.startApi.models.produto.Produto;
import com.apirest.startApi.repository.ProdutoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroProduto dados){
        repository.save(new Produto(dados));
    }

    @GetMapping
    public Page<DadosListagemProduto> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemProduto :: new);
    }
}

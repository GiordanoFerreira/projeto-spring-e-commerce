package com.apirest.startApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.dto.itemCarrinho.DadosAtualizacaoItemCarrinhoDto;
import com.apirest.startApi.dto.itemCarrinho.DadosCadastroItemCarrinhoDto;
import com.apirest.startApi.services.ItemCarrinhoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/itens")
public class ItemCarrinhoController {

    @Autowired
    private ItemCarrinhoService service;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroItemCarrinhoDto dados) throws Exception {
        service.cadastro(dados);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoItemCarrinhoDto dados) throws Exception {
        service.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}

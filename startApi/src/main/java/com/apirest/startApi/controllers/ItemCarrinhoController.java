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

import com.apirest.startApi.dto.itemCarrinho.DadosCadastroItemCarrinhoDto;
import com.apirest.startApi.models.ItemCarrinho;
import com.apirest.startApi.repository.ItemCarrinhoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/itens")
public class ItemCarrinhoController {
    
    @Autowired
    private ItemCarrinhoRepository repository;

    public void cadastro(@RequestBody @Valid DadosCadastroItemCarrinhoDto dados) {
        repository.save(new ItemCarrinho(dados));
    }
}

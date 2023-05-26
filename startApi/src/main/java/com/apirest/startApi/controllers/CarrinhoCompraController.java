package com.apirest.startApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.dto.carrinhoCompra.DadosCadastroCarrinhoCompraDto;
import com.apirest.startApi.services.CarrinhoCompraService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoCompraController {
    
    @Autowired
    private CarrinhoCompraService service;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroCarrinhoCompraDto dados){
        service.cadastro(dados);
    }
}

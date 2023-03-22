package com.apirest.startApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.repository.CarrinhoCompraRepository;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoCompraController {
    
    @Autowired
    private CarrinhoCompraRepository repository;
}

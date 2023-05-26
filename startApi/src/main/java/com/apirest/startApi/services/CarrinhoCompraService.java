package com.apirest.startApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.apirest.startApi.dto.carrinhoCompra.DadosCadastroCarrinhoCompraDto;
import com.apirest.startApi.models.CarrinhoCompra;
import com.apirest.startApi.repository.CarrinhoCompraRepository;

import jakarta.validation.Valid;

@Service
public class CarrinhoCompraService {
    
    @Autowired
    private CarrinhoCompraRepository repository;

    public void cadastro(@RequestBody @Valid DadosCadastroCarrinhoCompraDto dados){
        repository.save(new CarrinhoCompra(dados));
    }
}

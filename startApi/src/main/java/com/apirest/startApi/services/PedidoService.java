package com.apirest.startApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.startApi.repository.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repository;
}

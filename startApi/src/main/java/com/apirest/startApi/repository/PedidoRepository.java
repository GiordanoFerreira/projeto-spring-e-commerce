package com.apirest.startApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.startApi.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}

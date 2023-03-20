package com.apirest.startApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.startApi.models.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}

package com.apirest.startApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.startApi.models.ItemProduto;

public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Long>{
    
}

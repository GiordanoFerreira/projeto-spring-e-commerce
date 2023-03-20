package com.apirest.startApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.startApi.models.fornecedor.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    
}

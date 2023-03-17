package com.apirest.startApi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.startApi.model.endereco.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
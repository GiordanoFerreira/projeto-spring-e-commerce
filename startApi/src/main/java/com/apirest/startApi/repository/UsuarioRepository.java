package com.apirest.startApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.startApi.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}

package com.apirest.startApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.startApi.models.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}

package com.apirest.startApi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.startApi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);
}

package com.apirest.startApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.model.usuario.DadosCadastroUsuario;
import com.apirest.startApi.model.usuario.Usuario;
import com.apirest.startApi.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody DadosCadastroUsuario dados){
        repository.save(new Usuario(dados));
    }
}

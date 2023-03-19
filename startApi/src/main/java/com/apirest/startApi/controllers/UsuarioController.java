package com.apirest.startApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.models.usuario.DadosAtualizacaoUsuario;
import com.apirest.startApi.models.usuario.DadosCadastroUsuario;
import com.apirest.startApi.models.usuario.DadosListagemUsuario;
import com.apirest.startApi.models.usuario.Usuario;
import com.apirest.startApi.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuario> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemUsuario :: new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

}

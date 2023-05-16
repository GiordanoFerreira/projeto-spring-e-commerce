package com.apirest.startApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.startApi.dto.usuario.DadosAtualizacaoUsuarioDto;
import com.apirest.startApi.dto.usuario.DadosCadastroUsuarioDto;
import com.apirest.startApi.dto.usuario.DadosListagemUsuarioDto;
import com.apirest.startApi.models.Usuario;
import com.apirest.startApi.repository.UsuarioRepository;
import com.apirest.startApi.services.UsuarioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroUsuarioDto dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuarioDto> listar(Pageable paginacao) {
        Page<DadosListagemUsuarioDto> result = service.listar(paginacao);
        return result;
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuarioDto dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
    }
}

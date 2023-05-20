package com.apirest.startApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.apirest.startApi.dto.usuario.DadosAtualizacaoUsuarioDto;
import com.apirest.startApi.dto.usuario.DadosCadastroUsuarioDto;
import com.apirest.startApi.dto.usuario.DadosListagemUsuarioDto;
import com.apirest.startApi.models.Usuario;
import com.apirest.startApi.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public Page<DadosListagemUsuarioDto> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuarioDto :: new);
    }

    public void cadastro(@RequestBody @Valid DadosCadastroUsuarioDto dados){
        repository.save(new Usuario(dados));
    }

    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuarioDto dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

    public void excluir(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
    }
}

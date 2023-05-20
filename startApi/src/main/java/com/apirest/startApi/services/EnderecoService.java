package com.apirest.startApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.apirest.startApi.dto.endereco.DadosAtualizacaoEnderecoDto;
import com.apirest.startApi.dto.endereco.DadosCadastroEnderecoDto;
import com.apirest.startApi.dto.endereco.DadosListagemEnderecoDto;
import com.apirest.startApi.models.Endereco;
import com.apirest.startApi.repository.EnderecoRepository;

import jakarta.validation.Valid;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Page<DadosListagemEnderecoDto> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemEnderecoDto :: new);
    }

    public void cadastro(@RequestBody @Valid DadosCadastroEnderecoDto dados) {
        repository.save(new Endereco(dados));
    }

    public void atualizar(@RequestBody @Valid DadosAtualizacaoEnderecoDto dados){
        var endereco = repository.getReferenceById(dados.id());
        endereco.atualizarEndereco(dados);
    }

    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}

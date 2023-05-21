package com.apirest.startApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.apirest.startApi.dto.fornecedor.DadosAtualizacaoFornecedorDto;
import com.apirest.startApi.dto.fornecedor.DadosCadastroFornecedorDto;
import com.apirest.startApi.dto.fornecedor.DadosListagemFornecedorDto;
import com.apirest.startApi.models.Fornecedor;
import com.apirest.startApi.repository.FornecedorRepository;

import jakarta.validation.Valid;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository repository;

    public Page<DadosListagemFornecedorDto> listar(@PageableDefault(sort = {"id"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemFornecedorDto::new);
    }

    public void cadastro(@RequestBody @Valid DadosCadastroFornecedorDto dados){
        repository.save(new Fornecedor(dados));
    }

    public void atualizar(@RequestBody @Valid DadosAtualizacaoFornecedorDto dados){
        var fornecedor = repository.getReferenceById(dados.id());
        fornecedor.atualizarFornecedor(dados);;
    }

    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}

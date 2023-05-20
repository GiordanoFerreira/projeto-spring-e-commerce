package com.apirest.startApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.apirest.startApi.dto.produto.DadosAtualizacaoProdutoDto;
import com.apirest.startApi.dto.produto.DadosCadastroProdutoDto;
import com.apirest.startApi.dto.produto.DadosListagemProdutoDto;
import com.apirest.startApi.models.Produto;
import com.apirest.startApi.repository.ProdutoRepository;

import jakarta.validation.Valid;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public Page<DadosListagemProdutoDto> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemProdutoDto :: new);
    }

    public void cadastro(@RequestBody @Valid DadosCadastroProdutoDto dados){
        repository.save(new Produto(dados));
    }

    public void atualizar(@RequestBody @Valid DadosAtualizacaoProdutoDto dados){
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarProduto(dados);
    }

    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}

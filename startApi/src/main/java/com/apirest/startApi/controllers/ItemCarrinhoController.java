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

import com.apirest.startApi.dto.itemCarrinho.DadosCadastroItemCarrinhoDto;
import com.apirest.startApi.models.ItemCarrinho;
import com.apirest.startApi.models.Produto;
import com.apirest.startApi.repository.ItemCarrinhoRepository;
import com.apirest.startApi.repository.ProdutoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/itens")
public class ItemCarrinhoController {
    
    @Autowired
    private ItemCarrinhoRepository repositoryItemCarrinhoRepository;

    @Autowired
    private ProdutoRepository repositoryProduto;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroItemCarrinhoDto dados) {
        Produto produtoExistente = repositoryProduto.findById(dados.getIdProduto()).orElse(null);
        if(produtoExistente != null){
            dados.setProduto(produtoExistente);
            dados.setProduto_nome(produtoExistente.getNome());
            dados.setValor(produtoExistente.getPreco());
            repositoryItemCarrinhoRepository.save(new ItemCarrinho(dados));
        }
    }
}

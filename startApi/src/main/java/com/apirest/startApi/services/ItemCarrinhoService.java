package com.apirest.startApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.apirest.startApi.dto.itemCarrinho.DadosAtualizacaoItemCarrinhoDto;
import com.apirest.startApi.dto.itemCarrinho.DadosCadastroItemCarrinhoDto;
import com.apirest.startApi.models.ItemCarrinho;
import com.apirest.startApi.models.Produto;
import com.apirest.startApi.repository.ItemCarrinhoRepository;
import com.apirest.startApi.repository.ProdutoRepository;

import jakarta.validation.Valid;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository repositoryItemCarrinhoRepository;

    @Autowired
    private ProdutoRepository repositoryProduto;

    public void cadastro(@RequestBody @Valid DadosCadastroItemCarrinhoDto dados) throws Exception {
        Produto produtoExistente = repositoryProduto.findById(dados.getProduto().getId()).orElse(null);
        if (produtoExistente != null) {
            if (produtoExistente.getEstoque() < dados.getQuantidade()) {
                throw new Exception("A quantidade no Estoque (" + produtoExistente.getEstoque()
                        + ") não pode ser menor do que a Quantidade requisitada (" + dados.getQuantidade()
                        + ") do produto: " + produtoExistente.getNome());
            }
            dados.setProduto(produtoExistente);
            dados.setProduto_nome(produtoExistente.getNome());
            dados.setValor(produtoExistente.getPreco());

            produtoExistente.setEstoque(produtoExistente.getEstoque() - dados.getQuantidade());
            repositoryProduto.save(produtoExistente);
            repositoryItemCarrinhoRepository.save(new ItemCarrinho(dados));
        }
    }

    public void atualizar(@RequestBody @Valid DadosAtualizacaoItemCarrinhoDto dados) throws Exception {
        ItemCarrinho itemCarrinho = repositoryItemCarrinhoRepository.findById(dados.id()).orElse(null);
        Produto produto = repositoryProduto.findById(itemCarrinho.getProduto().getId()).orElse(null);
        if (itemCarrinho != null) {
            if (dados.quantidade() < 1 || dados.quantidade() > produto.getEstoque()) {
                throw new Exception("Quantidade inválida!");
            }
            produto.setEstoque(itemCarrinho.getQuantidade() - dados.quantidade() + produto.getEstoque());
            itemCarrinho.setQuantidade(dados.quantidade());
            repositoryItemCarrinhoRepository.save(itemCarrinho);
            repositoryProduto.save(produto);
        }
    }

    public void excluir(@PathVariable Long id) {
        ItemCarrinho itemCarrinhoExistente = repositoryItemCarrinhoRepository.findById(id).orElse(null);
        Produto produtoExistente = repositoryProduto.findById(itemCarrinhoExistente.getProduto().getId()).orElse(null);
        if (itemCarrinhoExistente != null) {
            produtoExistente.setEstoque(produtoExistente.getEstoque() + itemCarrinhoExistente.getQuantidade());
            repositoryProduto.save(produtoExistente);

            repositoryItemCarrinhoRepository.deleteById(id);
        }
    }

}

package com.apirest.startApi.models;

import com.apirest.startApi.dto.itemCarrinho.DadosAtualizacaoItemCarrinhoDto;
import com.apirest.startApi.dto.itemCarrinho.DadosCadastroItemCarrinhoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "itens_carrinhos")
@Entity(name = "ItemCarrinho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemCarrinho {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    private Produto produto;

    private Integer quantidade;

    private String produtoNome;

    private Double valor;

    public ItemCarrinho(DadosCadastroItemCarrinhoDto dados){
        this.produto = dados.getProduto();
        this.quantidade = dados.getQuantidade();
        this.produtoNome = dados.getProduto_nome();
        this.valor = dados.getValor();
    }

    public void atualizarItemCarrinho(DadosAtualizacaoItemCarrinhoDto dados){
        if(dados.quantidade() != null){
            this.quantidade = dados.quantidade();
        }
    }
}

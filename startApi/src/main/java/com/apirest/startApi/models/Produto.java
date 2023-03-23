package com.apirest.startApi.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.apirest.startApi.dto.produto.DadosAtualizacaoProdutoDto;
import com.apirest.startApi.dto.produto.DadosCadastroProdutoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private Integer estoque;
    private String dataCadastro;

    @OneToMany(targetEntity = Fornecedor.class, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

    public Produto(DadosCadastroProdutoDto dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.estoque = dados.estoque();
        this.fornecedores = dados.fornecedores();
        this.dataCadastro = new SimpleDateFormat("dd/MM/yyy hh:mm").format(Calendar.getInstance().getTime());
    }

    public void atualizarProduto(DadosAtualizacaoProdutoDto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.preco() != 0) {
            this.preco = dados.preco();
        }
        if (dados.estoque() != 0) {
            this.estoque = dados.estoque();
        }
    }
}

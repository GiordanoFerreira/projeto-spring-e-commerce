package com.apirest.startApi.models;

import com.apirest.startApi.dto.fornecedor.DadosAtualizacaoFornecedorDto;
import com.apirest.startApi.dto.fornecedor.DadosCadastroFornecedorDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "fornecedores")
@Entity(name = "Fornecedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj_cpf;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    private Produto produto;

    public Fornecedor(DadosCadastroFornecedorDto dados){
        this.nome = dados.nome();
        this.cnpj_cpf = dados.cnpj_cpf();
    }

    public void atualizarFornecedor(DadosAtualizacaoFornecedorDto dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.cnpj_cpf() != null){
            this.cnpj_cpf = dados.cnpj_cpf();
        }
    }
}

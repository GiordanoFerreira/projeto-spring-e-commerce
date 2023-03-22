package com.apirest.startApi.models;

import java.util.ArrayList;
import java.util.List;

import com.apirest.startApi.dto.usuario.DadosAtualizacaoUsuarioDto;
import com.apirest.startApi.dto.usuario.DadosCadastroUsuarioDto;

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

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private boolean ativo;

    @OneToMany(targetEntity = Endereco.class, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.PERSIST })
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    public Usuario(DadosCadastroUsuarioDto dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.cpf = dados.cpf();
        this.enderecos = dados.enderecos();
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuarioDto dados) {
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

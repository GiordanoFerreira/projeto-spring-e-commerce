package com.apirest.startApi.models.endereco;

import com.apirest.startApi.models.usuario.Usuario;

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

@Table(name = "enderecos")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;
    private String bairro;
    private String cep;


    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public Endereco(DadosCadastroEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
    }

    public void atualizarEndereco(DadosAtualizacaoEndereco dados){
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if(dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if(dados.cep() != null){
            this.cep = dados.cep();
        }
        if(dados.numero() != null){
            this.numero = dados.numero();
        }
        if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if(dados.uf() != null){
            this.uf = dados.uf();
        }
    }
}

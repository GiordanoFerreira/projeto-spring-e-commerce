package com.apirest.startApi.models;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "carrinhoCompras")
@Entity(name = "CarrinhoCompra")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CarrinhoCompra {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorTotal;
    private Date dataEntrada;
    private Date dataEmissao;
    
    // @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST });
    // List<ItemProduto> : itensProdutos

}

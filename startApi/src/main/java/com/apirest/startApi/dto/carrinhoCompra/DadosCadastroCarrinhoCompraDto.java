package com.apirest.startApi.dto.carrinhoCompra;

import java.util.Date;
import java.util.List;

import com.apirest.startApi.models.ItemCarrinho;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DadosCadastroCarrinhoCompraDto {
    
    @Positive
    private Integer valorTotal;

    private Date dataEntrada;
    private Date dataEmissao;

    private List<ItemCarrinho> itensCarrinho;
}

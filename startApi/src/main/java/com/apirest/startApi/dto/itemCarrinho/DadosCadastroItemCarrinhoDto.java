package com.apirest.startApi.dto.itemCarrinho;

import com.apirest.startApi.models.CarrinhoCompra;
import com.apirest.startApi.models.Produto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DadosCadastroItemCarrinhoDto {

    @NotNull
    private Long idProduto;

    @NotNull
    @Positive
    private Integer quantidade;

    private Produto produto;

    private CarrinhoCompra carrinhoCompra;

    private String produto_nome;

    private Double valor;

    public void setValor(Double valor){
        this.valor = valor * quantidade;
    }
}

package com.apirest.startApi.dto.itemProduto;

import com.apirest.startApi.models.Produto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroItemProdutoDto(

    @NotNull
    Produto produto,
    @NotNull @Positive
    Double quantidade

) {
    
}

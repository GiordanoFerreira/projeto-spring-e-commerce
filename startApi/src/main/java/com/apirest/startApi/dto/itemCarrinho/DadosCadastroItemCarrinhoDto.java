package com.apirest.startApi.dto.itemCarrinho;

import com.apirest.startApi.models.Produto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroItemCarrinhoDto(

    @NotNull
    Produto produto,
    @NotNull @Positive
    Integer quantidade

) {
    
}

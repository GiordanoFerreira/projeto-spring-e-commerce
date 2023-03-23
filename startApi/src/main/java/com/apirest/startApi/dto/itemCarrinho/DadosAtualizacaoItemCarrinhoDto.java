package com.apirest.startApi.dto.itemCarrinho;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosAtualizacaoItemCarrinhoDto(

    @NotNull Long id,

    @NotNull @Positive
    Integer quantidade

) {

}

package com.apirest.startApi.models.produto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProduto(
        @NotBlank String nome,

        @NotBlank String descricao,

        @NotNull @Positive double preco,

        @NotNull @PositiveOrZero Integer estoque) {

}

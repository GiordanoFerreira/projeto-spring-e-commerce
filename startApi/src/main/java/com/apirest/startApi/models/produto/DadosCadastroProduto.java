package com.apirest.startApi.models.produto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

import com.apirest.startApi.models.fornecedor.Fornecedor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProduto(
        @NotBlank String nome,

        @NotBlank String descricao,

        @NotNull @Positive double preco,

        @NotNull @PositiveOrZero Integer estoque,
        
        @NotNull @Valid List<Fornecedor> fornecedores) {

}

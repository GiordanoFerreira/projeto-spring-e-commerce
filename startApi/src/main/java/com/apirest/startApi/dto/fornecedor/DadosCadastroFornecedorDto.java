package com.apirest.startApi.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroFornecedorDto(

    @NotBlank
    String nome,
    @NotBlank @Pattern(regexp = "\\d{11,14}") //11 do CPF e 14 do CNPJ
    String cnpj_cpf ) {

}

create table fornecedores (
    id bigint not null auto_increment,
    nome varchar(50) not null,
    cnpj_cpf varchar(200) not null,

    produto_id bigint,
    primary key(id)
);
create table itens_carrinhos (
    id bigint not null auto_increment,
    produto_nome varchar(50),
    quantidade integer not null,
    valor double null,
    produto_id bigint null,

    primary key(id)
);
create table produtos (
    id bigint not null auto_increment,
    nome varchar(50) not null,
    descricao varchar(200) not null,
    preco double not null,
    estoque integer,

    primary key(id)
);
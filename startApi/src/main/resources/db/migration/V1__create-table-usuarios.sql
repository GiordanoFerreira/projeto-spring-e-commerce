create table usuarios(

    id bigint not null auto_increment,
    nome varchar(50) not null,
    telefone varchar(20) not null,
    email varchar(100) not null unique,
    senha varchar(50) not null,
    cpf varchar(11) not null unique,
    data_cadastro varchar(20) null,
    ativo tinyint not null,

    primary key(id)

);
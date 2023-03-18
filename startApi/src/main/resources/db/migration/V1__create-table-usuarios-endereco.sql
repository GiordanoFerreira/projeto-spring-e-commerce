create table usuarios(

    id bigint not null auto_increment,
    nome varchar(50) not null,
    email varchar(100) not null unique,
    senha varchar(50) not null,
    cpf varchar(11) not null unique,
    ativo tinyint not null,

    primary key(id)

);

create table enderecos(

    id bigint not null auto_increment,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20) not null,
    uf char(2) not null,
    cidade varchar(100) not null,

    usuario_id bigint not null,
    primary key(id)
);

alter table enderecos 
add constraint fk_enderecos_usuarios 
foreign key (usuario_id) 
references usuarios(id); 
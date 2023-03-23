create table pedidos (
    
    id bigint not null auto_increment,
    data_entrada date not null,
    data_emissao date not null,
    desconto double not null,
    valor_total double not null,

    primary key(id)
);
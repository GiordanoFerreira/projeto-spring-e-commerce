create table carrinhos_compras (
    
    id bigint not null auto_increment,
    valor_total double not null,
    data_entrada date not null,
    data_emissao date null,

    primary key(id)
);
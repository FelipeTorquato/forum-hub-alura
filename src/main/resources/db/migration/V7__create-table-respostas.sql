create table respostas
(
    id           bigint       not null auto_increment,
    mensagem     text         not null,
    data_criacao timestamp    not null default current_timestamp,
    solucao      varchar(100) not null default 'NAO_SOLUCIONADO',
    usuario_id   bigint       not null,
    topico_id    bigint       not null,

    primary key (id),

    constraint fk_respostas_usuario_id foreign key (usuario_id) references usuarios (id),
    constraint fk_respostas_topico_id foreign key (topico_id) references topicos (id)
);
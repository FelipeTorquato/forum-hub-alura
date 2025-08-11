create table topicos
(
    id           bigint       not null auto_increment,
    titulo       varchar(255) not null unique,
    mensagem     text         not null,
    data_criacao timestamp    not null default current_timestamp,
    status       varchar(20)  not null,
    usuario_id   bigint       not null,
    curso_id     bigint       not null,

    primary key (id)
);
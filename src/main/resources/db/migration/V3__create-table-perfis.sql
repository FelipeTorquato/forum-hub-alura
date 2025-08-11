create table perfis
(
    id   bigint       not null auto_increment,
    nome varchar(100) not null,

    primary key (id)
);

INSERT INTO perfis (nome) VALUES ('ADMIN');
INSERT INTO perfis (nome) VALUES ('MODERADOR');
INSERT INTO perfis (nome) VALUES ('ALUNO');
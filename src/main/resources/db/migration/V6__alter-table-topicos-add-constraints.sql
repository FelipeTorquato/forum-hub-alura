alter table topicos
    add constraint fk_topicos_usuario_id foreign key (usuario_id) references usuarios (id),
    add constraint fk_topicos_curso_id foreign key (curso_id) references cursos (id);
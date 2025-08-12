package br.com.felipe.forum.domain.topico;

import jakarta.validation.constraints.NotNull;

public record TopicoDTO(
        @NotNull
        String titulo,

        @NotNull
        String mensagem,

        @NotNull
        Long curso_id) {
}

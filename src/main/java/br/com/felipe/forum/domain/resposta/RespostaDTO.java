package br.com.felipe.forum.domain.resposta;

import jakarta.validation.constraints.NotNull;

public record RespostaDTO(
        @NotNull
        String mensagem,

        @NotNull
        String solucao) {
}

package br.com.felipe.forum.domain.topico;

import br.com.felipe.forum.domain.resposta.Resposta;

import java.util.List;

public record ListagemTopicosDTO(Long id, String titulo, String descricao, Long curso_id, List<Resposta> respostas) {
    public ListagemTopicosDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getCurso().getId(), topico.getRespostas());
    }
}

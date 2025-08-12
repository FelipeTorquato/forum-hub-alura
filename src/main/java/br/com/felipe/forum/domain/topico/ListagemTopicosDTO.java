package br.com.felipe.forum.domain.topico;

public record ListagemTopicosDTO(Long id, String titulo, String descricao) {
    public ListagemTopicosDTO (Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem());
    }
}

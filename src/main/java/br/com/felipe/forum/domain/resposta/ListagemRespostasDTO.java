package br.com.felipe.forum.domain.resposta;

public record ListagemRespostasDTO(Long id, String mensagem, String solucao, Long topico_id) {
    public ListagemRespostasDTO(Resposta resposta) {
        this(resposta.getId(), resposta.getMensagem(), resposta.getSolucao(), resposta.getTopico().getId());
    }
}

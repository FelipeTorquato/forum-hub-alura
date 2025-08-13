package br.com.felipe.forum.domain.resposta;

import br.com.felipe.forum.domain.topico.Topico;
import br.com.felipe.forum.domain.topico.TopicoRepository;
import br.com.felipe.forum.domain.usuario.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RespostaService {

    private final RespostaRespository respostaRespository;
    private final TopicoRepository topicoRepository;


    public RespostaService(RespostaRespository respostaRespository, TopicoRepository topicoRepository) {
        this.respostaRespository = respostaRespository;
        this.topicoRepository = topicoRepository;
    }

    @Transactional
    public Resposta cadastrarResposta(RespostaDTO respostaDTO, Long topicoId, Usuario usuarioLogado) {
        Optional<Topico> topico = topicoRepository.findById(topicoId);
        if (topico.isEmpty()) {
            throw new RuntimeException("Tópico com id " + topicoId + " não encontrado.");
        }
        Resposta resposta = new Resposta(respostaDTO, topico.get(), usuarioLogado);
        respostaRespository.save(resposta);
        topico.get().adicionarResposta(resposta);
        return resposta;
    }
}

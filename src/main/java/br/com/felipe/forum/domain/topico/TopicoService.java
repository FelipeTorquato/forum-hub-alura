package br.com.felipe.forum.domain.topico;

import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public Topico salvar(TopicoDTO topicoDTO) {
        Topico topico = new Topico(topicoDTO);
        topicoRepository.save(topico);
        return topico;
    }

}

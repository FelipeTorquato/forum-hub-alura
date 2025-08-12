package br.com.felipe.forum.domain.topico;

import br.com.felipe.forum.domain.curso.Curso;
import br.com.felipe.forum.domain.curso.CursoRepository;
import br.com.felipe.forum.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.cursoRepository = cursoRepository;
    }

    public Page<ListagemTopicosDTO> listarTopicos(Pageable paginacao) {
        return topicoRepository.findAllProjected(paginacao);
    }

    public Topico salvar(TopicoDTO topicoDTO, Usuario usuarioLogado) {
        Optional<Curso> curso = cursoRepository.findById(topicoDTO.curso_id());
        if (curso.isEmpty()) {
            throw new RuntimeException("Curso não encontrado.");
        }
        Topico topico = new Topico(topicoDTO, curso.get(), usuarioLogado);
        topicoRepository.save(topico);
        return topico;
    }

}

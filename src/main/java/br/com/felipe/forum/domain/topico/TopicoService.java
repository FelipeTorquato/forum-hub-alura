package br.com.felipe.forum.domain.topico;

import br.com.felipe.forum.domain.curso.Curso;
import br.com.felipe.forum.domain.curso.CursoRepository;
import br.com.felipe.forum.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Page<ListagemTopicosDTO> page = topicoRepository.findAllProjected(paginacao);
        return page;
    }

    public ListagemTopicosDTO buscarPorId(Long id) {
        Optional<ListagemTopicosDTO> topico = topicoRepository.buscarPorId(id);
        if (topico.isEmpty()) {
            throw new RuntimeException("Tópico não encontrado.");
        }
        return topico.get();
    }

    @Transactional
    public Topico salvarTopico(TopicoDTO topicoDTO, Usuario usuarioLogado) {
        Optional<Curso> curso = cursoRepository.findById(topicoDTO.curso_id());
        if (curso.isEmpty()) {
            throw new RuntimeException("Curso não encontrado.");
        }
        Topico topico = new Topico(topicoDTO, curso.get(), usuarioLogado);
        topicoRepository.save(topico);
        return topico;
    }

    @Transactional
    public Topico editarTopico(TopicoDTO topicoDTO, Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isEmpty()) {
            throw new RuntimeException("Tópico com id " + id + " não encontrado.");
        }

        if (!cursoRepository.existsById(topicoDTO.curso_id())) {
            throw new RuntimeException("Curso com id " + topicoDTO.curso_id() + " não encontrado.");
        }

        if (!topicoDTO.titulo().isBlank() && !topicoDTO.titulo().equals(topico.get().getTitulo())) {
            topico.get().setTitulo(topicoDTO.titulo());
        }

        if (!topicoDTO.mensagem().isBlank() && !topicoDTO.mensagem().equals(topico.get().getMensagem())) {
            topico.get().setMensagem(topicoDTO.mensagem());
        }

        if (!topicoDTO.curso_id().equals(topico.get().getCurso().getId())) {
            Optional<Curso> curso = cursoRepository.findById(topicoDTO.curso_id());
            curso.ifPresent(value -> topico.get().setCurso(value));
        }
        return topicoRepository.save(topico.get());
    }

    @Transactional
    public void excluirTopico(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isEmpty()) {
            throw new RuntimeException("Tópico com id " + id + " não encontrado.");
        }
        topicoRepository.delete(topico.get());
    }
}

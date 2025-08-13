package br.com.felipe.forum.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("""
            SELECT new br.com.felipe.forum.domain.topico.ListagemTopicosDTO(t.id, t.titulo, t.mensagem, t.curso.id, t.respostas)
            FROM Topico t ORDER BY t.id
            """)
    Page<ListagemTopicosDTO> findAllProjected(Pageable paginacao);

    @Query("""
             SELECT new br.com.felipe.forum.domain.topico.ListagemTopicosDTO(t.id, t.titulo, t.mensagem, t.curso.id, t.respostas)
             FROM Topico t WHERE t.id = :id
            """)
    Optional<ListagemTopicosDTO> buscarPorId(Long id);
}

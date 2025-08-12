package br.com.felipe.forum.domain.topico;

import br.com.felipe.forum.domain.curso.Curso;
import br.com.felipe.forum.domain.resposta.Resposta;
import br.com.felipe.forum.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Status status;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    public Topico(TopicoDTO topicoDTO) {
        this.titulo = topicoDTO.titulo();
        this.mensagem = topicoDTO.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.ABERTO;
        // pegar o usuario da requisicao
        this.usuario = new Usuario();
        // ver como vai pegar o curso, provavelmente pelo id
        this.curso = new Curso();
        this.respostas = new ArrayList<Resposta>();
    }

    public void adicionarResposta(Resposta resposta) {
        this.respostas.add(resposta);
    }
}

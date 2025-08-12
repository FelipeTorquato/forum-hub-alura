package br.com.felipe.forum.domain.resposta;

import br.com.felipe.forum.domain.usuario.Usuario;
import br.com.felipe.forum.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "Resposta")
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;

    @ManyToOne
    private Topico topico;
    private LocalDateTime dataCriacao;

    @ManyToOne
    private Usuario usuario;
    private String solucao;
}

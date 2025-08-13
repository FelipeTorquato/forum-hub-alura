package br.com.felipe.forum.domain.resposta;

import br.com.felipe.forum.domain.topico.Topico;
import br.com.felipe.forum.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity(name = "Resposta")
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;

    @ManyToOne
    @JsonIgnore
    private Topico topico;
    private LocalDateTime dataCriacao;

    @ManyToOne
    private Usuario usuario;
    private String solucao;

    public Resposta(RespostaDTO respostaDTO, Topico topico, Usuario usuario) {
        this.mensagem = respostaDTO.mensagem();
        this.topico = topico;
        this.dataCriacao = LocalDateTime.now();
        this.usuario = usuario;
        this.solucao = respostaDTO.solucao();
    }
}

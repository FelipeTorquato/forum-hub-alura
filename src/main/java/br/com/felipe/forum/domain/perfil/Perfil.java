package br.com.felipe.forum.domain.perfil;

import br.com.felipe.forum.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = "usuarios")
@Entity(name = "Perfil")
@Table(name = "perfis")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "perfis")
    @JsonBackReference
    private List<Usuario> usuarios;
}

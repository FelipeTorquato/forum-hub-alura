package br.com.felipe.forum.controller;

import br.com.felipe.forum.domain.topico.ListagemTopicosDTO;
import br.com.felipe.forum.domain.topico.Topico;
import br.com.felipe.forum.domain.topico.TopicoDTO;
import br.com.felipe.forum.domain.topico.TopicoService;
import br.com.felipe.forum.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> cadastrarTopico(@Valid @RequestBody TopicoDTO topicoDTO,
                                                  @AuthenticationPrincipal Usuario usuarioLogado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoService.salvar(topicoDTO, usuarioLogado));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemTopicosDTO>> listarTopicos(@PageableDefault(size = 10) Pageable paginacao) {
        return ResponseEntity.ok(topicoService.listarTopicos(paginacao));
    }
}

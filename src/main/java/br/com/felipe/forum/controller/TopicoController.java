package br.com.felipe.forum.controller;

import br.com.felipe.forum.domain.topico.Topico;
import br.com.felipe.forum.domain.topico.TopicoDTO;
import br.com.felipe.forum.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> cadastrarTopico(@Valid @RequestBody TopicoDTO topicoDTO) {
        return ResponseEntity.ok().body(topicoService.salvar(topicoDTO));
    }
}

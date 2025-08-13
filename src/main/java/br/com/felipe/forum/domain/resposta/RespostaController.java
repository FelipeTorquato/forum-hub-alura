package br.com.felipe.forum.domain.resposta;

import br.com.felipe.forum.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos/{topicoId}/respostas")
public class RespostaController {

    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @PostMapping
    public ResponseEntity<Resposta> cadastrarResposta(@Valid @RequestBody RespostaDTO respostaDTO, @PathVariable Long topicoId,
                                                      @AuthenticationPrincipal Usuario usuarioLogado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(respostaService.cadastrarResposta(respostaDTO, topicoId, usuarioLogado));
    }
}

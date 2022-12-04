package tcc.kanbro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc.kanbro.model.Mensagem;
import tcc.kanbro.service.MensagemService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/mensagem")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @GetMapping("/{sala}")
    public ResponseEntity<List<Mensagem>> getMessages(@PathVariable String sala) {
        return ResponseEntity.ok(mensagemService.getMensagens(sala));
    }
}

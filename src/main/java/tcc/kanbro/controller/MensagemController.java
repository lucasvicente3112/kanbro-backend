package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcc.kanbro.dto.MensagemDto;
import tcc.kanbro.service.MensagemService;

@RestController
@CrossOrigin
@RequestMapping(value = "/mensagem")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @PostMapping(path = "/cadastrar")
    public MensagemDto cadastrar(@RequestBody MensagemDto mensagemDto) {
        return mensagemService.cadastrar(mensagemDto);
    }
}

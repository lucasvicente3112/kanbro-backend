package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcc.kanbro.dto.MensagemDto;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.service.MensagemService;

@RestController
@RequestMapping(value = "/mensagens")
public class MensagensController {

    @Autowired
    private MensagemService mensagemService;

    @PostMapping(path = "/cadastrar")
    public MensagemDto cadastrar(@RequestBody MensagemDto mensagemDto) {
        return mensagemService.cadastrar(mensagemDto);
    }
}

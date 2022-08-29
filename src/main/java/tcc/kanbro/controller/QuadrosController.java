package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.dto.UsuarioDto;
import tcc.kanbro.service.QuadroService;

@RestController
@RequestMapping(value = "/quadros")
public class QuadrosController {

    @Autowired
    private QuadroService quadroService;

    @PostMapping(path = "/cadastrar")
    public QuadroDto cadastrar(@RequestBody QuadroDto quadroDto) {
        return quadroService.cadastrar(quadroDto);
    }
}

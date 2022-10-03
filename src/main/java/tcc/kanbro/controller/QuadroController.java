package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.service.QuadroService;

@RestController
@CrossOrigin
@RequestMapping(value = "/quadro")
public class QuadroController {

    @Autowired
    private QuadroService quadroService;

    @PostMapping(path = "/cadastrar")
    public Long cadastrar(@RequestBody QuadroDto quadroDto) {
        return quadroService.cadastrar(quadroDto);
    }
}

package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcc.kanbro.dto.EstadoDto;
import tcc.kanbro.dto.TimeDto;
import tcc.kanbro.service.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadosController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping(path = "/cadastrar")
    public EstadoDto cadastrar(@RequestBody EstadoDto estadoDto) {
        return estadoService.cadastrar(estadoDto);
    }
}

package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcc.kanbro.dto.EstadoDto;
import tcc.kanbro.service.EstadoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping(path = "/cadastrar")
    public EstadoDto cadastrar(@RequestBody EstadoDto estadoDto) {
        return estadoService.cadastrar(estadoDto);
    }
}

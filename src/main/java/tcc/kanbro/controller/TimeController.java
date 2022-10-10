package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcc.kanbro.dto.TimeDto;
import tcc.kanbro.service.TimeService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping(path = "/cadastrar")
    public Long cadastrar(@RequestBody TimeDto timeDto) {
        return timeService.cadastrar(timeDto);
    }

    @PostMapping(path ="/{id}/adicionar/{email}")
    public void adicionaUsuario(@PathVariable Long id, @PathVariable String email){
        timeService.adicionaUsuario(id, email);
    };
    @GetMapping
    public List<TimeDto> retornarTodos() {
        return timeService.listarTimes();
    }
}

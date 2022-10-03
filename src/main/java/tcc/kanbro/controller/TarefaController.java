package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.dto.TarefaDto;
import tcc.kanbro.service.TarefaService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping(path = "/cadastrar")
    public TarefaDto cadastrar(@RequestBody TarefaDto tarefaDto) {
        return tarefaService.cadastrar(tarefaDto);
    }

    @GetMapping
    public List<TarefaDto> listarTarefasPorQuadro(@RequestBody QuadroDto quadroDto){
        return tarefaService.listarTarefasPorQuadro(quadroDto);
    }
}

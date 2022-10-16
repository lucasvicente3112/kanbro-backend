package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "/quadro/{idQuadro}")
    public List<TarefaDto> listarTarefasPorQuadro(@PathVariable Long idQuadro){
        return tarefaService.listarTarefasPorQuadro(idQuadro);
    }

    @PostMapping(path = "/{idTarefa}/quadro/{idQuadro}/atualiza-status/{status}")
    public void atualizarStatus(@PathVariable Long idTarefa, @PathVariable Long idQuadro, @PathVariable String status) {
        tarefaService.atualizarStatus(idTarefa, idQuadro, status);
    }

}

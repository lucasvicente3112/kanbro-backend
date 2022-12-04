package tcc.kanbro.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tcc.kanbro.dto.TarefaDto;
import tcc.kanbro.model.Tarefa;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TarefaMapper {
    @Autowired
    private QuadroMapper quadroMapper;

    public TarefaDto paraDto(Tarefa tarefa) {
        return TarefaDto.builder()
                .idTarefa(tarefa.getIdTarefa())
                .titulo(tarefa.getTitulo())
                .descricao(tarefa.getDescricao())
                .responsavel(tarefa.getResponsavel())
                .status(tarefa.getStatus())
                .build();
    }

    public Tarefa dtoParaTarefa(TarefaDto tarefaDto) {
        return Tarefa.builder()
                .titulo(tarefaDto.getTitulo())
                .descricao(tarefaDto.getDescricao())
                .responsavel(tarefaDto.getResponsavel())
                .status(tarefaDto.getStatus())
                .build();
    }

    public List<TarefaDto> paraListaDeTarefasDto(List<Tarefa> tarefaList) {
        return tarefaList.stream().map(this::paraDto).collect(Collectors.toList());
    }
}

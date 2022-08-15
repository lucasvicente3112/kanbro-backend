package tcc.kanbro.mapper;

import tcc.kanbro.dto.TarefaDto;
import tcc.kanbro.model.Tarefa;

public class TarefaMapper {

    public TarefaDto paraDto(Tarefa tarefa){
        return TarefaDto.builder()
                .descricao(tarefa.getDescricao())
                .responsavel(tarefa.getResponsavel())
                .quadro(tarefa.getQuadro())
                .build();
    }

    public Tarefa dtoParaTarefa(TarefaDto tarefaDto){
        return Tarefa.builder()
                .descricao(tarefaDto.getDescricao())
                .responsavel(tarefaDto.getResponsavel())
                .quadro(tarefaDto.getQuadro())
                .build();
    }
}

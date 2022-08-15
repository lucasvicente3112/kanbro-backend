package tcc.kanbro.mapper;

import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.model.Quadro;

public class QuadroMapper {
    public QuadroDto paraDto(QuadroDto quadroDto){
        return QuadroDto.builder()
                .time(quadroDto.getTime())
                .tarefas(quadroDto.getTarefas())
                .build();
    }

    public Quadro dtoParaQuadro(QuadroDto quadroDto){
        return Quadro.builder()
                .time(quadroDto.getTime())
                .tarefas(quadroDto.getTarefas())
                .build();
    }
}


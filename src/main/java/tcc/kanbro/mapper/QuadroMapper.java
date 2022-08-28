package tcc.kanbro.mapper;

import org.springframework.stereotype.Component;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.model.Quadro;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class QuadroMapper {
    public QuadroDto paraDto(Quadro quadro){
        return QuadroDto.builder()
                .time(quadro.getTime())
                .tarefas(quadro.getTarefas())
                .build();
    }

    public Quadro dtoParaQuadro(QuadroDto quadroDto){
        return Quadro.builder()
                .time(quadroDto.getTime())
                .tarefas(quadroDto.getTarefas())
                .build();
    }
    public List<QuadroDto> paraListaDeQuadroDto(List<Quadro> quadroList){
        return quadroList.stream().map(this::paraDto).collect(Collectors.toList());
    }
}


package tcc.kanbro.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.model.Quadro;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class QuadroMapper {
    @Autowired
    private TimeMapper timeMapper;
    public QuadroDto paraDto(Quadro quadro){
        return QuadroDto.builder()
                .time(quadro.getTime().getIdTime())
                .build();
    }

    public List<QuadroDto> paraListaDeQuadroDto(List<Quadro> quadroList){
        return quadroList.stream().map(this::paraDto).collect(Collectors.toList());
    }
}


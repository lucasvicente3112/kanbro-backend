package tcc.kanbro.mapper;

import org.springframework.stereotype.Component;
import tcc.kanbro.dto.TimeDto;
import tcc.kanbro.model.Time;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class TimeMapper {
    public TimeDto paraDto(Time time){
        return TimeDto.builder()
                .nome(time.getNome())
                .usuarios(time.getUsuarios())
                .quadro(time.getQuadro())
                .build();
    }

    public Time dtoParaTimes(TimeDto timeDto){
        return Time.builder()
                .nome(timeDto.getNome())
                .usuarios(timeDto.getUsuarios())
                .quadro(timeDto.getQuadro())
                .build();
    }
    public List<TimeDto> paraListaDeTime(List<Time> timeList){
        return timeList.stream().map(this::paraDto).collect(Collectors.toList());
    }
}

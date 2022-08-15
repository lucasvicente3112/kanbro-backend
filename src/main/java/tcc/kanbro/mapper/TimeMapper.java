package tcc.kanbro.mapper;

import tcc.kanbro.dto.TimeDto;
import tcc.kanbro.model.Time;

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
}

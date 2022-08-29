package tcc.kanbro.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tcc.kanbro.dto.TimeDto;
import tcc.kanbro.model.Time;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class TimeMapper {
    @Autowired
    private UsuarioMapper usuarioMapper;
    public TimeDto paraDto(Time time){
        return TimeDto.builder()
                .nome(time.getNome())
                .usuarios(usuarioMapper.paraListaDeUsuariosDto(time.getUsuarios()))
                .build();
    }

    public Time dtoParaTimes(TimeDto timeDto){
        return Time.builder()
                .nome(timeDto.getNome())
                .usuarios(usuarioMapper.paraListaDeUsuarios(timeDto.getUsuarios()))
                .build();
    }
    public Time dtoParaTimesSemUser(TimeDto timeDto){
        return Time.builder()
                .nome(timeDto.getNome())
                .build();
    }
    public List<TimeDto> paraListaDeTime(List<Time> timeList){
        return timeList.stream().map(this::paraDto).collect(Collectors.toList());
    }
}

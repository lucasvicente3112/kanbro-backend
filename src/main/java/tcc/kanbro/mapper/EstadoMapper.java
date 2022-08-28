package tcc.kanbro.mapper;

import org.springframework.stereotype.Component;
import tcc.kanbro.dto.EstadoDto;
import tcc.kanbro.model.Estado;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoMapper {

    public EstadoDto paraDto(Estado estado){
        return EstadoDto.builder()
                .estado(estado.getEstado())
                .build();
    }

    public Estado dtoParaEstado(EstadoDto estadoDto){
        return Estado.builder()
                .estado(estadoDto.getEstado())
                .build();
    }
    public List<EstadoDto> paraListaDeEstadosDto(List<Estado> estados){
        return estados.stream().map(this::paraDto).collect(Collectors.toList());
    }
}

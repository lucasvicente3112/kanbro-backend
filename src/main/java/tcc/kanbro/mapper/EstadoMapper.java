package tcc.kanbro.mapper;

import tcc.kanbro.dto.EstadoDto;
import tcc.kanbro.model.Estado;

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
}

package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.EstadoDto;
import tcc.kanbro.mapper.EstadoMapper;
import tcc.kanbro.repository.EstadoRepository;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private EstadoMapper estadoMapper;

    public List<EstadoDto> listarEstados() {
        return estadoMapper.paraListaDeEstadosDto(estadoRepository.findAll());
    }

    public EstadoDto cadastrar(EstadoDto estadoDto) {
        estadoRepository.save(estadoMapper.dtoParaEstado(estadoDto));
        return estadoDto;
    }

    public void inicializarEstados(Long quadroId){
        List<String> estadosIniciais = List.of("ToDo", "Doing", "Done");

        for (String estado : estadosIniciais) {
            cadastrar(EstadoDto.builder()
                    .estado(estado)
                    .QuadroId(quadroId)
                    .build());
        }
    }
}

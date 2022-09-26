package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.mapper.QuadroMapper;
import tcc.kanbro.model.Quadro;
import tcc.kanbro.repository.QuadroRepository;
import tcc.kanbro.repository.TimeRepository;

import java.util.List;

@Service
public class QuadroService {

    @Autowired
    private QuadroRepository quadroRepository;
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private QuadroMapper quadroMapper;
    @Autowired
    private EstadoService estadoService;

    public List<QuadroDto> ListarQuadros() {
        return quadroMapper.paraListaDeQuadroDto(quadroRepository.findAll());
    }

    public Long cadastrar(QuadroDto quadroDto) {

        Quadro quadro = Quadro.builder()
                .time(timeRepository.findByIdTime(quadroDto.getTime()))
                .build();

        Quadro quadroSalvo = quadroRepository.save(quadro);
        estadoService.inicializarEstados(quadroSalvo.getIdQuadro());
        return quadroSalvo.getIdQuadro();
    }
}

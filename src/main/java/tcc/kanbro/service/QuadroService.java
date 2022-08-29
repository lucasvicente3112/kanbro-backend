package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.mapper.QuadroMapper;
import tcc.kanbro.model.Quadro;
import tcc.kanbro.model.Time;
import tcc.kanbro.model.Usuario;
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

    public List<QuadroDto> ListarQuadros(){
        return quadroMapper.paraListaDeQuadroDto(quadroRepository.findAll());
    }

    public QuadroDto cadastrar(QuadroDto quadroDto){

        Quadro quadro = Quadro.builder()
                .time(timeRepository.findAByNome(quadroDto.getTime().getNome()))
                .build();

        quadroRepository.save(quadro);
        return quadroDto;
    }
}

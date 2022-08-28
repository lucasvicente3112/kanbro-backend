package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.mapper.QuadroMapper;
import tcc.kanbro.repository.QuadroRepository;

import java.util.List;

@Service
public class QuadroService {

    @Autowired
    private QuadroRepository quadroRepository;
    @Autowired
    private QuadroMapper quadroMapper;

    public List<QuadroDto> ListarQuadros(){
        return quadroMapper.paraListaDeQuadroDto(quadroRepository.findAll());
    }

    public QuadroDto cadastrar(QuadroDto quadroDto){
        quadroRepository.save(quadroMapper.dtoParaQuadro(quadroDto));
        return quadroDto;
    }
}

package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.TarefaDto;
import tcc.kanbro.mapper.TarefaMapper;
import tcc.kanbro.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaMapper tarefaMapper;

    public List<TarefaDto> listarTarefas(){
        return tarefaMapper.paraListaDe(tarefaRepository.findAll());
    }

    public TarefaDto cadastrar(TarefaDto tarefaDto){
        tarefaRepository.save(tarefaMapper.dtoParaTarefa(tarefaDto));
        return tarefaDto;
    }
}

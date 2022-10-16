package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcc.kanbro.dto.QuadroDto;
import tcc.kanbro.dto.TarefaDto;
import tcc.kanbro.dto.TimeDto;
import tcc.kanbro.mapper.QuadroMapper;
import tcc.kanbro.mapper.TarefaMapper;
import tcc.kanbro.mapper.TimeMapper;
import tcc.kanbro.model.Quadro;
import tcc.kanbro.model.Tarefa;
import tcc.kanbro.model.Time;
import tcc.kanbro.repository.QuadroRepository;
import tcc.kanbro.repository.TarefaRepository;
import tcc.kanbro.repository.TimeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private QuadroRepository quadroRepository;
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private TarefaMapper tarefaMapper;
    @Autowired
    private TimeMapper timeMapper;
    @Autowired
    private QuadroMapper quadroMapper;

    public List<TarefaDto> listarTarefas() {
        return tarefaMapper.paraListaDeTarefasDto(tarefaRepository.findAll());
    }

    public List<TarefaDto> listarTarefasPorQuadro(Long idTime) {
        return tarefaMapper.paraListaDeTarefasDto(tarefaRepository.findAllByQuadro(encontraQuadroPorTime(idTime)));
    }

    public TarefaDto cadastrar(TarefaDto tarefaDto) {

        Quadro quadro = encontraQuadroDoTimePorTarefa(tarefaDto);

        Tarefa tarefa = Tarefa.builder()
                .titulo(tarefaDto.getTitulo())
                .descricao(tarefaDto.getDescricao())
                .responsavel(tarefaDto.getResponsavel())
                .status(tarefaDto.getStatus())
                .quadro(quadro)
                .build();

        tarefaRepository.save(tarefa);

        return tarefaDto;
    }

    private Quadro encontraQuadroDoTimePorTarefa(TarefaDto tarefaDto) {
        Time time = timeRepository.findByIdTime(tarefaDto.getQuadro().getTime());
        return quadroRepository.findByTime(time);
    }

    private Quadro encontraQuadroPorTime(Long idTime) {
        Time time = timeRepository.findByIdTime(idTime);
        return quadroRepository.findByTime(time);
    }
    @Transactional
    public void atualizarStatus(Long idTarefa, Long idQuadro, String status) {
        Quadro quadro = quadroRepository.findByIdQuadro(idQuadro);
        tarefaRepository.atualizaStatus(idTarefa, quadro, status);
    }
}

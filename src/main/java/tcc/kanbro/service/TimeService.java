package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.TimeDto;
import tcc.kanbro.mapper.TimeMapper;
import tcc.kanbro.repository.TimeRepository;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private TimeMapper timeMapper;

    public List<TimeDto> listarTimes(){
        return timeMapper.paraListaDeTime(timeRepository.findAll());
    }

    public TimeDto cadastrar(TimeDto timeDto){
        timeRepository.save(timeMapper.dtoParaTimes(timeDto));
        return timeDto;
    }
}

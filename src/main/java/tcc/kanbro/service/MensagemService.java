package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.MensagemDto;
import tcc.kanbro.mapper.MensagemMapper;
import tcc.kanbro.repository.MensagemRepository;

import java.util.List;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private MensagemMapper mensagemMapper;

    public List<MensagemDto> listarMensagens(){
        return mensagemMapper.paraListaDeMensagemDto(mensagemRepository.findAll());
    }

    public MensagemDto cadastrar(MensagemDto mensagemDto){
        mensagemRepository.save(mensagemMapper.dtoParaMensagem(mensagemDto));
        return mensagemDto;
    }
}

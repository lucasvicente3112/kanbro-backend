package tcc.kanbro.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.MensagemDto;
import tcc.kanbro.mapper.MensagemMapper;
import tcc.kanbro.model.Mensagem;
import tcc.kanbro.repository.MensagemRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
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

    public List<Mensagem> getMensagens(String sala) {
        return mensagemRepository.findAllBySala(sala);
    }

    public Mensagem salvarMensagem(Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }
}

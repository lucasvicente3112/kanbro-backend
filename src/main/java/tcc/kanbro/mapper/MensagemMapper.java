package tcc.kanbro.mapper;

import tcc.kanbro.dto.MensagemDto;
import tcc.kanbro.model.Mensagem;

public class MensagemMapper {

    public MensagemDto paraDto(Mensagem mensagem){
        return MensagemDto.builder()
                .mensagem(mensagem.getMensagem())
                .build();
    }

    public Mensagem dtoParaMensagem(MensagemDto mensagemDto){
        return Mensagem.builder()
                .mensagem(mensagemDto.getMensagem())
                .build();
    }
}

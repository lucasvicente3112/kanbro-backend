package tcc.kanbro.mapper;

import org.springframework.stereotype.Component;
import tcc.kanbro.dto.MensagemDto;
import tcc.kanbro.model.Mensagem;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class MensagemMapper {

    public MensagemDto paraDto(Mensagem mensagem){
        return MensagemDto.builder()
                .mensagem(mensagem.getConteudo())
                .build();
    }

    public Mensagem dtoParaMensagem(MensagemDto mensagemDto){
        return Mensagem.builder()
                .conteudo(mensagemDto.getMensagem())
                .build();
    }
    public List<MensagemDto> paraListaDeMensagemDto(List<Mensagem> mensagemList){
        return mensagemList.stream().map(this::paraDto).collect(Collectors.toList());
    }
}

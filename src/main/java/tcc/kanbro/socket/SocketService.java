package tcc.kanbro.socket;

import com.corundumstudio.socketio.SocketIOClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tcc.kanbro.model.Mensagem;
import tcc.kanbro.model.TipoMensagem;
import tcc.kanbro.service.MensagemService;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocketService {

    private final MensagemService mensagemService;

    public void sendSocketMessage(SocketIOClient senderClient, Mensagem mensagem, String room) {
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent("read_message",
                        mensagem);
            }
        }
    }

    public void saveMessage(SocketIOClient senderClient, Mensagem mensagem) {
        Mensagem storedMessage = mensagemService.salvarMensagem(Mensagem.builder()
                .tipoMensagem(TipoMensagem.CLIENT)
                .conteudo(mensagem.getConteudo())
                .sala(mensagem.getSala())
                .usuario(mensagem.getUsuario())
                .build());
        sendSocketMessage(senderClient, storedMessage, mensagem.getSala());
    }

    public void saveInfoMessage(SocketIOClient senderClient, String mensagem, String sala) {
        Mensagem storedMessage = mensagemService.salvarMensagem(Mensagem.builder()
                .tipoMensagem(TipoMensagem.SERVER)
                .conteudo(mensagem)
                .sala(sala)
                .build());
        sendSocketMessage(senderClient, storedMessage, sala);
    }
}

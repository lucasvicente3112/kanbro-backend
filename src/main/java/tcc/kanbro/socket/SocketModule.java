package tcc.kanbro.socket;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tcc.kanbro.constants.Constants;
import tcc.kanbro.model.Mensagem;

import java.util.stream.Collectors;

@Component
@Slf4j
public class SocketModule {

    private final SocketIOServer server;
    private final SocketService socketService;

    public SocketModule(SocketIOServer server, SocketService socketService) {
        this.server = server;
        this.socketService = socketService;
        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
        server.addEventListener("send_message", Mensagem.class, onChatReceived());

    }


    private DataListener<Mensagem> onChatReceived() {
        return (senderClient, data, ackSender) -> {
            log.info(data.toString());
            socketService.saveMessage(senderClient, data);
        };
    }


    private ConnectListener onConnected() {
        return (client) -> {
//            String sala = client.getHandshakeData().getSingleUrlParam("sala");
//            String usuario = client.getHandshakeData().getSingleUrlParam("sala");
            var params = client.getHandshakeData().getUrlParams();
            String sala = params.get("sala").stream().collect(Collectors.joining());
            String usuario = params.get("usuario").stream().collect(Collectors.joining());
            client.joinRoom(sala);
            socketService.saveInfoMessage(client, String.format(Constants.WELCOME_MESSAGE, usuario), sala);
            log.info("Socket ID[{}] - sala[{}] - usuario [{}]  Connected to chat module through", client.getSessionId().toString(), sala, usuario);
        };

    }

    private DisconnectListener onDisconnected() {
        return client -> {
            var params = client.getHandshakeData().getUrlParams();
            String sala = params.get("sala").stream().collect(Collectors.joining());
            String usuario = params.get("usuario").stream().collect(Collectors.joining());
            socketService.saveInfoMessage(client, String.format(Constants.DISCONNECT_MESSAGE, usuario), sala);
            log.info("Socket ID[{}] - sala[{}] - usuario [{}]  discnnected to chat module through", client.getSessionId().toString(), sala, usuario);
        };
    }
}

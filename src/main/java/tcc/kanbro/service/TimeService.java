package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcc.kanbro.dto.TimeDto;
import tcc.kanbro.mapper.TimeMapper;
import tcc.kanbro.model.Time;
import tcc.kanbro.model.Usuario;
import tcc.kanbro.repository.TimeRepository;
import tcc.kanbro.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TimeMapper timeMapper;

    public List<TimeDto> listarTimes() {
        return timeMapper.paraListaDeTime(timeRepository.findAll());
    }
    @Transactional
    public Long cadastrar(TimeDto timeDto) {
        List<Usuario> usuarioList = new ArrayList<>();
        Optional<Usuario> usuarioResgatado = usuarioRepository.findByEmail(timeDto.getUsuarios().get(0).getEmail());
        usuarioList.add(usuarioRepository.findAByNome(usuarioResgatado.get().getNome()));

        Time timeNovo = timeRepository.save(Time.builder()
                                            .nome(timeDto.getNome())
                                            .usuarios(usuarioList)
                                            .build());

        usuarioRepository.atualizaTimeDoUsuario(usuarioResgatado.get().getIdUsuario(), timeNovo);
        return timeNovo.getIdTime();
    }
    @Transactional
    public void adicionaUsuario(Long id, String email){
      Time time = timeRepository.findByIdTime(id);
      Optional<Usuario> usuarioResgatado = usuarioRepository.findByEmail(email);

        usuarioRepository.atualizaTimeDoUsuario(usuarioResgatado.get().getIdUsuario(), time);
    }

    @Transactional
    public void removeUsuario(String email){
        Optional<Usuario> usuarioResgatado = usuarioRepository.findByEmail(email);

        usuarioRepository.removeUsuarioDoTime(usuarioResgatado.get().getIdUsuario());
    }
}

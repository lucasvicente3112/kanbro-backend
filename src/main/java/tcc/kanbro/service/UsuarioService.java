package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.UsuarioDto;
import tcc.kanbro.mapper.UsuarioMapper;
import tcc.kanbro.repository.UsuarioRepository;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<UsuarioDto> listarUsuarios(){
        return usuarioMapper.paraListaDeUsuariosDto(usuarioRepository.findAll());
    }
    public UsuarioDto cadastrar(UsuarioDto usuarioDto){
       usuarioRepository.save(usuarioMapper.dtoParaUsuario(usuarioDto));
       return usuarioDto;
    }
}

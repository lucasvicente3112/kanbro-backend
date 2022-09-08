package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.UsuarioDto;
import tcc.kanbro.mapper.UsuarioMapper;
import tcc.kanbro.model.Usuario;
import tcc.kanbro.repository.UsuarioRepository;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioDto> listarUsuarios(){
        return usuarioMapper.paraListaDeUsuariosDto(usuarioRepository.findAll());
    }
    public UsuarioDto cadastrar(UsuarioDto usuarioDto){
       Usuario usuario = usuarioMapper.dtoParaUsuario(usuarioDto);
       usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
       usuarioRepository.save(usuario);
       return usuarioDto;
    }
}

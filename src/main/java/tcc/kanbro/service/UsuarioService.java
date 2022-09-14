package tcc.kanbro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tcc.kanbro.dto.UsuarioDto;
import tcc.kanbro.mapper.UsuarioMapper;
import tcc.kanbro.model.Usuario;
import tcc.kanbro.repository.UsuarioRepository;
import tcc.kanbro.security.JwtTokenUtil;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtUtil;
    @Autowired
    AuthenticationManager authManager;

    public List<UsuarioDto> listarUsuarios() {
        return usuarioMapper.paraListaDeUsuariosDto(usuarioRepository.findAll());
    }

    public UsuarioDto cadastrar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.dtoParaUsuario(usuarioDto);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return usuarioDto;
    }

    public ResponseEntity<?> login(UsuarioDto usuarioDto) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            usuarioDto.getEmail(), usuarioDto.getSenha())
            );

            Usuario usuario = (Usuario) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(usuario);
            UsuarioDto usuarioDtoResponse = UsuarioDto.builder()
                    .email(usuario.getEmail())
                    .token(accessToken)
                    .build();
            return ResponseEntity.ok().body(usuarioDtoResponse);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

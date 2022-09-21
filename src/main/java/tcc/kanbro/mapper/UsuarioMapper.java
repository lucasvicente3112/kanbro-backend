package tcc.kanbro.mapper;

import org.springframework.stereotype.Component;
import tcc.kanbro.dto.UsuarioDto;
import tcc.kanbro.model.Usuario;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public UsuarioDto paraDto(Usuario usuario) {
        return UsuarioDto.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .build();
    }

    public Optional<UsuarioDto> paraDtoOptional(Optional<Usuario> usuario) {
        Optional<UsuarioDto> usuarioDto = null;
        try {
            usuarioDto = Optional.ofNullable(UsuarioDto.builder()
                    .nome(usuario.get().getNome())
                    .email(usuario.get().getEmail())
                    .senha(usuario.get().getSenha())
                    .build());
        } catch (NoSuchElementException e) {
            return null;
        }
        return usuarioDto;
    }

    public Usuario dtoParaUsuario(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .nome(usuarioDto.getNome())
                .email(usuarioDto.getEmail())
                .senha(usuarioDto.getSenha())
                .build();
    }

    public List<UsuarioDto> paraListaDeUsuariosDto(List<Usuario> usuarios) {
        return usuarios.stream().map(this::paraDto).collect(Collectors.toList());
    }

    public List<Usuario> paraListaDeUsuarios(List<UsuarioDto> usuarioDtos) {
        return usuarioDtos.stream().map(this::dtoParaUsuario).collect(Collectors.toList());
    }
}

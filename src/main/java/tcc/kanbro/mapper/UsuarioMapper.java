package tcc.kanbro.mapper;

import tcc.kanbro.dto.UsuarioDto;
import tcc.kanbro.model.Usuario;

public class UsuarioMapper {
    public UsuarioDto paraDto(Usuario usuario) {
        return UsuarioDto.builder()
                        .time(usuario.getTime())
                        .nome(usuario.getNome())
                        .email(usuario.getEmail())
                        .senha(usuario.getSenha())
                        .build();
    }

    public Usuario dtoParaUsuario(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .time(usuarioDto.getTime())
                .nome(usuarioDto.getNome())
                .email(usuarioDto.getEmail())
                .senha(usuarioDto.getSenha())
                .build();
    }
}

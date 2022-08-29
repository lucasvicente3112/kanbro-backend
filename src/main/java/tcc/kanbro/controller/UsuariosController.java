package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcc.kanbro.dto.UsuarioDto;
import tcc.kanbro.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping(path = "/cadastrar")
    public UsuarioDto cadastrar(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.cadastrar(usuarioDto);
    }
}

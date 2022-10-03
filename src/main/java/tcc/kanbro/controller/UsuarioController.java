package tcc.kanbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc.kanbro.dto.UsuarioDto;
import tcc.kanbro.service.UsuarioService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/cadastrar")
    public UsuarioDto cadastrar(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.cadastrar(usuarioDto);
    }

    @GetMapping(path = "/email/{email}/time")
    public UsuarioDto retornaTime(@PathVariable String email){
        return usuarioService.recuperaTime(email);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.login(usuarioDto);
    }
}

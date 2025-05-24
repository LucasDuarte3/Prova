package br.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.senac.model.Usuario;
import br.senac.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint de Login
    @PostMapping("/login")
    public boolean login(@RequestBody Usuario usuario) {
        return usuarioService.autenticar(usuario.getNome(), usuario.getSenha());
    }

    // Endpoint para criar novos usuários (opcional)
    @PostMapping("/criar")
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }
}

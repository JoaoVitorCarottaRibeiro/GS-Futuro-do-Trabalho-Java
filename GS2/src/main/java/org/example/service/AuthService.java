package org.example.service;

import org.example.exception.EmailJaCadastradoException;
import org.example.exception.UsuarioNaoEncontradoException;
import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario registrar(Usuario usuario) {
        repo.findByEmail(usuario.getEmail()).ifPresent(u -> {
            throw new EmailJaCadastradoException(usuario.getEmail());
        });

        usuario.setSenha(encoder.encode(usuario.getSenha())); // hash da senha
        return repo.save(usuario);
    }

    public Usuario login(String email, String senha) {
        Usuario u = repo.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(null));

        if (!encoder.matches(senha, u.getSenha())) {
            throw new RuntimeException("Email ou senha inválidos.");
        }
        return u;
    }
}

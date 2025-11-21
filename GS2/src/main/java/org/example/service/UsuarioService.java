package org.example.service;

import jakarta.validation.Valid;
import org.example.exception.UsuarioNaoEncontradoException;
import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    public Usuario criar(@Valid Usuario u) {
        return usuarioRepository.save(u);
    }

    public Usuario atualizar(Long id, @Valid Usuario u) {
        Usuario existente = buscarPorId(id);
        existente.setNome(u.getNome());
        existente.setIdade(u.getIdade());
        existente.setProfissao(u.getProfissao());
        existente.setEmail(u.getEmail());
        existente.setSenha(u.getSenha()); // opcional: hash aqui se quiser
        return usuarioRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNaoEncontradoException(id);
        }
        usuarioRepository.deleteById(id);
    }
}

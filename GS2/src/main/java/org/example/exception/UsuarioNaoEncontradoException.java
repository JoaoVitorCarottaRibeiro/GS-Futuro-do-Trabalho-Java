package org.example.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(Long id) {
        super(id == null ? "Usuário não encontrado." : "Usuário com ID " + id + " não encontrado.");
    }
}

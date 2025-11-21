package org.example.exception;

public class TrilhaNaoEncontradaException extends RuntimeException {
    public TrilhaNaoEncontradaException(Long id) {
        super("Trilha com ID " + id + " não encontrada.");
    }
}

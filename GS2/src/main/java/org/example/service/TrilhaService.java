package org.example.service;

import org.example.exception.TrilhaNaoEncontradaException;
import org.example.model.TrilhaDeAprendizagem;
import org.example.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository repo;

    public TrilhaService(TrilhaRepository repo) { this.repo = repo; }

    public List<TrilhaDeAprendizagem> listarTodas() { return repo.findAll(); }

    public TrilhaDeAprendizagem buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new TrilhaNaoEncontradaException(id));
    }

    public TrilhaDeAprendizagem criar(TrilhaDeAprendizagem trilha) { return repo.save(trilha); }

    public TrilhaDeAprendizagem atualizar(Long id, TrilhaDeAprendizagem nova) {
        TrilhaDeAprendizagem t = buscarPorId(id);
        t.setNome(nova.getNome());
        t.setNivel(nova.getNivel());
        t.setCargaHoraria(nova.getCargaHoraria());
        return repo.save(t);
    }

    public void deletar(Long id) { repo.deleteById(id); }
}

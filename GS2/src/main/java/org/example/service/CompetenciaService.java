package org.example.service;

import org.example.model.Competencia;
import org.example.repository.CompetenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaService {

    private final CompetenciaRepository repo;

    public CompetenciaService(CompetenciaRepository repo) { this.repo = repo; }

    public List<Competencia> listarTodos() { return repo.findAll(); }
    public Competencia buscarPorId(Long id) { return repo.findById(id).orElseThrow(); }
    public Competencia criar(Competencia c) { return repo.save(c); }
    public Competencia atualizar(Long id, Competencia c) {
        Competencia existente = buscarPorId(id);
        existente.setNome(c.getNome());
        existente.setCategoria(c.getCategoria());
        existente.setDescricao(c.getDescricao());
        return repo.save(existente);
    }
    public void deletar(Long id) { repo.deleteById(id); }
}


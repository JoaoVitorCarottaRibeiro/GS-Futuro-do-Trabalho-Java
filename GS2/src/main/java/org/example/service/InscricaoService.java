package org.example.service;

import org.example.exception.InscricaoNaoEncontradaException;
import org.example.model.Inscricao;
import org.example.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository repo;

    public InscricaoService(InscricaoRepository repo) { this.repo = repo; }

    public List<Inscricao> listarTodas() { return repo.findAll(); }

    public Inscricao criar(Inscricao i) { return repo.save(i); }

    public void deletar(Long id) {
        if (!repo.existsById(id)) throw new InscricaoNaoEncontradaException(id);
        repo.deleteById(id);
    }
}

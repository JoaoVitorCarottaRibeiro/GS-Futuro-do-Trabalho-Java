package org.example.service;

import org.example.exception.TrilhaNaoEncontradaException;
import org.example.model.Sinal;
import org.example.repository.SinalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinalService {

    @Autowired
    private SinalRepository sinalRepository;

    public List<Sinal> listarTodos() {
        return sinalRepository.findAll();
    }

    public Sinal buscarPorId(Long id) {
        return sinalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sinal não encontrado."));
    }

    public Sinal criar(Sinal sinal) {
        return sinalRepository.save(sinal);
    }

    public Sinal atualizar(Long id, Sinal novoSinal) {
        Sinal existente = buscarPorId(id);

        existente.setDados(novoSinal.getDados());

        return sinalRepository.save(existente);
    }

    public void deletar(Long id) {
        sinalRepository.deleteById(id);
    }
}



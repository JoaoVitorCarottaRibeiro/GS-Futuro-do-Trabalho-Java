package org.example.controller;

import org.example.model.TrilhaDeAprendizagem;
import org.example.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
@CrossOrigin("*")
public class TrilhaController {

    private final TrilhaService service;
    public TrilhaController(TrilhaService s) { this.service = s; }

    @GetMapping
    public ResponseEntity<List<TrilhaDeAprendizagem>> listar() { return ResponseEntity.ok(service.listarTodas()); }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDeAprendizagem> buscar(@PathVariable Long id) { return ResponseEntity.ok(service.buscarPorId(id)); }

    @PostMapping
    public ResponseEntity<TrilhaDeAprendizagem> criar(@Valid @RequestBody TrilhaDeAprendizagem t) { return ResponseEntity.status(201).body(service.criar(t)); }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDeAprendizagem> atualizar(@PathVariable Long id, @Valid @RequestBody TrilhaDeAprendizagem t) { return ResponseEntity.ok(service.atualizar(id, t)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) { service.deletar(id); return ResponseEntity.noContent().build(); }
}

package org.example.controller;

import org.example.model.Competencia;
import org.example.service.CompetenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencias")
@CrossOrigin("*")
public class CompetenciaController {

    private final CompetenciaService service;

    public CompetenciaController(CompetenciaService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Competencia>> listar() { return ResponseEntity.ok(service.listarTodos()); }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> buscar(@PathVariable Long id) { return ResponseEntity.ok(service.buscarPorId(id)); }

    @PostMapping
    public ResponseEntity<Competencia> criar(@RequestBody Competencia c) { return ResponseEntity.status(201).body(service.criar(c)); }

    @PutMapping("/{id}")
    public ResponseEntity<Competencia> atualizar(@PathVariable Long id, @RequestBody Competencia c) { return ResponseEntity.ok(service.atualizar(id, c)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) { service.deletar(id); return ResponseEntity.noContent().build(); }
}


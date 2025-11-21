package org.example.controller;

import org.example.model.Sinal;
import org.example.service.SinalService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sinais")
public class SinalController {

    private final SinalService service;

    public SinalController(SinalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Sinal>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sinal> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Sinal> criar(@Valid @RequestBody Sinal sinal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(sinal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sinal> atualizar(@PathVariable Long id, @Valid @RequestBody Sinal sinal) {
        return ResponseEntity.ok(service.atualizar(id, sinal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


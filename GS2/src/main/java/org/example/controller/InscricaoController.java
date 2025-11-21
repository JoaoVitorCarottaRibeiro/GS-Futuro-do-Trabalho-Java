package org.example.controller;

import org.example.exception.TrilhaNaoEncontradaException;
import org.example.exception.UsuarioNaoEncontradoException;
import org.example.model.Inscricao;
import org.example.model.TrilhaDeAprendizagem;
import org.example.model.Usuario;
import org.example.repository.TrilhaRepository;
import org.example.repository.UsuarioRepository;
import org.example.service.InscricaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscricoes")
@CrossOrigin("*")
public class InscricaoController {

    private final InscricaoService inscricaoService;
    private final UsuarioRepository usuarioRepo;
    private final TrilhaRepository trilhaRepo;

    public InscricaoController(InscricaoService s, UsuarioRepository uRepo, TrilhaRepository tRepo) {
        this.inscricaoService = s;
        this.usuarioRepo = uRepo;
        this.trilhaRepo = tRepo;
    }

    @GetMapping
    public ResponseEntity<?> listar() { return ResponseEntity.ok(inscricaoService.listarTodas()); }

    @PostMapping("/usuario/{usuarioId}/trilha/{trilhaId}")
    public ResponseEntity<Inscricao> inscrever(@PathVariable Long usuarioId, @PathVariable Long trilhaId) {
        Usuario u = usuarioRepo.findById(usuarioId).orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
        TrilhaDeAprendizagem t = trilhaRepo.findById(trilhaId).orElseThrow(() -> new TrilhaNaoEncontradaException(trilhaId));
        Inscricao i = new Inscricao(u, t);
        return ResponseEntity.status(201).body(inscricaoService.criar(i));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) { inscricaoService.deletar(id); return ResponseEntity.noContent().build(); }
}

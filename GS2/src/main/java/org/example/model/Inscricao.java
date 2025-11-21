package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "inscricoes")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "trilha_id")
    private TrilhaDeAprendizagem trilha;

    private LocalDate dataInscricao = LocalDate.now();

    private String status = "ATIVA";

    public Inscricao() {}

    public Inscricao(Usuario usuario, TrilhaDeAprendizagem trilha) {
        this.usuario = usuario;
        this.trilha = trilha;
    }
}

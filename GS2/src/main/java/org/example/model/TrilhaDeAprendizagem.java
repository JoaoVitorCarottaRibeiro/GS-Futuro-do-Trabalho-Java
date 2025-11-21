package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "trilhas")
public class TrilhaDeAprendizagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da trilha é obrigatório")
    private String nome;

    @Enumerated(EnumType.STRING)
    private NivelTrilha nivel;

    @Min(value = 1, message = "Carga horária deve ser positiva")
    private int cargaHoraria;

    @ManyToMany
    @JoinTable(
            name = "trilha_competencia",
            joinColumns = @JoinColumn(name = "trilha_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private Set<Competencia> competencias = new HashSet<>();

    public TrilhaDeAprendizagem() {}

    public TrilhaDeAprendizagem(Long id, String nome, NivelTrilha nivel, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.cargaHoraria = cargaHoraria;
    }
}

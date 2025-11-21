package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sinais")
public class Sinal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O dado do sinal é obrigatório.")
    @Column(columnDefinition = "TEXT")
    private String dados;

    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Sinal() {}
    public Sinal(String dados) { this.dados = dados; }

}

package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Min(value = 0, message = "Idade não pode ser negativa")
    private Integer idade;

    private String profissao;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    public Usuario() {}

    public Usuario(Long id, String nome, Integer idade, String profissao, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
        this.email = email;
        this.senha = senha;
    }
}

package org.example;

import org.example.model.NivelTrilha;
import org.example.model.TrilhaDeAprendizagem;
import org.example.model.Usuario;
import org.example.repository.TrilhaRepository;
import org.example.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class    GSApplication {

    public static void main(String[] args) {
        SpringApplication.run(GSApplication.class, args);
    }
}

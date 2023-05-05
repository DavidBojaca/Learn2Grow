package com.example.learn2grow.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Entity
@Data
public class RespuestasEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;


    private String respuesta;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDateTime fechaRegistro;


    @PrePersist
    private void asignarFechaRegistro(){
        fechaRegistro= LocalDateTime.now();

    }


    @ManyToOne()
    @JoinColumn(name = "FK_comentario")
    ComentariosEstudiante comentarioEstudiante;
}

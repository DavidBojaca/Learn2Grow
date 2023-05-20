package com.example.learn2grow.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
public class ComentariosProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id_comentario_profesor;

    private String name;
    private String comentario;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDateTime fechaRegistro;


    @PrePersist
    private void asignarFechaRegistro(){
        fechaRegistro= LocalDateTime.now();
    }

    @ManyToOne()
    @JoinColumn(name = "FK_Profesor")
    ComentariosProfesor comentariosProfesor;
}

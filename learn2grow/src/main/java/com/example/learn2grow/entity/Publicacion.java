package com.example.learn2grow.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String descripcion;


    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDateTime fechaCreacion;

    @PrePersist
    private void asignarFechaRegistro(){
        fechaCreacion= LocalDateTime.now();
    }




}

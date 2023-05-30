package com.example.learn2grow.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class ComentariosEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "comantario")
    private String comentario;


    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDateTime fechaRegistro;


    @PrePersist
    private void asignarFechaRegistro(){
        fechaRegistro= LocalDateTime.now();
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "comentarioEstudiante")
    private List<RespuestasEstudiante> listRespuesta;



}

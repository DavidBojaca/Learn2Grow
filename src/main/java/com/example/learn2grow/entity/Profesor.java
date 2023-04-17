package com.example.learn2grow.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cc;
    private String name;
    private String apellido;
    private String estudios;
    private String descripcion;
    private String correo;
    private String mentor;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaNacimiento;

    @PrePersist
    private void asignarFechaRegistro(){
        fechaRegistro= LocalDateTime.now();
    }


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id_comentario_profesor")
    private List<ComentariosProfesor> listComentarios;



}

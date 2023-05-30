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


    private boolean mentor;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDateTime fechaRegistro;

    @PrePersist
    private void asignarFechaRegistro(){
        fechaRegistro= LocalDateTime.now();
    }


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id_comentario_profesor")
    private List<ComentariosProfesor> listComentarios;

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

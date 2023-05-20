package com.example.learn2grow.repository;

import com.example.learn2grow.entity.ComentariosEstudiante;
import com.example.learn2grow.entity.Profesor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProfesoresCrudRepository extends CrudRepository<Profesor, Long> {
    @Query("select p from Profesor p where p.correoElectronico = ?1 and p.contrasena = ?2")
    Profesor findByCorreo(String correoElectronico, String contrasena);
}
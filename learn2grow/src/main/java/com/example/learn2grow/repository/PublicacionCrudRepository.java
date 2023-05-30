package com.example.learn2grow.repository;

import com.example.learn2grow.entity.Profesor;
import com.example.learn2grow.entity.Publicacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PublicacionCrudRepository extends CrudRepository<Publicacion, Long> {
    //@Query("select p from Profesor p where p.correoElectronico = ?1 and p.contrasena = ?2")
    //Profesor findByCorreo(String correoElectronico, String contrasena);
}
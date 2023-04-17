package com.example.learn2grow.repository;

import com.example.learn2grow.entity.ComentariosEstudiante;
import com.example.learn2grow.entity.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesoresCrudRepository extends CrudRepository<Profesor, Long> {
}
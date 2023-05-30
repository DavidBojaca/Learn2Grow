package com.example.learn2grow.repository;

import com.example.learn2grow.entity.ComentariosEstudiante;
import com.example.learn2grow.entity.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfesoresRepository {

    @Autowired
    private ProfesoresCrudRepository profesoresCrudRepository;

    public Profesor findByCorreo(String correoElectronico, String contrasena) {
        return profesoresCrudRepository.findByCorreo(correoElectronico, contrasena);
    }

    public List<Profesor> findAll() {
        return (List<Profesor>) profesoresCrudRepository.findAll();
    }

    public Optional<Profesor> findById(Long id) {
        return profesoresCrudRepository.findById(id);
    }

    public <S extends Profesor> S save(S profesor) {
        return profesoresCrudRepository.save(profesor);
    }

    public void deleteById(Long id) {
        profesoresCrudRepository.deleteById(id);
    }



}




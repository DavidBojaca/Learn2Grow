package com.example.learn2grow.repository;

import java.util.List;
import java.util.Optional;


import com.example.learn2grow.entity.RespuestasEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RespuestasEstudianteRepository {

    @Autowired
    private RespuestasEstudianteCrudRepository respuestasEstudianteCrudRepository;

    public List<RespuestasEstudiante> findAll() {
        return (List<RespuestasEstudiante>) respuestasEstudianteCrudRepository.findAll();
    }

    public Optional<RespuestasEstudiante> findById(Long id) {
        return respuestasEstudianteCrudRepository.findById(id);
    }

    public <S extends RespuestasEstudiante> S save(S respuestasEstudiante) {
        return respuestasEstudianteCrudRepository.save(respuestasEstudiante);
    }

    public void deleteById(Long id) {
        respuestasEstudianteCrudRepository.deleteById(id);
    }
}




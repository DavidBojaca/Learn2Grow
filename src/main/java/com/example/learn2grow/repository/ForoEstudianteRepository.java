package com.example.learn2grow.repository;

import java.util.List;
import java.util.Optional;

import com.example.learn2grow.entity.ForoEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ForoEstudianteRepository{

    @Autowired
    private ForoEstudianteCrudRepository foroEstudianteCrudRepository;

    public List<ForoEstudiante> findAll() {
        return (List<ForoEstudiante>) foroEstudianteCrudRepository.findAll();
    }

    public Optional<ForoEstudiante> findById(Long id) {
        return foroEstudianteCrudRepository.findById(id);
    }

    public <S extends ForoEstudiante> S save(S foroEstudiante) {
        return foroEstudianteCrudRepository.save(foroEstudiante);
    }

    public void deleteById(Long id) {
        foroEstudianteCrudRepository.deleteById(id);
    }
}




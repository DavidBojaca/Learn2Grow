package com.example.learn2grow.repository;

import java.util.List;
import java.util.Optional;

import com.example.learn2grow.entity.ComentariosEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComentariosEstudianteRepository {

    @Autowired
    private ComentariosEstudianteCrudRepository comentariosEstudianteCrudRepository;

    public List<ComentariosEstudiante> findAll() {
        return (List<ComentariosEstudiante>) comentariosEstudianteCrudRepository.findAll();
    }

    public Optional<ComentariosEstudiante> findById(Long id) {
        return comentariosEstudianteCrudRepository.findById(id);
    }

    public <S extends ComentariosEstudiante> S save(S comentariosEstudiante) {
        return comentariosEstudianteCrudRepository.save(comentariosEstudiante);
    }

    public void deleteById(Long id) {
        comentariosEstudianteCrudRepository.deleteById(id);
    }
}




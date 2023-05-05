package com.example.learn2grow.repository;

import java.util.List;
import java.util.Optional;

import com.example.learn2grow.entity.ComentariosProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComentariosProfesorRepository {

    @Autowired
    private ComentariosProfesorCrudRepository comentariosProfesorCrudRepository;

    public List<ComentariosProfesor> findAll() {
        return (List<ComentariosProfesor>) comentariosProfesorCrudRepository.findAll();
    }

    public Optional<ComentariosProfesor> findById(Long id) {
        return comentariosProfesorCrudRepository.findById(id);
    }

    public <S extends ComentariosProfesor> S save(S foroProfesor) {
        return comentariosProfesorCrudRepository.save(foroProfesor);
    }

    public void deleteById(Long id) {
        comentariosProfesorCrudRepository.deleteById(id);
    }
}

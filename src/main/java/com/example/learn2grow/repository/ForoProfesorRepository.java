package com.example.learn2grow.repository;

import java.util.List;
import java.util.Optional;

import com.example.learn2grow.entity.ForoProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ForoProfesorRepository{

    @Autowired
    private ForoProfesorCrudRepository foroProfesorCrudRepository;

    public List<ForoProfesor> findAll() {
        return (List<ForoProfesor>) foroProfesorCrudRepository.findAll();
    }

    public Optional<ForoProfesor> findById(Long id) {
        return foroProfesorCrudRepository.findById(id);
    }

    public <S extends ForoProfesor> S save(S foroProfesor) {
        return foroProfesorCrudRepository.save(foroProfesor);
    }

    public void deleteById(Long id) {
        foroProfesorCrudRepository.deleteById(id);
    }
}

package com.example.learn2grow.repository;

import com.example.learn2grow.entity.Profesor;
import com.example.learn2grow.entity.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PublicacionRepository {

    @Autowired
    private PublicacionCrudRepository publicacionCrudRepository;


    public List<Publicacion> findAll() {
        return (List<Publicacion>) publicacionCrudRepository.findAll();
    }

    public Optional<Publicacion> findById(Long id) {
        return publicacionCrudRepository.findById(id);
    }

    public <S extends Publicacion> S save(S publicacion) {
        return publicacionCrudRepository.save(publicacion);
    }

    public void deleteById(Long id) {
        publicacionCrudRepository.deleteById(id);
    }



}




package com.example.learn2grow.service;


import com.example.learn2grow.entity.Profesor;
import com.example.learn2grow.entity.Publicacion;
import com.example.learn2grow.repository.ProfesoresRepository;
import com.example.learn2grow.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;
    public List<Publicacion> getAll(){
        return publicacionRepository.findAll();
    }

    public Publicacion save(Publicacion fp){
        return publicacionRepository.save(fp);
    }

    public Publicacion get(Long id){
        Optional<Publicacion> g= publicacionRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            Publicacion rta=new Publicacion();

            return rta;
        }

    }


}

package com.example.learn2grow.service;


import com.example.learn2grow.entity.ComentariosProfesor;
import com.example.learn2grow.repository.ComentariosProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentariosProfesorService {

    @Autowired
    private ComentariosProfesorRepository comentariosProfesorRepository;
    public List<ComentariosProfesor> getAll(){
        return comentariosProfesorRepository.findAll();
    }

    public ComentariosProfesor save(ComentariosProfesor fp){
        return comentariosProfesorRepository.save(fp);
    }

    public ComentariosProfesor get(Long id){
        Optional<ComentariosProfesor> g= comentariosProfesorRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            ComentariosProfesor rta=new ComentariosProfesor();
            //rta.setName("Paila!");
            return rta;
        }

    }
}

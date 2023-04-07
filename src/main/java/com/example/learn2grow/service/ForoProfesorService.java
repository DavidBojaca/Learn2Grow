package com.example.learn2grow.service;


import com.example.learn2grow.entity.ForoProfesor;
import com.example.learn2grow.repository.ForoProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForoProfesorService {

    @Autowired
    private ForoProfesorRepository foroProfesorRepository;
    public List<ForoProfesor> getAll(){
        return foroProfesorRepository.findAll();
    }

    public ForoProfesor save(ForoProfesor fp){
        return foroProfesorRepository.save(fp);
    }

    public ForoProfesor get(Long id){
        Optional<ForoProfesor> g=foroProfesorRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            ForoProfesor rta=new ForoProfesor();
            //rta.setName("Paila!");
            return rta;
        }

    }
}

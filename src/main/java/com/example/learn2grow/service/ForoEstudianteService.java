package com.example.learn2grow.service;

import com.example.learn2grow.entity.ForoEstudiante;
import com.example.learn2grow.repository.ForoEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForoEstudianteService {

    @Autowired
    private ForoEstudianteRepository foroEstudianteRepository;
    public List<ForoEstudiante> getAll(){
        return foroEstudianteRepository.findAll();
    }

    public ForoEstudiante save(ForoEstudiante g){
        return foroEstudianteRepository.save(g);
    }

    public ForoEstudiante get(Long id){
        Optional<ForoEstudiante> g=foroEstudianteRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            ForoEstudiante rta=new ForoEstudiante();
            rta.setName("Paila!");
            return rta;
        }
    }


}

package com.example.learn2grow.service;


import com.example.learn2grow.entity.ComentariosProfesor;
import com.example.learn2grow.entity.RespuestasEstudiante;
import com.example.learn2grow.repository.ComentariosProfesorRepository;
import com.example.learn2grow.repository.RespuestasEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestasEstudianteService {

    @Autowired
    private RespuestasEstudianteRepository respuestasEstudianteRepository;
    public List<RespuestasEstudiante> getAll(){
        return respuestasEstudianteRepository.findAll();
    }

    public RespuestasEstudiante save(RespuestasEstudiante fp){
        return respuestasEstudianteRepository.save(fp);
    }

    public RespuestasEstudiante get(Long id){
        Optional<RespuestasEstudiante> g= respuestasEstudianteRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            RespuestasEstudiante rta=new RespuestasEstudiante();
            //rta.setName("Paila!");
            return rta;
        }

    }
}

package com.example.learn2grow.service;

import com.example.learn2grow.entity.ComentariosEstudiante;
import com.example.learn2grow.repository.ComentariosEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ComentariosEstudianteService {

    @Autowired
    private ComentariosEstudianteRepository comentariosEstudianteRepository;
    public List<ComentariosEstudiante> getAll(){
        return comentariosEstudianteRepository.findAll();
    }

    public ComentariosEstudiante save(ComentariosEstudiante g){
        g.setFechaRegistro(LocalDateTime.now());
        return comentariosEstudianteRepository.save(g);
    }

    public ComentariosEstudiante get(Long id){
        Optional<ComentariosEstudiante> g= comentariosEstudianteRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            ComentariosEstudiante rta=new ComentariosEstudiante();
            rta.setName("Paila!");
            return rta;
        }
    }


}

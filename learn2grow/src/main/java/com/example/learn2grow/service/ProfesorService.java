package com.example.learn2grow.service;


import com.example.learn2grow.entity.ComentariosProfesor;
import com.example.learn2grow.entity.Profesor;
import com.example.learn2grow.repository.ComentariosProfesorRepository;
import com.example.learn2grow.repository.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesoresRepository profesoresRepository;
    public List<Profesor> getAll(){
        return profesoresRepository.findAll();
    }

    public Profesor save(Profesor fp){
        return profesoresRepository.save(fp);
    }

    public Profesor get(Long id){
        Optional<Profesor> g= profesoresRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            Profesor rta=new Profesor();

            return rta;
        }

    }

    public Profesor findByCorreo(String correoElectronico, String contrasena) {
        return profesoresRepository.findByCorreo(correoElectronico, contrasena);
    }
}

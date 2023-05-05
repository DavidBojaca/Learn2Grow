package com.example.learn2grow.controller;

import com.example.learn2grow.entity.ComentariosProfesor;
import com.example.learn2grow.service.ComentariosProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/foroprofesores")
public class ControllerForoProfesores {

    @Autowired
    private ComentariosProfesorService comentariosProfesorServices;

    //Que me extariga todos en un archivo json estudiante
    @GetMapping("/all")
    public List<ComentariosProfesor> getAll(){
        return comentariosProfesorServices.getAll();
    }
    //Recibe un game via json y nos lo va a guardar estudiante
    @PostMapping("/save")
    public ComentariosProfesor save(@RequestBody ComentariosProfesor g){
        return comentariosProfesorServices.save(g);
    }

}

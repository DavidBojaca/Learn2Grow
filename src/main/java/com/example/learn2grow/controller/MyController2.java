package com.example.learn2grow.controller;

import com.example.learn2grow.entity.ForoEstudiante;
import com.example.learn2grow.entity.ForoProfesor;
import com.example.learn2grow.service.ForoProfesorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/learn2grow")
public class MyController2 {
    
    private ForoProfesorService foroProfesorServices;

    //Que me extariga todos en un archivo json estudiante
    @GetMapping("/allprofesor")
    public List<ForoProfesor> getAll(){
        return foroProfesorServices.getAll();
    }
    //Recibe un game via json y nos lo va a guardar estudiante
    @PostMapping("/saveprofesor")
    public ForoProfesor save(@RequestBody ForoProfesor g){
        return foroProfesorServices.save(g);
    }

}

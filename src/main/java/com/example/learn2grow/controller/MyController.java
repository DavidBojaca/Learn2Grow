package com.example.learn2grow.controller;

import com.example.learn2grow.entity.ForoEstudiante;
import com.example.learn2grow.service.ForoEstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learn2grow")
public class MyController {


    private ForoEstudianteService foroEstudianteServices;

    @GetMapping("/prueba")
    public  String prueba(){
        return  "<h1>Esto es un mensaje de prueba</h1>";
    }

    //Que me extariga todos en un archivo json estudiante
    @GetMapping("/allestudiante")
    public List<ForoEstudiante> getAll(){
        return foroEstudianteServices.getAll();
    }
    //Recibe un game via json y nos lo va a guardar estudiante
    @PostMapping("/saveestudiante")
    public ForoEstudiante save(@RequestBody ForoEstudiante g){
        return foroEstudianteServices.save(g);
    }


}

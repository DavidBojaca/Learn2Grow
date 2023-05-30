package com.example.learn2grow.controller;


import com.example.learn2grow.entity.ComentariosEstudiante;
import com.example.learn2grow.entity.Profesor;
import com.example.learn2grow.entity.RespuestasEstudiante;
import com.example.learn2grow.service.ComentariosEstudianteService;
import com.example.learn2grow.service.ComentariosProfesorService;
import com.example.learn2grow.service.ProfesorService;
import com.example.learn2grow.service.RespuestasEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ControllerProfesores {

    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private ComentariosProfesorService comentariosProfesorService;

    //Que me extariga todos en un archivo json estudiante
    @GetMapping("/all")
    public List<Profesor> getAll(){
        return profesorService.getAll();
    }



    //Recibe un game via json y nos lo va a guardar estudiante
    @PostMapping("/save")
    public Profesor save(@RequestBody Profesor c){

        return profesorService.save(c);
    }
    @GetMapping ("/validate/{correoElectronico}/{contrasena}")
    public Profesor finByCorreo(@PathVariable("correoElectronico") String correoElectronico, @PathVariable("contrasena") String contrasena){
        return profesorService.findByCorreo(correoElectronico, contrasena);
    }



}

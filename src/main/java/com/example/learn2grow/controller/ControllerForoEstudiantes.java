package com.example.learn2grow.controller;


import ch.qos.logback.core.model.Model;
import com.example.learn2grow.entity.ComentariosEstudiante;
import com.example.learn2grow.entity.RespuestasEstudiante;
import com.example.learn2grow.service.ComentariosEstudianteService;
import com.example.learn2grow.service.RespuestasEstudianteService;
import jakarta.annotation.Resource;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.HTML;
import java.io.IOException; 
import java.util.List;

@RestController
@RequestMapping("/api/foroestudiantes")
public class ControllerForoEstudiantes {

    @Autowired
    private ComentariosEstudianteService comentariosEstudianteServices;
    @Autowired
    private RespuestasEstudianteService respuestasEstudianteServices;

    @GetMapping("/prueba")
    public  String prueba(){
        return  "<h1>Esto es un mensaje de prueba</h1>";
    }


    //Que me extariga todos en un archivo json estudiante
    @GetMapping("/all")
    public List<ComentariosEstudiante> getAll(){
        return comentariosEstudianteServices.getAll();
    }



    //Recibe un game via json y nos lo va a guardar estudiante
    @PostMapping("/save")
    public ComentariosEstudiante save(@RequestBody ComentariosEstudiante c){

        return comentariosEstudianteServices.save(c);
    }

    @PostMapping("/saverespuesta")
    public RespuestasEstudiante save(@RequestBody RespuestasEstudiante r){

        return respuestasEstudianteServices.save(r);
    }



}

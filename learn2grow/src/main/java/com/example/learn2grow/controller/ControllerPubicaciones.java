package com.example.learn2grow.controller;


import com.example.learn2grow.entity.Profesor;
import com.example.learn2grow.entity.Publicacion;
import com.example.learn2grow.service.ComentariosProfesorService;
import com.example.learn2grow.service.ProfesorService;
import com.example.learn2grow.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class ControllerPubicaciones {

    @Autowired
    private PublicacionService publicacionService;


    //Que me extariga todos en un archivo json estudiante
    @GetMapping("/all")
    public List<Publicacion> getAll(){
        return publicacionService.getAll();
    }



    //Recibe un game via json y nos lo va a guardar estudiante
    @PostMapping("/save")
    public Publicacion save(@RequestBody Publicacion c){

        return publicacionService.save(c);
    }
    @PostMapping("/upload")
     public String uploadFile(@RequestParam("archivo")MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return "No se recibio ningun archivo";
        }



            String destino ="src/main/java/com/example/learn2grow/Publicaciones/";

            try {
                guardarMultiPartFile(file,destino);
                return "Archivo copiado correctamente";

            } catch (IOException e) {
                e.printStackTrace();
                return "Error al guardar el archivo";
            }
     }

    public static void guardarMultiPartFile(MultipartFile file, String destio)throws IOException{
       String nombreArchivo= file.getOriginalFilename();
       Path rutaDestino = Path.of(destio+nombreArchivo);

       Files.createDirectories(rutaDestino.getParent());
       Files.copy(file.getInputStream(),rutaDestino, StandardCopyOption.REPLACE_EXISTING);
    }














}

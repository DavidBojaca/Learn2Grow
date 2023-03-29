package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Dominio.Comentario;
import jakarta.servlet.http.HttpServletRequest;



public class Logica {



    public static void escritor_txt(String tetx) {
        
        try {
            // Crear instancia de File
            File archivo = new File("Comentarios_foro/Comentarios_foro.txt");
            
            // Crear instancia de FileWriter
            FileWriter escritor = new FileWriter(archivo);
            
            // Escribir la cadena de caracteres en el archivo
            escritor.write("Hola, este es mi archivo de texto!");
            
            // Cerrar el FileWriter
            escritor.close();
            
            System.out.println("Archivo creado exitosamente.");
            
        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
            e.printStackTrace();
        }
        
    }

    public void extraer_comentario(Comentario coment) {

        escritor_txt(coment.getNombre());
        escritor_txt(coment.getComentario());
    }


   
}

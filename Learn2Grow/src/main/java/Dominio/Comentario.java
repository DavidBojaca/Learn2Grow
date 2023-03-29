/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author ubuntu
 */
public class Comentario {
    private String nombre;
    private String comentario;
    
    
    public Comentario(String comentario, String nombre){
        this.comentario=comentario;
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getComentario() {
        return comentario;
    }


    public void setComentario(String comentario) {
        this.comentario = comentario;
    } 


}

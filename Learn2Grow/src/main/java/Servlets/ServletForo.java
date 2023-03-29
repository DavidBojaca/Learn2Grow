/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dominio.Comentario;
import Modelo.Logica;

/**
 *
 * @author ubuntu
 */

@WebServlet(name = "Servlet", urlPatterns = {"/Foro"})
public class ServletForo extends HttpServlet {

   
    // Da informacion y da cambios que solicta el usuario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            Logica lgc = new Logica();
            PrintWriter out = response.getWriter();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
    
            String line = utils.Utils.readParams(request);
            Comentario coment = (Comentario) utils.Utils.fromJson(line, Comentario.class);
            
            lgc.extraer_comentario(coment);
            
            out.println();
        
        
    }
    

    // Funciona como un writer de los objetos 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();

            out.println("Se recivio el archivo");
            
            Logica lgc = new Logica();

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/json ;charset=UTF-8");
            
            request.getCharacterEncoding();
            
           
    
            String line = utils.Utils.readParams(request);
            Comentario coment = (Comentario) utils.Utils.fromJson(line, Comentario.class);
            
            lgc.extraer_comentario(coment);
            
            
        
        
        
    }
    
    
    //se hace para la edicion de los objetos en una peticion
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html ;charset=UTF-8");
            request.getCharacterEncoding();
            String line = utils.Utils.readParams(request);
            Comentario coment = (Comentario) utils.Utils.fromJson(line, Comentario.class);

            out.println();

            
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   
}

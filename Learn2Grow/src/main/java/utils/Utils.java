package utils;

import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

/**
 *
 * @author ubuntu
 */
public class Utils {
    
    public static GsonBuilder builder = null;
    
    public static String toJson(Object obj) {

         builder = new GsonBuilder();
        return builder.create().toJson(obj);
    }
    
    public static Object fromJson(String j,Class c){
        
         builder = new GsonBuilder();
        
        return builder.create().fromJson(j, c);
        
    }
    
    
    public static String readParams(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            request.setCharacterEncoding("UTF-8");
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            /* report an error */ }

 

        line = jb.toString();
        return line;
    }
   

    
}

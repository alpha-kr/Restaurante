/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author ivan
 */
public class FileToList {
    public static void toList(List lista, String name){
        String texto = "";        
        try {
            FileReader lector = new FileReader(name+".txt");
            BufferedReader contenido = new BufferedReader(lector);
            while ((texto = contenido.readLine()) != null) {
                lista.add(texto);
            }
            lector.close();
        }catch (Exception e) {
            System.out.println("Error al leer");
        }
    }
}

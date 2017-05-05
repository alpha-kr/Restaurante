/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author ivan
 */
public class Limpiador {
    public static void limpiar(){
        String dato = "";
        try {
            File archivo = new File("Platos Elaborados.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(dato);
            escritor.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}

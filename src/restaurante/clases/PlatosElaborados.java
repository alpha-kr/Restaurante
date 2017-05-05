/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.clases;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author ivan
 */
public class PlatosElaborados {

    public static void elaborados(int cant, String elab) {
        String dato = cant + ";" + elab + "\r\n";
        try {
            File archivo = new File("Platos Elaborados.txt");
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.write(dato);
            escritor.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}

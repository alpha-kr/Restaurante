/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author ivan
 */
public class LeerGeneradas {
    public static int Generadas(int canti) {
//Creamos un String que va a contener todo el texto del archivo
        String texto = "";

        try {
//Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector = new FileReader("FacturasGeneradas.txt");

//El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido = new BufferedReader(lector);

//Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            while ((texto = contenido.readLine()) != null) {
                System.out.println(texto);
                canti = Integer.parseInt(texto);
            }
            
        } //Si se causa un error al leer cae aqui
        catch (Exception e) {
            System.out.println("Error al leer");
        }
        
        return canti;
    }
}

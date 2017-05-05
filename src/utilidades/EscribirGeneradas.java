/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

/**
 *
 * @author ivan
 */
/*Clase que permite escribir en un archivo de texto*/
//Importamos clases que se usaran
import java.io.File;
import java.io.FileWriter;

public class EscribirGeneradas {

    public static void write(int Facturas) {

//Un texto cualquiera guardado en una variable
        
        String dato = ""+Facturas;

        try(FileWriter escritor = new FileWriter(new File("FacturasGeneradas.txt"))) {
//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor

            //File archivo = new File("factura" + n + ".txt");

//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            //FileWriter escritor = new FileWriter(archivo, true);

//Escribimos en el archivo con el metodo write
            escritor.write(dato);
            //escritor.write("\r\n");

//Cerramos la conexion
            escritor.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}

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
public class EscribirPedidos {
    public static void escribir(int cantidad, String plato, String precio, String n,double totalproducto) {
        //Un texto cualquiera guardado en una variable
        /*int x;
        System.in.read(x);*/
        String formato = "   "+cantidad+" "+ plato+"              "+precio+"  "+totalproducto+"\r\n";
                
        

        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor

            File archivo = new File("factura" + n + ".txt");

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter fw = new FileWriter(archivo, true);

            //Escribimos en el archivo con el metodo write
            fw.write(formato);

            //Cerramos la conexion
            fw.close();
        }   //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}

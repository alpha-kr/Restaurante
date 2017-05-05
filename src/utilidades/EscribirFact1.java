/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ivan
 */
public class EscribirFact1 {
    public static void escribir(String n, int mesa, int cantidad) {
        
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String linea = "------------------------------------------------------\r\n";
        String formato = "          RESTAURANTE LA PROSPERIDAD \r\n"+"                  Dirección \r\n"
                + "        REGISTRO ICONTEC I.V.A INCLUIDO \r\n"+"          TELEFONO correo@example.com \r\n"
                + linea+"FACTURA 0000"+cantidad+"	              FECHA:"+dia+"/"+mes+"/"+año+"\r\n"+linea+"MESA:"+mesa+"                             PÁGINA:001\r\n"+linea+
                "UNI. DESCRIPCIÓN            PRECIO     IMPORTE\r\n"+linea;
        

        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor

            File archivo = new File("factura" + n + ".txt");

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter fw = new FileWriter(archivo);

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

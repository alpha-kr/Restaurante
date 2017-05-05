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
public class EscribirFact2 {
    public static void escribir(String n, double total,double iva,double propina,double totalneto) {
        //Un texto cualquiera guardado en una variable
        /*int x;
        System.in.read(x);*/
        
        String linea = "------------------------------------------------------\r\n";
        String formato = linea+"TOTAL BRUTO           %IVA                 IVA\r\n"+"   "+totalneto+"            %19              "+iva+"\r\n"
                +linea+"TOTAL BRUTO         %PROPINA           PROPINA\r\n"+"   "+totalneto+"             %10              "+propina+"\r\n"
                +linea+"   TOTAL                              "+total+"\r\n"+linea+"  CONTADO                             "+total+"\r\n"+linea+" CAJA UNICA                           TURNO  X\r\n"+linea
                +"    GRACIAS POR SU VISITA - VUELVA PRONTO";
        

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

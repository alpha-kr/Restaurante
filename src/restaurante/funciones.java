/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

 
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDY
 */
public   class funciones {
    public static ArrayList<restaurante.clases.orden>ord= new ArrayList<restaurante.clases.orden>();
        public static class user{
        String nombre;
        String ps;
        String tipo;
        user link;



}
      public static class plato{
        String nombre;
        String tipo;
        String precio;
        user link;



}
    
   static  user base = new user();
   public static ArrayList<restaurante.clases.pedido > buscarplatos(String tipo ,File a){
   ArrayList<restaurante.clases.pedido>platos= new  ArrayList<restaurante.clases.pedido>();
   
      try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
              
                while(lector.hasNextLine()){
                    String linea =lector.nextLine();
                   String []datos=linea.split(";");
                   restaurante.clases.pedido pedido= new restaurante.clases.pedido();
                    if (datos[2].equals(tipo)) {
                        pedido.setNombre(datos[1]);
                        pedido.setPrecio(Double.parseDouble(datos[3]));
                        pedido.setTipo(tipo);
                        platos.add(pedido);
                    }
                   
                  
                }
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
   
   return platos;
   }
    
    public static void escribir ( File archivo, String cadena){
    
    try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true) ) ;
                bw.write("\n"+cadena);
              
               bw.close();
            
            } catch (IOException ex) {
                System.out.println("Error Archivos");
            }
    
    
    
    }
     public static  void mostrarError(String titulo, String mensaje,Component c){
        JOptionPane.showMessageDialog(c,
                mensaje,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }
     public static user leeru( File a){
    user p= new user();user q = new user();
     try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
                int cont=0;
                while(lector.hasNextLine()){
                    cont++;
                    // Pedir la linea
                    String linea = lector.nextLine();
                    String[]datos=linea.split(";");
                    if (cont==1) {
                          p.tipo=datos[0];
              p.nombre=datos[1];
              p.ps=datos[2];
              p.link=null;   
                q=p;     }else{
                        
                        
                        user qa= new user();
                         qa.tipo=datos[0];
                        qa.nombre=datos[1];
                        qa.ps=datos[2]; qa.link=null;
                        while(q.link!=null){
                        
                        q=q.link;
                        
                        }
                       
                       
                        q.link=qa; 
                    }
         
                   
                }p.link=q;
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
     
     
     return p;
     }
      public static int registros(File a ){
      int num=0;
      
       try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
                int cont=0;
                while(lector.hasNextLine()){
                    lector.nextLine();
                    num++;
                   
                  
                }
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
      
      return num;
      }
     public static Boolean existe(){
     Boolean h=false;
     
     
     return h;}
    
}

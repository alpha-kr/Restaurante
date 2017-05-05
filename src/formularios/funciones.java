/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

 
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
 
import java.util.Date;
import java.util.GregorianCalendar;
 
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ANDY
 */

public   class funciones {
 public static    Calendar c2 = new GregorianCalendar();
  
      public static String dia=c2.get (Calendar.DATE)+"";
    public static ArrayList<restaurante.clases.orden>ord= new ArrayList<restaurante.clases.orden>();
    public static ArrayList<restaurante.clases.ingrediente> ingre= new ArrayList<restaurante.clases.ingrediente>();
    public static List<String> vendidos = new ArrayList<>();
    public static mesa mesas ;
    public static user meseros;
    public static class user{
        String nombre;
        int nummesas=0;
       List<restaurante.clases.orden>ordenes= new ArrayList<restaurante.clases.orden>();
        user link;



}
    public static class mesa{
    int num;
    List<restaurante.clases.pedido>ordenes= new ArrayList<restaurante.clases.pedido>();
mesa link;  

}
    
    
    
    public static void actualizarmeseros(File usuario,File diaa){
        System.out.println(""+dia);
       
        
        String viejodia=""+obtenerdia(diaa);
        if (!dia.equals(viejodia)) {
            BorrarFichero(usuario);
        sobreescribir(usuario);
        BorrarFichero(diaa);
        sobreescribir(diaa);
            escribir(diaa, dia);
            user p = meseros;
            while(p!=null){
                p.nummesas=0;
                escribir(usuario, p.nombre+";"+p.nummesas);
            p=p.link;
            }
            
        }
    
    
    
    }
    
    
          public static int obtenerdia(File a){
              int dia=0;
         try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
                int cont=0;
                while(lector.hasNextLine()){
                 String Linea=   lector.nextLine();
                  
                    if (!Linea.equals("")) {
                       dia=Integer.parseInt(Linea);
                    }
                 
                   
                  
                }
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
        
        
        return dia ;
        }
    
        public static void llenaringredientes(File a){
         try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
                int cont=0;
                while(lector.hasNextLine()){
                 String Linea=   lector.nextLine();
                  String []d=Linea.split(";");
                    if (!Linea.equals("")) {
                         restaurante.clases.ingrediente in= new restaurante.clases.ingrediente();
                  in.setId(Integer.parseInt(d[0]));
                  in.setPrecio(Double.parseDouble(d[3]));
                  in.setCantidad(Integer.parseInt(d[2]));
                  in.setNombre(d[1]);
                  ingre.add(in);
                    }
                 
                   
                  
                }
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
        
        
        
        }
        
      public static class plato{
        String nombre;
        String tipo;
        String precio;
        user link;



}
      public static boolean puedeordenar( String plato, File archivoingrediente){
boolean sw=false;
ArrayList<restaurante.clases.ingrediente >ing =ingredientesplato(  plato,archivoingrediente );
  int cont=0;
for (int i = 0; i < ing.size(); i++) {
                    int pos= 0;
                    for (int j = 0; j < funciones.ingre.size(); j++) {
                        if (ing.get(i).getNombre().equals(funciones.ingre.get(j).getNombre())) {
                            pos=j;
                        }
 
                    }
                   
                    if (funciones.ingre.get(pos).getCantidad()-ing.get(i).getCantidad()>0) {
                        cont++;
                    }
                   
                }
            if (cont==ing.size()) {
                sw=true;
            }
               

return sw;
}
       
    public static ArrayList<restaurante.clases.ingrediente >ingredientesplato(String plato,File a ){
    ArrayList<restaurante.clases.ingrediente >ingre= new  ArrayList<restaurante.clases.ingrediente >();
    
        try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
              
                while(lector.hasNextLine()){
                    String linea =lector.nextLine();
                   String []datos=linea.split(";");
                   restaurante.clases.ingrediente i=new  restaurante.clases.ingrediente();
                    if (datos[0].equals(plato)) {
                        i.setCantidad(Integer.parseInt(datos[2]));
                        i.setNombre(datos[1]);
                        i.setPrecio(0.0);
                        ingre.add(i);
                    }
                   
                  
                }
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
    
    return ingre;
    }
   static  user base = new user();
   public static ArrayList<restaurante.clases.pedido > buscarplatos(String tipo ,File a){
   ArrayList<restaurante.clases.pedido>platos= new  ArrayList<restaurante.clases.pedido>();
   
      try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
              
                while(lector.hasNextLine()){
                    String linea =lector.nextLine();
                    if (!linea.equals("")) {
                        String []datos=linea.split(";");
                   restaurante.clases.pedido pedido= new restaurante.clases.pedido();
                    if (datos[2].equals(tipo) && !linea.equals("")) {
                        pedido.setNombre(datos[1]);
                        pedido.setPrecio(Double.parseDouble(datos[3]));
                        pedido.setTipo(tipo);
                        platos.add(pedido);
                    }
                    
                    }
                  
                  
                }
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
   
   return platos;
   }
   public static  void BorrarFichero(File Ffichero){
     try {
         /*Si existe el fichero*/
         if(Ffichero.exists()){
           /*Borra el fichero*/  
           Ffichero.delete(); 
           System.out.println("Fichero Borrado con Exito");
         }
     } catch (Exception ex) {
         /*Captura un posible error y le imprime en pantalla*/ 
          System.out.println(ex.getMessage());
     }
} 
     public static void sobreescribir ( File archivo ){
         BorrarFichero(archivo);
        if (archivo.exists()==false) {
             try {
                 archivo.createNewFile();
             } catch (IOException ex) {
                 System.out.println("Error");
             }
        }  
         
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
        public static  void mostrarmensaje(String titulo, String mensaje,Component c){
        JOptionPane.showMessageDialog(c,
                mensaje,
                titulo,
                JOptionPane.PLAIN_MESSAGE);
    }
        public static boolean existeusuario(String nombre){
        boolean sw=false;
        user p = meseros;
        while(p!=null){
            if (p.nombre.equals(nombre)) {
                sw=true;
                
            }
            p=p.link;
        
        }
        
        return sw;
        }
         public static user retornarcamaero(String nombre){
        boolean sw=false;
        user p = meseros;
        while(p.link!=null&& !p.nombre.equals(nombre)){
            if (p.nombre.equals(nombre)) {
                sw=true;
                
            }
            p=p.link;
        
        }
        
        return p;
        }
          public static mesa retornarmesa(int num){
        boolean sw=false;
        mesa p = mesas;
        while(p.link!=null&& p.num!=num){
            
            p=p.link;
        
        }
        
        return p;
        }
     public static void leeru( File a){
   
     try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
                int cont=0;
                while(lector.hasNextLine()){
                   user p= new user(); 
                    // Pedir la linea 
                    String linea = lector.nextLine();
                    if (!linea.equals("")) {
                       cont++;  
                       String[]datos=linea.split(";");
                  
                           if (meseros==null) {
                            meseros=new user();
                            meseros.nombre=datos[0];
                            meseros.link=null;
                            meseros.nummesas=Integer.parseInt(datos[1]);
                        }else{
                            user aux= new user();
                            aux=meseros;
                        while(aux.link!=null){
                        
                        aux=aux.link;
                        
                        }
                        p.nombre =datos[0];
                        p.nummesas=Integer.parseInt(datos[1]);
                        p.link=null;
                        aux.link=p;
                        
                        }  
                        
                       
                    }

              
                   
                } 
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
     
     
    
     }
     public static void generarmesas(){
         
         int m=0;
         while(m<21){mesa p = new mesa();
          if (mesas==null) {m++;
                            mesas=new mesa();
                            mesas.num=m;
                            mesas.link=null;
                            
                        }else{
                            mesa aux= new mesa();
                            aux=mesas;
                        while(aux.link!=null){
                        
                        aux=aux.link;
                        
                        }
                        m++;
                        p.num=m;
                        
                        p.link=null;
                        aux.link=p;
                        
                        }  
         
         }
                 
       
     
     
     
     }
      public static int registros(File a ){
      int num=0;
      
       try(Scanner lector = new Scanner(a)){
                // Mientras el archivo tenga otra línea.
               
                int cont=0;
                while(lector.hasNextLine()){
                    if ( !lector.nextLine().equals("")) {
                           num++;
                    }
   
                 
                   
                  
                }
                
            } catch (FileNotFoundException ex) {
               System.out.println("");
            }
      
      return num;
      }
      static public void sololetras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
      static public void solonumeros(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();

                }
            }
        });
    }
      
      public static int indicep(int mesa){
      int indice=-1;
     
          for (int i = 0; i < ord.size(); i++) {
              if (ord.get(i).getMesa()==mesa && ord.get(i).getEstado().equals("Pendiente")) {
                  indice=i;
              }
              if (ord.get(i).getMesa()==mesa && ord.get(i).getEstado().equals("Cocinando")) {
                  indice=i;
              }
 
          }
          
      
      return indice;
      }
      public static int indicocinando(int mesa){
      int indice=-1;
     
          for (int i = 0; i < ord.size(); i++) {
              if (ord.get(i).getMesa()==mesa && ord.get(i).getEstado().equals("Cocinando")) {
                  indice=i;
              }
 
          }
          
      
      return indice;
      }
      
      public static int indiceingrediente(String ingrediente){
      int indice=-1;
     
          for (int i = 0; i < ingre.size(); i++) {
              if (ingre.get(i).getNombre().equals(ingrediente)) {
                  indice=i;
              }
 
          }
          
      
      return indice;
      }
      public static int indicecamareromesa(int mesa,user p){
      int indice=-1;
      
      for (int i = 0; i < p.ordenes.size(); i++) {
              if ( p.ordenes.get(i).getMesa()==mesa) {
                  indice=i;
              }
 
          }
     
         
          
      
      return indice;
      }
      
      
      
}
 

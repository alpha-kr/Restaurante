package restaurante;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ivan
 */
public class ManejadorRestaurante {
    
    
    
    public static void main(String args[]) throws IOException {
    comida Comida = new comida(0,"",0.0); 
    Mesero  A = new Mesero();    
    //Ahora a hacer los meseros 
          for (int i = 0; i < 4; i++) {
             A.setNumeroMesero(i);
             mesa aux = new mesa();
             //se le asignan 5 mesas por mesero 
              for (int j = 0; j  < 5; j++) {
              aux = aux.getSgte();
              aux.setSgte(new mesa());
              }
              A.setQuemasAplauda(aux);
              A.setSgtMesero(new Mesero());
              A = A.getSgtMesero();              
          
          }
    
       
    //"this.getClass().getResourse("/Comida.txt")"
    //("/Comida.txt")
    FileReader Fr = new FileReader("file.txt");
    BufferedReader Bf = new BufferedReader(Fr);
    String Linea; 
    String[] P; 
    comida Aux  = Comida; 
    while(null != (Linea=Bf.readLine())){
        Comida.setSgte(new comida());
        Comida = Comida.getSgte();
        P = Linea.split(";");
        Comida.setID(Integer.valueOf(P[0]));
        Comida.setName(P[1]);
        Comida.setPrecio(Double.valueOf(P[2]));
    }
    
    Fr.close();
    Bf.close();
     
    for(int i = 0; i<=6; i++){
        System.out.println(Aux.getName());
        Aux = Aux.getSgte();
              }
    
    
}
}

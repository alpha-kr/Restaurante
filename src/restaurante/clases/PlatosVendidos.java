/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.clases;

import java.util.ArrayList;
import java.util.List;
import utilidades.FileToList;
import utilidades.Leer;

/**
 *
 * @author ivan
 */
public class PlatosVendidos {

    public static void sold() {
        List<String> vendidos = new ArrayList<>();        
        FileToList.toList(vendidos, "Platos Elaborados");
        
        
        
        /*
        System.out.println(gastados);
        List<String> Busca = new ArrayList<>();
        FileToList.toList(Busca, "ingredientes-menu");
        List<String> ingredientes = new ArrayList<>();
        System.out.println(Busca.size());
        for (int i = 1; i < Busca.size(); i++) {
            String plat = Busca.get(i).split(";")[0];
            System.out.println(plat);
            int u = 0;
            while (plat.equals("Cocacola")){
                ingredientes.add(Busca.get(u).split(";")[1] +";"+Busca.get(u).split(";")[2]);                
                System.out.println(ingredientes.get(u));
                u++;
            }
        }*/
        
        

    }
}

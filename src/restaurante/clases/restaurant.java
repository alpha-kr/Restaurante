package restaurante.clases;

import java.util.ArrayList;

public class restaurant {
    private ArrayList <camarero> camareros= new ArrayList<camarero>();

    public ArrayList<camarero> getCamareros() {
        return camareros;
    }

    public void setCamareros(ArrayList<camarero> camareros) {
        this.camareros = camareros;
    }

    private String nombre;

    private String dirreccion;

    private int nit;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
    
}

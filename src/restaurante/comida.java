/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author Iván
 */
public class comida {
    int ID;
    String name;
    Double precio;
    comida sgte = null;

    public comida() {
    }

    public comida(int ID, String name, Double precio) {
        this.ID = ID;
        this.name = name;
        this.precio = precio;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public comida getSgte() {
        return sgte;
    }

    public void setSgte(comida sgte) {
        this.sgte = sgte;
    }
    
    
}

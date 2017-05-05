/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author Nicolas
 */
public class mesa {
    
    pedidos pedido;
    int numMesas;

    public mesa() {
    }
    mesa sgte = null;
    boolean IsUsed = false; 

    public mesa getSgte() {
        return sgte;
    }

    public void setSgte(mesa sgte) {
        this.sgte = sgte;
    }

    public boolean isIsUsed() {
        return IsUsed;
    }

    public void setIsUsed(boolean IsUsed) {
        this.IsUsed = IsUsed;
    }
    

    public mesa(pedidos pedido, int numMesas) {
        this.pedido = pedido;
        this.numMesas = numMesas;
    }

   
    public pedidos getPedido() {
        return pedido;
    }

    public void setPedido(pedidos pedido) {
        this.pedido = pedido;
    }

    public int getNumMesas() {
        return numMesas;
    }

    public void setNumMesas(int numMesas) {
        this.numMesas = numMesas;
    }
    
}

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
public class pedidos {
    comida comida;
    Double total;

    public pedidos(comida comida) {
        this.comida = comida;
    }

    public comida getComida() {
        return comida;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    

    public void setComida(comida comida) {
        this.comida = comida;
    }
    
    
    
}

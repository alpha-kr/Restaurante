package restaurante.clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;

public class orden {

    private int mesa;
    private String estado;
 
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
private ArrayList<pedido> pedidos = new ArrayList<pedido>();

    public ArrayList<pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<pedido> pedidos) {
        this.pedidos = pedidos;
    }
    private String cliente;

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;


public class Mesero {

int NumeroMesero; 
mesa quemasAplauda; 
Mesero SgtMesero; 
Double PropinaTotal = 0.0; 

    public Double getPropinaTotal() {
        return PropinaTotal;
    }

    public void setPropinaTotal(Double PropinaTotal) {
        this.PropinaTotal = PropinaTotal;
    }

    public Mesero(int NumeroMesero, mesa quemasAplauda, Mesero SgtMesero) {
        this.NumeroMesero = NumeroMesero;
        this.quemasAplauda = quemasAplauda;
        this.SgtMesero = SgtMesero;
    }

    public Mesero() {
    }

    public int getNumeroMesero() {
        return NumeroMesero;
    }

    public void setNumeroMesero(int NumeroMesero) {
        this.NumeroMesero = NumeroMesero;
    }

    public mesa getQuemasAplauda() {
        return quemasAplauda;
    }

    public void setQuemasAplauda(mesa quemasAplauda) {
        this.quemasAplauda = quemasAplauda;
    }

    public Mesero getSgtMesero() {
        return SgtMesero;
    }

    public void setSgtMesero(Mesero SgtMesero) {
        this.SgtMesero = SgtMesero;
    }

    
}


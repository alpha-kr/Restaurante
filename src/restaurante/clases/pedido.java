package restaurante.clases;

import formularios.funciones;
import static formularios.funciones.ingredientesplato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

public class pedido {

    private String nombre;
    File ingredientes = new File("ingredeintes.txt");
    File im = new File("ingredientes-menu.txt");
    private Double precio;
   
    private int hour ;

    public int getHour() {
        return hour;
    }
    private int minutos  ;

    public int getMinutos() {
        return minutos;
    }
    private String tipo;
    private String listo;
    private int id;

    public int getId() {
        return id;
    }
    private Timer t;
    private int tiempo;

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public pedido() {
         Calendar hora = new GregorianCalendar();
        hour=hora.get(Calendar.HOUR);
                minutos=hora.get(Calendar.MINUTE);
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 
                tiempo = tiempo - 1;
                System.out.println("funciona");
                if (tiempo == 0) {
                    listo = "Listo";
                    actulizaringre();
                    System.out.println("Plato hecho");
                    t.stop();
                }

            }
        };

        t = new Timer(6000, a);

    }

    public void iniciar() {
        t.start();
    }

    public void actulizaringre() {
        boolean sw = false;
        ArrayList<restaurante.clases.ingrediente> ing = ingredientesplato(nombre, im);
        int cont = 0;
        for (int i = 0; i < ing.size(); i++) {
            int pos = 0;
            for (int j = 0; j < funciones.ingre.size(); j++) {
                if (ing.get(i).getNombre().equals(funciones.ingre.get(j).getNombre())) {
                    pos = j;
                }

            }

            if (funciones.ingre.get(pos).getCantidad() - ing.get(i).getCantidad() > 0) {
                int nuevac = funciones.ingre.get(pos).getCantidad() - ing.get(i).getCantidad();
                funciones.ingre.get(pos).setCantidad(nuevac);
            }

        }
        if (cont == ing.size()) {
            sw = true;
        }

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListo() {
        return listo;
    }

    public void setListo(String listo) {
        this.listo = listo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

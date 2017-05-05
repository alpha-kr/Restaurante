/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import restaurante.clases.PlatosElaborados;
import utilidades.Clonar;
import utilidades.EscribirFact1;
import utilidades.EscribirFact2;
import utilidades.EscribirGeneradas;
import utilidades.EscribirPedidos;
import utilidades.Leer;
import utilidades.LeerGeneradas;
import utilidades.Limpiador;

/**
 *
 * @author ivan
 */
public class Factura extends javax.swing.JFrame {
    
    double totalProducto = 0.0;
    double totalNeto = 0.0;
    double total = 0.0;
    List<String> Plato = new ArrayList<>();
    List<String> Precio = new ArrayList<>();
    List<String> Order0 = new ArrayList<>();
    List<String> Order1 = new ArrayList<>();
    List<String> Order2 = new ArrayList<>();
    int Bill = 0;
    int orderSize;
    int nmesa;
    ArrayList<restaurante.clases.pedido> plat = new ArrayList<restaurante.clases.pedido>();
 

    /**
     * Creates new form factura
     */
    Menu men;
    funciones.user mesero;
    public Factura(int mesa, String cliente, ArrayList<restaurante.clases.pedido> platos,funciones.user u,Menu a) {
        initComponents();
        nmesa = mesa;
        mesero=u;
        men=a;
        plat = platos;
        clientetext.setText(cliente);
        mesatext.setText("" + mesa);
        
        for (int i = 0; i < platos.size(); i++) {
            model.addRow(new Object[]{"" + platos.get(i).getNombre(), platos.get(i).getPrecio() + "", "" + platos.get(i).getListo(), platos.get(i).getTiempo() + "Minutos"});
        }
        tabla.setModel(model);
        tabla.setDefaultRenderer(Object.class, new color());
        Plato.clear();
        Precio.clear();
        Order0.clear();
        Order1.clear();
        Order2.clear();
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new Object[]{"Plato", "Precio", "Estado", "Tiempo de espera"});
    
    public void platvend() {
        Limpiador.limpiar();
        for (int i = 0; i < orderSize; i++) {
            int x = Integer.parseInt(Order1.get(i));
            PlatosElaborados.elaborados(x, Order0.get(i));
        }
    }
    
    public void generar() {
        String n = clientetext.getText();
        facturaOrder();
        platvend();
        bills();
        int cuantos = 0;
        int tam = 0;
        EscribirFact1.escribir(n, nmesa, Bill);
        while (cuantos < orderSize && !Order0.get(cuantos).equals("")) {
            cuantos++;
            System.out.println("FUNCIONA");
        }
        for (int x = 0; x < cuantos; x++) {
            calculo(Order1.get(x), Order2.get(x));
            double precio = Double.parseDouble(Order2.get(x));
            tam = Integer.parseInt(Order1.get(x));
            EscribirPedidos.escribir(tam, Order0.get(x), Order2.get(x), n, tam * precio);
        }
        int iva = (int) (totalNeto * 0.19);
        int propina = (int) (totalNeto * 0.1);
        int tot = (int) total;
        EscribirFact2.escribir(n, tot, iva, propina, totalNeto);
        Leer.leer("factura", n);
    }
    
    public void facturaOrder() {
        int w = tabla.getRowCount();
        boolean[] rev = new boolean[w];
        for (int i = 0; i < w; i++) {
            Plato.add((String) tabla.getValueAt(i, 0));
            Precio.add((String) tabla.getValueAt(i, 1));
        }
        int Counter = 0;
        int ca = 0;
        for (int u = 0; u < tabla.getRowCount(); u++) {
            if (!rev[u]) {
                String Busca = Plato.get(u);
                String Costo = Precio.get(u);
                for (int t = 0; t < tabla.getRowCount(); t++) {
                    if (Busca.equals(Plato.get(t)) && !rev[t]) {
                        Counter = Counter + 1;
                        rev[t] = true;
                    }
                }
                String Search = Busca.replace("[", "").replace("]", "");
                String Cost = Costo.replace("[", "").replace("]", "");
                Order0.add(Search);
                Order1.add(String.valueOf(Counter));
                Order2.add(Cost);
                ca++;
                Counter = 0;
            }
        }
        orderSize = ca;
    }
    
    public void calculo(String cant, String valUni) {
        
        double vuni = Double.parseDouble(valUni);
        double quant = Double.parseDouble(cant);
        totalProducto = quant * vuni;
        totalNeto = totalNeto + totalProducto;
        total = totalNeto + (totalNeto * 0.1) + (totalNeto * 0.19);
    }
    
    public void bills() {
        Bill = LeerGeneradas.Generadas(0);
        Bill = Bill + 1;
        EscribirGeneradas.write(Bill);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        clientetext = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mesatext = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        clientetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientetextActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Generar Factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("mesa");

        mesatext.setEnabled(false);
        mesatext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesatextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(clientetext, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(mesatext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jButton1)))
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clientetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mesatext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientetextActionPerformed

    private void mesatextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesatextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesatextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generar();
        total = 0.0;
      funciones.mesa mes= funciones.retornarmesa(Integer.parseInt(mesatext.getText()));
      
        for (int i = 0; i < plat.size(); i++) {
             mes.ordenes.add(plat.get(i));
        }
     
        totalProducto = 0.0;
        totalNeto = 0.0;
        orderSize = 0;
        nmesa = 0;
        /*facturaOrder();
        for (int i = 0; i < Order.length-1; i++) {
            System.out.println(Order[i][1]);
        }*/
        
      /*  funciones.sobreescribir(ingredientes);
        for (int i = 0; i < funciones.ingre.size(); i++) {
            funciones.escribir(ingredientes, funciones.ingre.get(i).getId() + ";" + funciones.ingre.get(i).getNombre() + ";" + funciones.ingre.get(i).getCantidad() + ";" + funciones.ingre.get(i).getPrecio());
        }  
        */
        List<String> temp = new ArrayList<>();
         for (int k = 0; k < funciones.vendidos.size(); k++) {
                String all[] = funciones.vendidos.get(k).split(";");
                temp.add(all[1]);
            }
        
        for (int i = 0; i < funciones.vendidos.size(); i++) {
            String nombre = funciones.vendidos.get(i);
           String dat[] = nombre.split(";");
            nombre = dat[1];
            int realcantidad = Integer.parseInt(dat[0]);
            int con = 0;
            
            for (int j = 0; j < plat.size(); j++) {
                if (temp.contains(plat.get(j).getNombre())) {
                    if (plat.get(j).getNombre().equals(nombre)) {
                        con++;
                        funciones.vendidos.set(i, realcantidad + con + ";" + nombre);
                    }
                    
                } else {
                    temp.add(plat.get(j).getNombre());
                    funciones.vendidos.add("1;" + plat.get(i).getNombre());
                }
                
            }            
            
        } 
        int i =funciones.indicocinando(Integer.parseInt(mesatext.getText() ));
        funciones.ord.get(i).setEstado("Listo");
      int index=funciones.indicecamareromesa(Integer.parseInt(mesatext.getText()), mesero);
      mesero.ordenes.get(index).setEstado("Listo");
      men.actualizar(mesero);
        model.setRowCount(0);
this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Factura(0, null, null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clientetext;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mesatext;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

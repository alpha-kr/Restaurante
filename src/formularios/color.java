/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ANDY
 */
public  class color extends DefaultTableCellRenderer {
    int blan=0;
    @Override
    
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        super.getTableCellRendererComponent(table, value,isSelected,hasFocus,row,column);
       this.setHorizontalAlignment(0);
        if (value instanceof String) {
            String valor = (String)value;
            if (column==0) {
                if (table.getValueAt(row,column+1 ).toString().equals("Pendiente") ) {
              
                 setForeground(Color.RED);
            }
                 else{
                if (table.getValueAt(row,column+1 ).toString().equals("Cocinando")) {
              
                  setForeground(Color.orange
                );
            }
                else{
                
               setForeground(Color.GREEN
                );
                
                }
            }
            }else{
                if (table.getValueAt(row,column ).toString().equals("Pendiente") ) {
              
                 setForeground(Color.RED);
            }
                 else{
                if (table.getValueAt(row,column ).toString().equals("Cocinando")) {
              
                  setForeground(Color.orange
                );
            }
                else{
                
               setForeground(Color.GREEN
                );
                
                }
            }
            
            }
           
            
        }
        return this;
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ANDY
 */
public  class Render extends DefaultTableCellRenderer {
    int blan=0;
    @Override
    
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value,isSelected,hasFocus,row,column);
        cell.setHorizontalAlignment(0);
        if (value instanceof JButton ) {
            JButton btn= (JButton)value;
            return btn;
        }
       
        cell.setBackground( new java.awt.Color(51,23,16));
        return super.getTableCellRendererComponent(table, value,isSelected,hasFocus,row,column);
    } 
}

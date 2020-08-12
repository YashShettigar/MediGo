/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Yash
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
 
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;
 
/**
 * A simple renderer class for JTable component.
 * @author www.codejava.net
 *
 */
public class TableHeaderFont extends JTextArea implements TableCellRenderer {
 
    public TableHeaderFont() {
        setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        setOpaque(true);
        setBackground(Color.decode("#F81E9A"));
        setPreferredSize(new Dimension(300, 50));
        setWrapStyleWord(true);
        setLineWrap(true);
    }
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
 
}

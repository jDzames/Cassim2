
package Cassim2;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class HeaderRenderer implements TableCellRenderer {

    DefaultTableCellRenderer renderer;
    
    public HeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer)
            table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        
    }

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int col) {
        Component c = renderer.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, col);
        c.setFont(new Font("Times New Roman", Font.BOLD, 16));
        return c;
    }
}

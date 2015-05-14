
package sk.upjs.ics.s.jdzama.Cassim2.GUI.renderers;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class BasisRenderer implements TableCellRenderer {

    DefaultTableCellRenderer renderer;
    
    public BasisRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer) table.getDefaultRenderer(JLabel.class);
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = renderer.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);
        //c.setFont(new Font("Times New Roman", Font.BOLD, 16));
        return c;
    }
    
}

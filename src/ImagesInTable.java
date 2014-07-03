import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class ImagesInTable {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new BorderLayout());

    MyTableModel model = new MyTableModel();

    JTable table = new JTable(model);
    table.setRowHeight(80);
    table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
    table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
    JScrollPane pane = new JScrollPane(table);
    frame.getContentPane().add(BorderLayout.CENTER, pane);
    frame.setSize(500, 400);
    frame.setVisible(true);
  }
}

class MyTableModel extends AbstractTableModel {
  public Object getValueAt(int row, int column) {
    return "" + (row * column);
  }

  public int getColumnCount() {
    return 4;
  }

  public int getRowCount() {
    return 5;
  }
}

class ImageRenderer extends DefaultTableCellRenderer {
  JLabel lbl = new JLabel();

  ImageIcon icon1 = new ImageIcon("nieco.jpg");
  ImageIcon icon2 = new ImageIcon("Bart.jpg");

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    lbl.setText((String) value);
      if (column==1) {
          if (row==1) {
              lbl.setIcon(icon1);
          } else {
              lbl.setIcon(icon2);
          }
          
      } else {
          lbl.setIcon(icon2);
      }
    
    return lbl;
  }
}

   
package Cassim2;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;


public class ImageTableModel extends AbstractTableModel {
  
  /*private int minHeight = -1;  */
  private String[] columnNames = ValuesSingleton.INSTANCE.getColumnNames();
  private Object[][] data = ValuesSingleton.INSTANCE.getData();  
    
    
  public Object getValueAt(int row, int column) {             
    return new JLabel();     
  }

  public int getColumnCount() {
    return columnNames.length;
  }

  public int getRowCount() {
    return ValuesSingleton.INSTANCE.rows+1;
  }
  
  public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
  
  public boolean isCellEditable(int row, int col) {       
        return false;       
    }

}

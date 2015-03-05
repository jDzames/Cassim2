
package Cassim2;

import javax.swing.JLabel;


class RevidedImageTableModel extends ImageTableModel {

    public Object getValueAt(int row, int column) {             
    return new JLabel();     
  }

  public int getColumnCount() {
    return ValuesSingleton.INSTANCE.rows+1;
  }

  public int getRowCount() {
    return ValuesSingleton.INSTANCE.rows+1;
  }
  
  public String getColumnName(int col) {
      if (col==0) {
          return ValuesSingleton.INSTANCE.columnNames[0];
      } else if (col==ValuesSingleton.INSTANCE.rows) {
          return ValuesSingleton.INSTANCE.columnNames[ValuesSingleton.INSTANCE.revidedShownIdx];
      } else {
          return ValuesSingleton.INSTANCE.columnNames[ValuesSingleton.INSTANCE.basisDataIdx[col]];
      }
      
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
  
  public boolean isCellEditable(int row, int col) {       
        return false;       
    }
 
}

package Cassim2;

import javax.swing.JLabel;


public class RevidedImageTableModel extends ImageTableModel {

    public Object getValueAt(int row, int column) {             
        return new JLabel();     
    }

    public int getColumnCount() {
        return ValuesSingleton.INSTANCE.rows+2;
    }

    public int getRowCount() {
        return ValuesSingleton.INSTANCE.rows+1;
    }
  
    public String getColumnName(int col) {
      if (col==0) {
          return ValuesSingleton.INSTANCE.columnNames[0];
      } else if (col==ValuesSingleton.INSTANCE.rows+1) {
          if (ValuesSingleton.INSTANCE.revidedShownIdx<=0) {
              return "";
          } else {
              return ValuesSingleton.INSTANCE.columnNames[ValuesSingleton.INSTANCE.revidedShownIdx];
          }
      } else {
          if (ValuesSingleton.INSTANCE.basisDataIdx[col-1]<0) {
              return "";
          } else {
              return ValuesSingleton.INSTANCE.columnNames[ValuesSingleton.INSTANCE.basisDataIdx[col-1]];
          }
      }
      
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
  
    public boolean isCellEditable(int row, int col) {       
        return false;       
    }
 
}

package Cassim2;

import javax.swing.table.AbstractTableModel;


public class BasisTableModel extends AbstractTableModel{

    
    
    @Override
    public int getRowCount() {
        return ValuesSingleton.INSTANCE.rows;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int idx = ValuesSingleton.INSTANCE.basisDataIdx[rowIndex];
        if (idx<0) {
            return "";
        }
        return ValuesSingleton.INSTANCE.columnNames[idx];
    }
    
    public boolean isCellEditable(int row, int col){        
        return false;
    }
    
    public String getColumnName(int col) {
        return "V báze:";
    }

    public Class getColumnClass(int c) {
        return String.class;
    }   
    
}

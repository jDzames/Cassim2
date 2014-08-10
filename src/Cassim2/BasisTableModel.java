package Cassim2;

import javax.swing.table.AbstractTableModel;


public class BasisTableModel extends AbstractTableModel{

    //private Object[] basisData = ValuesSingleton.INSTANCE.basisData;
    
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
        return ValuesSingleton.INSTANCE.basisData[rowIndex];
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

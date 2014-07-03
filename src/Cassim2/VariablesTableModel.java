package Cassim2;

import javax.swing.table.AbstractTableModel;


public class VariablesTableModel extends AbstractTableModel {

    private String[] columnNames = ValuesSingleton.INSTANCE.columnNames;
    
    public int getRowCount() {
        return 1;
    }

    
    public int getColumnCount() {
        return columnNames.length+1;
    }

    public String getColumnName(int col) {
        if (col==columnNames.length-1) {
            return " ";
        }
        if (col==columnNames.length) {
            return "x0";
        }
        return columnNames[col+1];
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==columnNames.length-1) {
                return " --> ";
            }
        if (columnIndex==columnNames.length) {
            return columnNames[0];
        }
        return columnNames[columnIndex+1];
    }
    
    public boolean isCellEditable(int row, int col) { 
        if (col==columnNames.length-1) {
            return false;
        }        
        return true;             
    }
    
    public void setValueAt(Object value, int row, int col) {
        if (((String)value).length()<1 || ((String)value).length()>7) {
            fireTableCellUpdated(row, col);
            return;
        }
        if (col==columnNames.length) {
            columnNames[0] = (String)value;
            fireTableCellUpdated(row, col);
            return;
        }
        columnNames[col+1]=(String)value;
        fireTableCellUpdated(row, col);           
    }
    
}

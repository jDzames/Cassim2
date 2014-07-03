/*

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;


public class NezapornostTableModel extends AbstractTableModel{
    
    
    private String[] columnNames = ValuesSingleton.INSTANCE.columnNames;
    private Object[] nezapornost = ValuesSingleton.INSTANCE.nezapornost;

    public int getColumnCount() {
        return columnNames.length-1;
    }

    public int getRowCount() {
        return 1;
    }

    public String getColumnName(int col) {
        return columnNames[col+1];
    }

    public Object getValueAt(int row, int col) { 
        return nezapornost[col];              
    }

    public Class getColumnClass(int c) {
        return JComboBox.class;//getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {              
        return true;              
    }

    public void setValueAt(Object value, int row, int col) {       
        nezapornost[col] = value; 
        System.out.println(value +"  "+ nezapornost[col]);       
        fireTableCellUpdated(row, col);
    }
    
    
}
*/
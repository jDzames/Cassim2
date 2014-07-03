

/*
import javax.swing.table.AbstractTableModel;

public class UcelovaFunkciaTableModel extends AbstractTableModel{

    
    private String[] columnNames = ValuesSingleton.INSTANCE.columnNames;
    private Object[][] data = ValuesSingleton.INSTANCE.data;

    public int getColumnCount() {
        return columnNames.length+1;
    }

    public int getRowCount() {
        return 1;
    }

    public String getColumnName(int col) {
        if (col==columnNames.length-1) {
            return " --> ";
        } 
        if (col==columnNames.length) {
            return "x0";
        }
        return columnNames[col+1];
    }

    public Object getValueAt(int row, int col) {  
        if (col==columnNames.length-1) {
            return " --> ";
        } else {
            if (col==columnNames.length) {
                if (((String)data[0][0]).length()<3) {
                    data[0][0]=" max ";
                }
                return data[0][0];
            }           
            return data[0][col+1]; 
        }            
    }

    public Class getColumnClass(int c) {
        return String.class; //getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {       
        if (col==columnNames.length-1) {
            return false;
        } else {
            return true; 
        }       
    }

    public void setValueAt(Object value, int row, int col) {
        if (col==columnNames.length-1) {
             data[0][col] = " --> ";
        } else {
            if (col==columnNames.length) {
                data[0][0] = value;
                fireTableCellUpdated(row, col);
                return;
            }
            data[0][col+1] = value;
        }       
        fireTableCellUpdated(row, col);
    }
    
    
}
*/
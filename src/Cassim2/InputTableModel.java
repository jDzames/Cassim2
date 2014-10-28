
package Cassim2;

import javax.swing.table.AbstractTableModel;


public class InputTableModel extends AbstractTableModel {
    
    private String[] columnNames = ValuesSingleton.INSTANCE.columnNames;
    private Object[][] data = ValuesSingleton.INSTANCE.data;
    private Object[] porovnania = ValuesSingleton.INSTANCE.porovnaniasPS;
    private Object[] nezapornost = ValuesSingleton.INSTANCE.nezapornost;


    public int getColumnCount() {
        return columnNames.length+1;
    }

    public int getRowCount() {
        return data.length+1;
    }

    public String getColumnName(int col) {
        if (col==columnNames.length-1) {
            return " ";
        }
        if (col==columnNames.length) {
            return columnNames[0];
        }
        return columnNames[col+1];
    }

    public Object getValueAt(int row, int col) {
        if (row==0) {
            if (col==columnNames.length-1) {
                return " --> ";
            }
            if (col==columnNames.length) {
                if (((String)data[0][0]).length()<3) {
                    data[0][0]=" max ";
                }
                return data[0][0];
            }
            return data[row][col+1];
        }
        
        if (row==data.length) {
            if (col>=columnNames.length-1) {
                return "";
            }
            if (((String)nezapornost[col]).length()<2) {
                    nezapornost[col]=" >= ";
                }
            return nezapornost[col];
        }
        
        if (col==columnNames.length-1) {
            return porovnania[row-1];
        }
        if (col==columnNames.length) {
            return data[row][0];
        }
        return data[row][col+1];             
    }

    public Class getColumnClass(int c) {
        return String.class; //getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) { 
        if (row==0 && col==columnNames.length-1) {
            return false;
        }
        if (row==data.length && col>=columnNames.length-1) {
            return false;
        }
 
       return true;             
    }

    public void setValueAt(Object value, int row, int col) {
        String input = (String)(value);
        if (input==null || input.length()==0) {
            fireTableCellUpdated(row, col);
            return;
        }
        //ak je prva nula vo vstupe ta ju vyhodim
        if (input.length()>1 && input.charAt(0)=='0' && !( input.charAt(1)==',' || input.charAt(1)=='.' )) {
            value = input.substring(1);
            input = input.substring(1);
        }
        //nastavim z comboboxov
        if (col==columnNames.length-1 && row!=0) {
            porovnania[row-1] = value;
            fireTableCellUpdated(row, col);
            return;
        }
        if (row==data.length) {          
            nezapornost[col]=value;
            fireTableCellUpdated(row, col);
            return;
        }
        if (row==0 && col==columnNames.length) {          
            data[0][0]=value;
            fireTableCellUpdated(row, col);
            return;
        }
        
        //skontrolujem pisany vstup: ., des cislo a :/\=(char)92 zlomok
        input.trim();
        if (!(input.charAt(0)>='0' && input.charAt(0)<='9')) {
            String smaller = input.substring(1);           
            if (smaller==null || smaller.length()<1 || input.charAt(0)!='-' || !(smaller.trim().charAt(0)>='0' && smaller.trim().charAt(0)<='9')) {
                fireTableCellUpdated(row, col);
                return;  
            }           
        }
        if (!(input.charAt(input.length()-1)>='0' && input.charAt(input.length()-1)<='9')) {
            fireTableCellUpdated(row, col);
            return;
        }
        int fractionSigns=0;
        int decimalSigns=0;
        boolean validMinusSign=true;
        boolean valid = false;  
        int denominatorIndex=-1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='-') {
                if (validMinusSign) {
                    validMinusSign=false;
                    valid=true;
                    continue;
                }                
                valid=false;
                break;
            }
            if (input.charAt(i)==' ') {
                valid = true;
                continue;
            }
            if (input.charAt(i)>='0' && input.charAt(i)<='9') {
                valid=true;
                validMinusSign = false;
                continue;
            }
            if (input.charAt(i)==':' || input.charAt(i)=='/' || input.charAt(i)==(char)92) {
                denominatorIndex=i+1;
                fractionSigns++;
                valid=true;
                validMinusSign = true;
                continue;
            }
            if (input.charAt(i)==',' || input.charAt(i)=='.') {
                decimalSigns++;
                validMinusSign = false;
                valid=true;
                continue;
            }
            valid=false;
            break;
        }
        if (!valid || decimalSigns+fractionSigns>1 ) { 
            fireTableCellUpdated(row, col);
            return;
        }
        //ci menovatel nie je 0
        if (denominatorIndex!=-1) {
            try {
                int denominator = Integer.parseInt(input.substring(denominatorIndex).trim());
                if (denominator==0) {
                    fireTableCellUpdated(row, col);
                    return;
                }
            } catch (NumberFormatException e) {
                fireTableCellUpdated(row, col);
                return;
            }          
        }
        //vlozim na spravne miesto
        if (col==columnNames.length) {
            data[row][0] = value;
            fireTableCellUpdated(row, col);
            return;
        }
        if (row==0) {
            data[row][col+1]=value;
            fireTableCellUpdated(row, col);
            return ;
        }               
        data[row][col+1] = value;
        fireTableCellUpdated(row, col);           
    }
    
}

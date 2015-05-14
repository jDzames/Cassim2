
package sk.upjs.ics.s.jdzama.Cassim2.GUI.tableModels;

import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import java.math.BigInteger;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.math3.fraction.BigFraction;


public class ChangeFunctionTableModel extends AbstractTableModel{
    
    public int getColumnCount() {
        return ValuesSingleton.INSTANCE.columns;
    }

    public int getRowCount() {
        return 2;
    }

    public String getDataAt(int row, int col) {
        if (row==0) {
            return ValuesSingleton.INSTANCE.changeFunctionRow0[col+1].getNumerator().toString();
        } else {
            return ValuesSingleton.INSTANCE.changeFunctionRow0[col+1].getDenominator().toString();
        } 
    }
    
    public String getColumnName(int col) {
        return ValuesSingleton.INSTANCE.columnNames[col+1];
    }

    public Object getValueAt(int row, int col) {
        if (row==0) {
            return ValuesSingleton.INSTANCE.changeFunctionRow0[col+1].getNumerator();
        } else {
            return ValuesSingleton.INSTANCE.changeFunctionRow0[col+1].getDenominator();
        }           
    }

    public Class getColumnClass(int c) {
        return String.class; //getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) { 
       return true;             
    }

    public void setValueAt(Object value, int row, int col) {
        BigInteger number = new BigInteger((String) value);
        if (row==0) {
            BigInteger denomin = ValuesSingleton.INSTANCE.changeFunctionRow0[col+1].getDenominator();
            ValuesSingleton.INSTANCE.changeFunctionRow0[col+1] = new BigFraction(number, denomin);
        } else {
            BigInteger numer = ValuesSingleton.INSTANCE.changeFunctionRow0[col+1].getNumerator();
            ValuesSingleton.INSTANCE.changeFunctionRow0[col+1] = new BigFraction(numer, number);
        } 
    }
}

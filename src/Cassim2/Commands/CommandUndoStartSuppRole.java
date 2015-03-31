
package Cassim2.Commands;

import Cassim2.ValuesSingleton;
import org.apache.commons.math3.fraction.BigFraction;

public class CommandUndoStartSuppRole implements Command{

    private BigFraction[] row0;
    private final byte type;

    public CommandUndoStartSuppRole(BigFraction[] row0) {
        this.row0 = row0;
        type = 3;
    }
    
    @Override
    public Command execute() {
        int columns = ValuesSingleton.INSTANCE.tableData[0].length - ValuesSingleton.INSTANCE.suppRoleVariables;
        ValuesSingleton.INSTANCE.showColumns = columns;
        ValuesSingleton.INSTANCE.columns = ValuesSingleton.INSTANCE.columns-ValuesSingleton.INSTANCE.suppRoleVariables;
        
        BigFraction[][] data = new BigFraction[ValuesSingleton.INSTANCE.tableData.length][columns];
        data[0] = row0;
        for (int i = 1; i < ValuesSingleton.INSTANCE.tableData.length; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = ValuesSingleton.INSTANCE.tableData[i][j];
            }
        }
        ValuesSingleton.INSTANCE.tableData = data;
        //ValuesSingleton.INSTANCE.basisDataIdx = new int[data.length-1];
        String[] colNames = new String[ValuesSingleton.INSTANCE.columnNames.length-ValuesSingleton.INSTANCE.suppRoleVariables];
        System.arraycopy(ValuesSingleton.INSTANCE.columnNames, 0, colNames, 0, colNames.length);
        ValuesSingleton.INSTANCE.columnNames = colNames;
        
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i] >= colNames.length) {
                ValuesSingleton.INSTANCE.basisDataIdx[i] = -1;
            }
        }
        
        ValuesSingleton.INSTANCE.suppRoleVariables = 0;
        ValuesSingleton.INSTANCE.suppRoleRunning = false;
        return new CommandStartSuppRole();
    }

    @Override
    public String toString() {
        return "Undo začni pomocnú úlohu";
    }
    
    @Override
    public int getType() {
        return type;
    }
}

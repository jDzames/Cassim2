
package Cassim2.Commands;

import Cassim2.ValuesSingleton;
import org.apache.commons.math3.fraction.BigFraction;

public class CommandUndoGomory implements Command{
    
    private int rowPosition;
    private final byte type;

    public CommandUndoGomory(int rowPosition) {
        this.rowPosition = rowPosition;
        type = 6;
    }

    @Override
    public Command execute() {
        BigFraction[][] newData = new BigFraction[ValuesSingleton.INSTANCE.tableData.length-1]
                [ValuesSingleton.INSTANCE.tableData[0].length-1];
        BigFraction[][] oldData = ValuesSingleton.INSTANCE.tableData; 
        
        int gomoryCol = ValuesSingleton.INSTANCE.columnNames.length-1-ValuesSingleton.INSTANCE.suppRoleVariables;
        for (int i = 0; i < oldData.length-1; i++) {
            int colIdx = 0;
            for (int j = 0; j < oldData[0].length; j++) {
                if (j != gomoryCol) {
                    newData[i][colIdx] = oldData[i][j];
                    colIdx++;
                }
            }
        }
        ValuesSingleton.INSTANCE.tableData = newData;
        ValuesSingleton.INSTANCE.rows--;
        ValuesSingleton.INSTANCE.columns--;
        ValuesSingleton.INSTANCE.showColumns--;
        ValuesSingleton.INSTANCE.gomoryVariables--;
        
        int[] basisData = new int[ValuesSingleton.INSTANCE.basisDataIdx.length-1];
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length-1; i++) {
            basisData[i] = ValuesSingleton.INSTANCE.basisDataIdx[i]; 
        }
        ValuesSingleton.INSTANCE.basisDataIdx = basisData;
        int gomColNext = gomoryCol+1;
        String[] colNames = new String[ValuesSingleton.INSTANCE.columnNames.length-1];
        System.arraycopy(ValuesSingleton.INSTANCE.columnNames, 0, colNames, 0, gomoryCol);
        for (int i = 0; i < ValuesSingleton.INSTANCE.suppRoleVariables; i++) {
            colNames[gomoryCol+i] = ValuesSingleton.INSTANCE.columnNames[gomColNext+i];
        }
        ValuesSingleton.INSTANCE.columnNames = colNames;
        
        return new CommandGomory(rowPosition);
    }

    @Override
    public String toString() {
        return "Undo gomoryho rez";
    }
    
    @Override
    public int getType() {
        return type;
    }
    
}

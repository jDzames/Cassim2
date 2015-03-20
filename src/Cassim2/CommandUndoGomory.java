
package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;

public class CommandUndoGomory implements Command{

    @Override
    public void execute() {
        BigFraction[][] newData = new BigFraction[ValuesSingleton.INSTANCE.tableData.length-1]
                [ValuesSingleton.INSTANCE.tableData[0].length-1];
        BigFraction[][] oldData = ValuesSingleton.INSTANCE.tableData; 
        
        int gomoryCol = ValuesSingleton.INSTANCE.showColumns-1;
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
        
        int[] basisData = new int[ValuesSingleton.INSTANCE.basisDataIdx.length-1];
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length-1; i++) {
            basisData[i] = ValuesSingleton.INSTANCE.basisDataIdx[i]; 
        }
        ValuesSingleton.INSTANCE.basisDataIdx = basisData;
    }

    @Override
    public String toString() {
        return "Undo gomoryho rez";
    }
    
    
}

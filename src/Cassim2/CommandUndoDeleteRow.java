
package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


public class CommandUndoDeleteRow implements Command{

    private final int rowPosition;
    private BigFraction[] rowDeleted;
    private int basisIdx;

    public CommandUndoDeleteRow(int rowPosition, BigFraction[] rowDeleted, int basisIdx) {
        this.rowPosition = rowPosition;
        this.rowDeleted = rowDeleted;
        this.basisIdx = basisIdx;
    }
    
    @Override
    public void execute() {
        BigFraction[][] data = new BigFraction[ValuesSingleton.INSTANCE.tableData.length+1]
                [ValuesSingleton.INSTANCE.tableData[0].length];
        int idx=0;
        for (int i = 0; i < ValuesSingleton.INSTANCE.tableData.length; i++) {
            if (i == rowPosition) {
                data[idx] = rowDeleted; 
                idx++;
            }
            data[idx] = ValuesSingleton.INSTANCE.tableData[i]; 
            idx++;
        }
        ValuesSingleton.INSTANCE.tableData = data;
        idx = 0;
        int[] basisData = new int[ValuesSingleton.INSTANCE.basisDataIdx.length+1];
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            if (i == rowPosition-1) {
                basisData[idx] = basisIdx; 
                idx++;
            }
            basisData[idx] = ValuesSingleton.INSTANCE.basisDataIdx[i]; 
            idx++;
        }
        ValuesSingleton.INSTANCE.basisDataIdx = basisData;
    }

    @Override
    public String toString() {
        return "Undo vymazanie riadku "+rowPosition;
    }
    
}

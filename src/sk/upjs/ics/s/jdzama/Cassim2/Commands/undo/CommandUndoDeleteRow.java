
package sk.upjs.ics.s.jdzama.Cassim2.Commands.undo;

import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import org.apache.commons.math3.fraction.BigFraction;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.redo.CommandDeleteRow;


public class CommandUndoDeleteRow implements Command{

    private final int rowPosition;
    private BigFraction[] rowDeleted;
    private int basisIdx;
    private final byte type;

    public CommandUndoDeleteRow(int rowPosition, BigFraction[] rowDeleted, int basisIdx) {
        this.rowPosition = rowPosition;
        this.rowDeleted = rowDeleted;
        this.basisIdx = basisIdx;
        type = 8;
    }
    
    @Override
    public Command execute() {
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
        ValuesSingleton.INSTANCE.rows++;
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
        return new CommandDeleteRow(rowPosition);
    }

    @Override
    public String toString() {
        return "Undo vymazanie riadku "+rowPosition;
    }

    @Override
    public int getType() {
        return type;
    }
    
}

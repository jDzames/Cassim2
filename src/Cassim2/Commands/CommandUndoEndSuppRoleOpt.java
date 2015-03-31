
package Cassim2.Commands;

import Cassim2.ValuesSingleton;
import java.util.ArrayList;
import org.apache.commons.math3.fraction.BigFraction;


public class CommandUndoEndSuppRoleOpt implements Command{

    private ArrayList<BigFraction[]> deletedRows;
    private ArrayList<Integer> deletedRowsIdxs;
    private ArrayList<Integer> deletedBasisIdxs;
    private final byte type;

    public CommandUndoEndSuppRoleOpt(ArrayList<BigFraction[]> deletedRows, ArrayList<Integer> deletedRowsIdxs, ArrayList<Integer> deletedBasisIdxs) {
        this.deletedRows = deletedRows;
        this.deletedRowsIdxs = deletedRowsIdxs;
        this.deletedBasisIdxs = deletedBasisIdxs;
        type = 7;
    }
    
    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.showColumns = ValuesSingleton.INSTANCE.columnNames.length;
        ValuesSingleton.INSTANCE.rows = ValuesSingleton.INSTANCE.rows+deletedRows.size();
        ValuesSingleton.INSTANCE.suppRoleRunning = true;
        
        BigFraction[][] newTable = new BigFraction[ValuesSingleton.INSTANCE.tableData.length+deletedRows.size()]
                [ValuesSingleton.INSTANCE.tableData[0].length];
        int[] newBasis = new int[ValuesSingleton.INSTANCE.basisDataIdx.length+deletedRows.size()];
        newTable[0] = ValuesSingleton.INSTANCE.row0saved; 
        int idx = 1;
        int idxInDel = 0;
        for (int i = 1; i < ValuesSingleton.INSTANCE.tableData.length; i++) {
            while (deletedRowsIdxs.get(idxInDel)==idx) {
                newTable[idx] = deletedRows.get(idxInDel);
                newBasis[idx-1] = deletedBasisIdxs.get(idxInDel);
                idxInDel++;
                idx++;
            }
            newBasis[idx-1] = ValuesSingleton.INSTANCE.basisDataIdx[i-1];
            newTable[idx] = ValuesSingleton.INSTANCE.tableData[i];
            idx++;
        }
        ValuesSingleton.INSTANCE.tableData = newTable;
        ValuesSingleton.INSTANCE.basisDataIdx = newBasis;
        return new CommandEndSuppRoleOpt();
    }

    @Override
    public String toString() {
        return "Undo ukonči pomocnú úlohu";
    }
    
    @Override
    public int getType() {
        return type;
    }
}

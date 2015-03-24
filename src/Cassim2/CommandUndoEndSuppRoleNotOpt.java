
package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


public class CommandUndoEndSuppRoleNotOpt implements Command{

    private BigFraction[] suppRowO;
    private int[] basisIdxs;
    private final byte type;
    
    public CommandUndoEndSuppRoleNotOpt(BigFraction[] suppRowO, int[] basisIdxs) {
        this.suppRowO = suppRowO;
        this.basisIdxs = basisIdxs;
        type = 5;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.showColumns = ValuesSingleton.INSTANCE.columnNames.length;
        ValuesSingleton.INSTANCE.tableData[0] = suppRowO; 
        ValuesSingleton.INSTANCE.basisDataIdx = basisIdxs;
        ValuesSingleton.INSTANCE.suppRoleRunning = true;
        return new CommandEndSuppRoleNotOpt();
    }

    @Override
    public String toString() {
        return "Undo ukončenie pomocnej úlohy mimo optima";
    }
    
    @Override
    public int getType() {
        return type;
    }
}

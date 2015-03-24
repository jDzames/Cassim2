
package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;

public class CommandUndoStartSuppRole implements Command{

    private BigFraction[] row0;

    public CommandUndoStartSuppRole(BigFraction[] row0) {
        this.row0 = row0;
    }
    
    @Override
    public Command execute() {
        int rows = ValuesSingleton.INSTANCE.tableData[0].length - ValuesSingleton.INSTANCE.suppRoleVariables;
        ValuesSingleton.INSTANCE.showColumns = rows;
        
        BigFraction[][] data = new BigFraction[ValuesSingleton.INSTANCE.tableData.length][rows];
        data[0] = row0;
        for (int i = 1; i < ValuesSingleton.INSTANCE.tableData.length; i++) {
            for (int j = 0; j < rows; j++) {
                data[i][j] = ValuesSingleton.INSTANCE.tableData[i][j];
            }
        }
        ValuesSingleton.INSTANCE.tableData = data;
        ValuesSingleton.INSTANCE.basisDataIdx = new int[data.length-1];
        new SolutionCalcService().findBasis();
        return new CommandStartSuppRole();
    }

    @Override
    public String toString() {
        return "Undo začni pomocnú úlohu";
    }
    
}


package Cassim2.Commands;

import Cassim2.SolutionCalcService;
import Cassim2.ValuesSingleton;


public class CommandDeleteRow implements Command{

    private int row;
    private final byte type;

    public CommandDeleteRow(int row) {
        this.row = row;
        type = 8;
    }
    
    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("8;"+row);
        SolutionCalcService solCalc = new SolutionCalcService();
        return solCalc.deleteRow(row);
    }

    @Override
    public String toString() {
        return "Vymaž riadok "+row;
    }

    @Override
    public int getType() {
        return this.type;
    }
    
}

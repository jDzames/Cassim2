
package Cassim2.Commands;

import Cassim2.SolutionCalcService;
import Cassim2.ValuesSingleton;

public class CommandPivot implements Command{
    
    private int positionRow;
    private int positionColumn;
    
    private final byte type;

    public CommandPivot(int positionRow, int positionColumn) {
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        type = 1;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("3;"+positionRow+";"+positionColumn);
        SolutionCalcService solCalc = new SolutionCalcService();
        return solCalc.pivot(positionRow, positionColumn);
    }

    @Override
    public String toString() {
        return "Pivot na ["+positionRow+","+positionColumn+"]"; 
    }

    @Override
    public int getType() {
        return type;
    }
  
}

package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.logic.SolutionCalcService;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;

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

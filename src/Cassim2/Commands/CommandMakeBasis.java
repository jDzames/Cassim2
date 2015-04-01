
package Cassim2.Commands;

import Cassim2.SolutionCalcService;
import Cassim2.ValuesSingleton;


public class CommandMakeBasis implements Command {

    private final byte type;
    
    public CommandMakeBasis() {
        type = 1;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("1");
        SolutionCalcService solCalc = new SolutionCalcService();
        return solCalc.makeZeroOverBasis();
    }

    @Override
    public String toString() {
        return "Bázuj";
    }

    @Override
    public int getType() {
        return type;
    }
    
}

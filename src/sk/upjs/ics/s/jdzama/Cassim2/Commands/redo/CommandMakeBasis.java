
package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.logic.SolutionCalcService;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


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

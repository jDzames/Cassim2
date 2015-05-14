
package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.logic.SolutionCalcService;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


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

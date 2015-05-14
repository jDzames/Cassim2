
package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.logic.SolutionCalcService;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import org.apache.commons.math3.fraction.BigFraction;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;


public class CommandMultiplyRow implements Command {

    private int row;
    private BigFraction multBy;
    private final byte type;
    
    public CommandMultiplyRow(int row, BigFraction multBy) {
        this.row = row;
        this.multBy = multBy;
        type = 1;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("7;"+row+";"+multBy.getNumerator()+";"+multBy.getDenominator());
        SolutionCalcService solCalc = new SolutionCalcService();
        return solCalc.multiplRow(row, multBy);
    }

    @Override
    public String toString() {
        return "Vynásob riadok "+row;
    }

    @Override
    public int getType() {
        return type;
    }
    
}

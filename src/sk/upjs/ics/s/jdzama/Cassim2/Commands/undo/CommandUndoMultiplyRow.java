
package sk.upjs.ics.s.jdzama.Cassim2.Commands.undo;

import sk.upjs.ics.s.jdzama.Cassim2.logic.SolutionCalcService;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import org.apache.commons.math3.fraction.BigFraction;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.redo.CommandMultiplyRow;


public class CommandUndoMultiplyRow implements Command{

    private final BigFraction multBy;
    private final int row;
    private int basisIdx;
    private final byte type;

    public CommandUndoMultiplyRow(BigFraction multBy, int row, int basisIdx) {
        this.multBy = multBy;
        this.row = row;
        this.basisIdx = basisIdx;
        type = 1;
    }
    
    @Override
    public Command execute() {
        SolutionCalcService solClculations = new SolutionCalcService();
        BigFraction fr = new BigFraction(multBy.getDenominator(), multBy.getNumerator());
        solClculations.multiplRow(row, multBy);
        ValuesSingleton.INSTANCE.basisDataIdx[row-1] = basisIdx;
        return new CommandMultiplyRow(row, multBy);
    }

    @Override
    public String toString() {
        return "Undo vynásob riadok "+multBy.toString();
    }
    
    @Override
    public int getType() {
        return type;
    }
}

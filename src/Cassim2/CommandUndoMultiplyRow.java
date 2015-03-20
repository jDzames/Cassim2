
package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


public class CommandUndoMultiplyRow implements Command{

    private final BigFraction multBy;
    private final int row;
    private int basisIdx;

    public CommandUndoMultiplyRow(BigFraction multBy, int row, int basisIdx) {
        this.multBy = multBy;
        this.row = row;
        this.basisIdx = basisIdx;
    }
    
    @Override
    public void execute() {
        SolutionCalcService solClculations = new SolutionCalcService();
        BigFraction fr = new BigFraction(multBy.getDenominator(), multBy.getNumerator());
        solClculations.multiplRow(row, multBy);
        ValuesSingleton.INSTANCE.basisDataIdx[row-1] = basisIdx;
    }

    @Override
    public String toString() {
        return "Undo vynásob riadok "+multBy.toString();
    }
    
}

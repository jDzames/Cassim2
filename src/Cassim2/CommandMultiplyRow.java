
package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


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

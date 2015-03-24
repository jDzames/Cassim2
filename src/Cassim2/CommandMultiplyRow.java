
package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


public class CommandMultiplyRow implements Command {

    private int row;
    private BigFraction multBy;
    
    public CommandMultiplyRow(int row, BigFraction multBy) {
        this.row = row;
        this.multBy = multBy;
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
    
}

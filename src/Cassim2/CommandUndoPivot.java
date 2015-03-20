package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


public class CommandUndoPivot implements Command{

    private int positionRow;
    private int positionColumn;
    private int oldBasisIdx;
    private BigFraction[] column;

    public CommandUndoPivot(int positionRow, int positionColumn, int oldBasisidx, BigFraction[] column) {
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.oldBasisIdx = oldBasisidx;
        this.column = column;
    }
    
    @Override
    public Command execute() {
        SolutionCalcService solCalculations = new SolutionCalcService();
        
        for (int i = 0; i < column.length; i++) {
            if (positionRow==i) {
                continue;
            }
            solCalculations.addRowToRow(positionRow, i, column[i]);
        }
        solCalculations.multiplRow(positionRow, column[positionRow]);
        ValuesSingleton.INSTANCE.basisDataIdx[positionRow-1] = oldBasisIdx;
        return new CommandPivot(positionRow, positionColumn);
    }

    @Override
    public String toString() {
        return "Undo pivot na"+"["+positionRow+","+positionColumn+"]"; 
    }

}

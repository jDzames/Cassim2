package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


public class CommandUndoPivot implements Command{

    private final int positionRow;
    private final int positionColumn;
    private final BigFraction[] column;

    public CommandUndoPivot(int positionRow, int positionColumn, BigFraction[] column) {
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.column = column;
    }
    
    @Override
    public void execute() {
        SolutionCalcService solCalculations = new SolutionCalcService();
        
        for (int i = 0; i < column.length; i++) {
            if (positionRow==i) {
                continue;
            }
            solCalculations.addRowToRow(positionRow, i, column[i]);
        }
        solCalculations.multiplRow(positionRow, column[positionRow]);
        
    }
    
}

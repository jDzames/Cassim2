package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


public class CommandUndoMakeBasis implements Command{

    private final int[] rowsChoosed;
    private final int[] columnsChoosed;
    private final BigFraction[] tableChoosed;
    private final BigFraction[] row0Choosed;

    public CommandUndoMakeBasis(int[] rowsChoosed, int[] columnsChoosed, BigFraction[] tableChoosed, BigFraction[] row0Choosed) {
        this.rowsChoosed = rowsChoosed;
        this.columnsChoosed = columnsChoosed;
        this.tableChoosed = tableChoosed;
        this.row0Choosed = row0Choosed;
    }
    
    @Override
    public void execute() {
        
        
    }
    
    
    
}

package Cassim2;

import java.math.BigInteger;
import org.apache.commons.math3.fraction.BigFraction;


public class CommandUndoMakeBasis implements Command{

    private final BigFraction[] tableChoosed; //jak idem cez bazu a bazujem, tak v tom poradi tu prvky
    private final BigFraction[] row0;
    private final byte type;

    public CommandUndoMakeBasis(BigFraction[] tableChoosed, BigFraction[] row0Choosed) {
        this.tableChoosed = tableChoosed;
        this.row0 = row0Choosed;
        type = 1;
    }
    
    @Override
    public Command execute() {
        int[] basisIdx = ValuesSingleton.INSTANCE.basisDataIdx;
        SolutionCalcService solCalculations = new SolutionCalcService();
        for (int i = 0; i < basisIdx.length; i++) {
            if (basisIdx[i]>0) {
                BigFraction fr = row0[basisIdx[i]];
                solCalculations.addRowToRow(i+1, 0, fr);
                solCalculations.multiplRow(i+1, tableChoosed[i]);   
            }
            
        }
        return new CommandMakeBasis();
    }

    @Override
    public String toString() {
        return "Undo bázovanie";
    }
    
    @Override
    public int getType() {
        return type;
    }
}

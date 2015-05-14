package sk.upjs.ics.s.jdzama.Cassim2.Commands.undo;

import sk.upjs.ics.s.jdzama.Cassim2.logic.SolutionCalcService;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import java.math.BigInteger;
import org.apache.commons.math3.fraction.BigFraction;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.redo.CommandMakeBasis;


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
                BigFraction fr = row0[i];
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

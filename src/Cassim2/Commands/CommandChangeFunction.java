
package Cassim2.Commands;

import Cassim2.ValuesSingleton;
import org.apache.commons.math3.fraction.BigFraction;


public class CommandChangeFunction implements Command{
    
    private final byte type;
    private BigFraction[] row0;

    public CommandChangeFunction(BigFraction[] row0) {
        this.type = 11;
        this.row0 = row0;
    }
    
    @Override
    public Command execute() {
        Command cmd = new CommandUndoChangeFunction(ValuesSingleton.INSTANCE.tableData[0]);
        
        ValuesSingleton.INSTANCE.tableData[0] = row0;
        
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < row0.length; i++) {
            row.append(";").append(row0[i].getNumerator().toString())
                    .append(";").append(row0[i].getDenominator().toString());
        }
        ValuesSingleton.INSTANCE.stack.push("11"+row.toString());
        
        return cmd;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Zmen ucelovu funkciu"; 
    }
    
    
    
}

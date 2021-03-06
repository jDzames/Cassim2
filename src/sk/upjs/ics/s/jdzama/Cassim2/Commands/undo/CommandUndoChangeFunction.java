
package sk.upjs.ics.s.jdzama.Cassim2.Commands.undo;

import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import org.apache.commons.math3.fraction.BigFraction;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.redo.CommandChangeFunction;


public class CommandUndoChangeFunction implements Command{

    private final byte type;
    private BigFraction[] row0;

    public CommandUndoChangeFunction(BigFraction[] row0) {
        this.type = 11;
        this.row0 = row0;
    }
    
    @Override
    public Command execute() {
        Command cmd = new CommandChangeFunction(ValuesSingleton.INSTANCE.tableData[0]);
        
        ValuesSingleton.INSTANCE.tableData[0] = row0;
        
        return cmd;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "UNDO zmen ucelovu funkciu"; 
    }
    
    
}


package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


public class CommandGomory implements Command {

    private int row;
    private final byte type;
    
    public CommandGomory(int rowPosition) {
        row = rowPosition;
        type = 6;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("2;"+row);
        return ValuesSingleton.INSTANCE.doGomory(row);
    }

    @Override
    public String toString() {
        return "Gomory na riadku "+row;
    }

    @Override
    public int getType() {
        return type;
    }
    
}

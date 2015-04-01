
package Cassim2.Commands;

import Cassim2.Commands.CommandUndoRevidedStart;
import Cassim2.ValuesSingleton;


public class CommandRevidedStart implements Command {

    private final byte type;
    
    public CommandRevidedStart() {
        type = 10;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("10");
        return new CommandUndoRevidedStart();
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Začni pomocnú úlohu";
    }
    
}

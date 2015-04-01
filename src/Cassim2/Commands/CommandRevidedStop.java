
package Cassim2.Commands;

import Cassim2.Commands.CommandUndoRevidedStop;
import Cassim2.ValuesSingleton;


public class CommandRevidedStop implements Command {

    private final byte type;
    
    public CommandRevidedStop() {
        type = 9;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("9");
        return new CommandUndoRevidedStop();
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Skonči pomocnú úlohu";
    }
    
}

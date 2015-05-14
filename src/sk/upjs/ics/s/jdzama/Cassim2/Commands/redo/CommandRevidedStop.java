
package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.undo.CommandUndoRevidedStop;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


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

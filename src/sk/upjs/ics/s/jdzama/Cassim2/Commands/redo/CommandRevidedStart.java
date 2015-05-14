
package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.undo.CommandUndoRevidedStart;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


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

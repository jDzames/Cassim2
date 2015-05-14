
package sk.upjs.ics.s.jdzama.Cassim2.Commands.undo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.redo.CommandRevidedStart;


public class CommandUndoRevidedStart implements Command{

    private final byte type;

    public CommandUndoRevidedStart() {
        this.type = 9;
    }
    
    @Override
    public Command execute() {
        return new CommandRevidedStart();
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

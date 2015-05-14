
package sk.upjs.ics.s.jdzama.Cassim2.Commands.undo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.redo.CommandRevidedStop;


public class CommandUndoRevidedStop implements Command{

    private final byte type;

    public CommandUndoRevidedStop() {
        this.type = 10;
    }
    
    @Override
    public Command execute() {
        return new CommandRevidedStop();
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Začni revidovanú úlohu";
    }
    
}

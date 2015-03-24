
package Cassim2;


public class CommandRevidedStart implements Command {

    private final byte type;
    
    public CommandRevidedStart() {
        type = 10;
    }

    @Override
    public Command execute() {
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

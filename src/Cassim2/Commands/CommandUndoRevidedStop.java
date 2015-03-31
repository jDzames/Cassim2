
package Cassim2.Commands;


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

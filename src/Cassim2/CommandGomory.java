
package Cassim2;


public class CommandGomory implements Command {

    private int row;
    private final byte type;
    
    public CommandGomory(int rowPosition) {
        row = rowPosition;
        type = 6;
    }

    @Override
    public Command execute() {
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

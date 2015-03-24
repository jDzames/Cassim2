
package Cassim2;


public class CommandGomory implements Command {

    private int row;
    
    public CommandGomory(int rowPosition) {
        row = rowPosition;
    }

    @Override
    public Command execute() {
        return ValuesSingleton.INSTANCE.doGomory(row);
    }

    @Override
    public String toString() {
        return "Gomory na riadku "+row;
    }
    
}

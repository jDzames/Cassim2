
package Cassim2;


public class CommandEndSuppRoleOpt implements Command {

    private final byte type;
    
    public CommandEndSuppRoleOpt() {
        type = 6;
    }

    @Override
    public Command execute() {
        return ValuesSingleton.INSTANCE.endOfSuppRoleOpt(ValuesSingleton.INSTANCE.suppRoleVariables);
    }

    @Override
    public String toString() {
        return "Ukonci pomocnú úlohu v optime";
    }

    @Override
    public int getType() {
        return type;
    }
    
}

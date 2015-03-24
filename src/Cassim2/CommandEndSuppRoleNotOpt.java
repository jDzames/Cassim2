
package Cassim2;


public class CommandEndSuppRoleNotOpt implements Command {

    private final byte type;
    
    public CommandEndSuppRoleNotOpt() {
       type  = 4;
    }

    @Override
    public Command execute() {
        return ValuesSingleton.INSTANCE.endOfSuppRoleNotOpt(ValuesSingleton.INSTANCE.suppRoleVariables);
    }

    @Override
    public String toString() {
        return "Ukonči pomocnú úlohu mimo optima";
    }

    @Override
    public int getType() {
        return type;
    }
}

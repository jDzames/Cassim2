
package Cassim2.Commands;

import Cassim2.ValuesSingleton;


public class CommandEndSuppRoleNotOpt implements Command {

    private final byte type;
    
    public CommandEndSuppRoleNotOpt() {
       type  = 4;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("6");
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

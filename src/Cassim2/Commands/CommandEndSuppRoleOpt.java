
package Cassim2.Commands;

import Cassim2.ValuesSingleton;


public class CommandEndSuppRoleOpt implements Command {

    private final byte type;
    
    public CommandEndSuppRoleOpt() {
        type = 6;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("5");
        ValuesSingleton.INSTANCE.suppRoleRunning = false;
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

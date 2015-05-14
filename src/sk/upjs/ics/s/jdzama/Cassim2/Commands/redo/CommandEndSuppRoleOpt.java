
package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


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

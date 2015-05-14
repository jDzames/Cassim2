
package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


public class CommandEndSuppRoleNotOpt implements Command {

    private final byte type;
    
    public CommandEndSuppRoleNotOpt() {
       type  = 4;
    }

    @Override
    public Command execute() {
        ValuesSingleton.INSTANCE.stack.push("6");
        ValuesSingleton.INSTANCE.suppRoleRunning = false;
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

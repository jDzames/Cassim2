
package Cassim2;


public class CommandEndSuppRoleNotOpt implements Command {

    public CommandEndSuppRoleNotOpt() {
    }

    @Override
    public Command execute() {
        return ValuesSingleton.INSTANCE.endOfSuppRoleNotOpt(ValuesSingleton.INSTANCE.suppRoleVariables);
    }

    @Override
    public String toString() {
        return "Ukonči pomocnú úlohu mimo optima";
    }
}


package Cassim2;


public class CommandEndSuppRoleOpt implements Command {

    public CommandEndSuppRoleOpt() {
    }

    @Override
    public Command execute() {
        return ValuesSingleton.INSTANCE.endOfSuppRoleOpt(ValuesSingleton.INSTANCE.suppRoleVariables);
    }

    @Override
    public String toString() {
        return "Ukonci pomocnú úlohu v optime";
    }
    
}

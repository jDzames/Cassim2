
package sk.upjs.ics.s.jdzama.Cassim2.Commands.redo;

import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


public class CommandStartSuppRole implements Command {

    private final byte type;
    
    public CommandStartSuppRole() {
        type = 2;
    }

    @Override
    public Command execute() {
        int pocet = 0;
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            int j = ValuesSingleton.INSTANCE.basisDataIdx[i];
            if (j<=0) {
                pocet++;
            }
        }
        ValuesSingleton.INSTANCE.stack.push("4");
        return ValuesSingleton.INSTANCE.startSuppRole(pocet);
    }

    @Override
    public String toString() {
        return "Začni pomocnú úlohu";
    }

    @Override
    public int getType() {
        return type;
    }
    
}

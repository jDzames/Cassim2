
package Cassim2;


class CommandStartSuppRole implements Command {

    public CommandStartSuppRole() {
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
        return ValuesSingleton.INSTANCE.startSuppRole(pocet);
    }

    @Override
    public String toString() {
        return "Začni pomocnú úlohu";
    }
    
}

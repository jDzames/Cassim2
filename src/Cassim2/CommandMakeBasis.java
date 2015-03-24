
package Cassim2;


public class CommandMakeBasis implements Command {

    private final byte type;
    
    public CommandMakeBasis() {
        type = 1;
    }

    @Override
    public Command execute() {
        SolutionCalcService solCalc = new SolutionCalcService();
        return solCalc.makeZeroOverBasis();
    }

    @Override
    public String toString() {
        return "Bázuj";
    }

    @Override
    public int getType() {
        return type;
    }
    
}

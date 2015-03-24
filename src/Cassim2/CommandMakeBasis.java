
package Cassim2;


public class CommandMakeBasis implements Command {

    public CommandMakeBasis() {
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
    
}

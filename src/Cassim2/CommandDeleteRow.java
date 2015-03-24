
package Cassim2;


public class CommandDeleteRow implements Command{

    private int row;

    public CommandDeleteRow(int row) {
        this.row = row;
    }
    
    @Override
    public Command execute() {
        SolutionCalcService solCalc = new SolutionCalcService();
        return solCalc.deleteRow(row);
    }

    @Override
    public String toString() {
        return "Vymaž riadok "+row;
    }
    
    
}

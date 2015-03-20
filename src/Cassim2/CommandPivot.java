
package Cassim2;

public class CommandPivot implements Command{
    
    private int positionRow;
    private int positionColumn;

    public CommandPivot(int positionRow, int positionColumn) {
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
    }

    @Override
    public Command execute() {
        SolutionCalcService solCalc = new SolutionCalcService();
        return solCalc.pivot(positionRow, positionColumn);
    }

    @Override
    public String toString() {
        return "Pivot na ["+positionRow+","+positionColumn+"]"; 
    }
  
}

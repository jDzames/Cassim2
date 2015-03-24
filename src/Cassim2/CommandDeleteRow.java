
package Cassim2;


public class CommandDeleteRow implements Command{

    private int row;
    private final byte type;

    public CommandDeleteRow(int row) {
        this.row = row;
        type = 8;
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

    @Override
    public int getType() {
        return this.type;
    }
    
    
}

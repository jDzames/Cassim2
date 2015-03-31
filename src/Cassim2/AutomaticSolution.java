
package Cassim2;

import Cassim2.Commands.Command;
import java.util.Stack;
import java.util.concurrent.Callable;
import org.apache.commons.math3.fraction.BigFraction;


public class AutomaticSolution implements Callable<AutoSolObj>{
    private final Stack<Command> undoStack;

    public AutomaticSolution(Stack<Command> undoStack) {
        this.undoStack = undoStack;
    }

    @Override
    public AutoSolObj call() throws Exception {
        //vytvorim triedy
        SolutionCalcService solCalc = new SolutionCalcService();
        ValuesSingleton values = ValuesSingleton.INSTANCE;
        
        //nezaporny 0. stlpec nech mam
        for (int i = 1; i < values.tableData.length; i++) {
            if (values.tableData[i][0].compareTo(BigFraction.ZERO)<0) {
                undoStack.push(solCalc.multiplRow(i, BigFraction.MINUS_ONE));
            }
        }
        
        //najdi bazu 
        solCalc.findBasis();
        
        //ci treba pomocnu
        int pomocnychPremennych = 0;
        for (int i = 0; i < values.basisDataIdx.length; i++) {
            if (values.basisDataIdx[i]<=0) {
                pomocnychPremennych++;
            }
        }
        
        //ak treba
        if (pomocnychPremennych>0) {
            undoStack.push(values.startSuppRole(pomocnychPremennych));
        }
        
        //vyries ak bezi
        if (values.suppRoleRunning) {
            boolean notSolved = true;
            while (notSolved) {                
                int column = solCalc.firstNegativeColumn();
                if (column == -1) {
                    return new AutoSolObj("Úloha nemá riešenie, skončila v pomocnej úlohe.");
                }
                int row = solCalc.blandPivotRow(column);
                if (row == -1) {
                    return new AutoSolObj("Úloha je neohraničená?");
                }
                undoStack.push(solCalc.pivot(row, column));
                
                notSolved = values.tableData[0][0].compareTo(BigFraction.ZERO)!=0 || solCalc.suppVariableInBasis();
            }
        }
        
        //
        undoStack.push(solCalc.makeZeroOverBasis());
        
        //ak som tu, tak idem riesit normalne, pivot 
        int column = solCalc.firstNegativeColumn();
        while (column != -1) {            
            int row = solCalc.blandPivotRow(column);
            if (row == -1) {
                return new AutoSolObj("Úloha je neohraničená?");
            }
            undoStack.push(solCalc.pivot(row, column));

            column = solCalc.firstNegativeColumn();
        }
        
        //doriesil som, asi vsetko dobre ked som az sem dosiel
        return new AutoSolObj("Hotovo. Po riešení sa viete posúvať pomocou UNDO a REDO.");
    }


}

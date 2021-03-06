package sk.upjs.ics.s.jdzama.Cassim2.logic;



import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import java.math.BigInteger;
import org.apache.commons.math3.fraction.BigFraction;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.Command;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.undo.CommandUndoDeleteRow;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.undo.CommandUndoMakeBasis;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.undo.CommandUndoMultiplyRow;
import sk.upjs.ics.s.jdzama.Cassim2.Commands.undo.CommandUndoPivot;


public class SolutionCalcService {
    

    public int check0Column(){
        //-1:ak v 0. stlpci je zaporne, +1:inak
        for (int i=1; i<= ValuesSingleton.INSTANCE.rows; i++) {
            if (ValuesSingleton.INSTANCE.tableData[i][0].getNumerator().compareTo(BigInteger.ZERO) <0){
                return -1;
            }
        }       
        return 1;      
    }
    
    public int check0Row(){
        //-1:ak v 0. riadku je zaporne, +1:inak
        int till = ValuesSingleton.INSTANCE.showColumns;
        if (ValuesSingleton.INSTANCE.suppRoleRunning) {
            till = ValuesSingleton.INSTANCE.columnNames.length;
        }
        for (int i=1; i< till; i++) {
            if (ValuesSingleton.INSTANCE.tableData[0][i].getNumerator().compareTo(BigInteger.ZERO) <0){
                return -1;
            }
        }
        return 1;
    }  
    
    public Command multiplRow(int row, BigFraction multipl){
        int basisIdx = ValuesSingleton.INSTANCE.basisDataIdx[row-1];
        for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
            ValuesSingleton.INSTANCE.tableData[row][j] = ValuesSingleton.INSTANCE.tableData[row][j].multiply(multipl);
        }
        return new CommandUndoMultiplyRow(multipl, row, basisIdx);
    }
    
    public void addRowToRow(int addingRow, int toRow, BigFraction multipl){
        for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
            ValuesSingleton.INSTANCE.tableData[toRow][j] = 
                    ValuesSingleton.INSTANCE.tableData[toRow][j].add(ValuesSingleton.INSTANCE.tableData[addingRow][j].multiply(multipl));
        }
    }
    
    public boolean isBased(){
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i]<0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean have0overBasis() {
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i]>0) {
                int col = ValuesSingleton.INSTANCE.basisDataIdx[i];
                if (!(ValuesSingleton.INSTANCE.tableData[i+1][col].compareTo(BigFraction.ONE)==0)) {
                    return false;
                }
                if (ValuesSingleton.INSTANCE.tableData[0][col].getNumerator().compareTo(BigInteger.ZERO)!=0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void findBasis() {

        for (int i = 1; i <= ValuesSingleton.INSTANCE.columns; i++) {
            int row=0;
            int inBasis = 0;
            
            for (int j = 1; j <= ValuesSingleton.INSTANCE.rows; j++) {
                if (!(ValuesSingleton.INSTANCE.getTableData()[j][i].getNumerator().compareTo(BigInteger.ZERO)==0)) {
                    if (ValuesSingleton.INSTANCE.getTableData()[j][i].getNumerator().compareTo(BigInteger.ZERO)>0) {
                        inBasis++;
                        row=j;
                    } else{
                        inBasis=inBasis+2;
                    }   
                }              
            }
            if (inBasis==1 && ValuesSingleton.INSTANCE.basisDataIdx[row-1]<=0) {
                ValuesSingleton.INSTANCE.basisDataIdx[row-1]=i;
                BigFraction rec = ValuesSingleton.INSTANCE.getTableData()[row][i].reciprocal();
                for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
                    ValuesSingleton.INSTANCE.tableData[row][j] = ValuesSingleton.INSTANCE.tableData[row][j].multiply(rec);
                }
            } 
        }
    }
    
    public Command makeZeroOverBasis(){
        BigFraction[] row0Choosed = new BigFraction[ValuesSingleton.INSTANCE.basisDataIdx.length];
        BigFraction[] tableChoosed = new BigFraction[ValuesSingleton.INSTANCE.basisDataIdx.length];
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            int column = ValuesSingleton.INSTANCE.basisDataIdx[i];
            if (column>0) {
                row0Choosed[i] = new BigFraction(ValuesSingleton.INSTANCE.tableData[0][column].getNumerator(), ValuesSingleton.INSTANCE.tableData[0][column].getDenominator());
                tableChoosed[i] = new BigFraction(ValuesSingleton.INSTANCE.tableData[i+1][column].getNumerator(), ValuesSingleton.INSTANCE.tableData[i+1][column].getDenominator());
            
                int row = i+1;
                multiplRow(row, new BigFraction(ValuesSingleton.INSTANCE.tableData[row][column].getDenominator(), ValuesSingleton.INSTANCE.tableData[row][column].getNumerator()));
                addRowToRow(row, 0, new BigFraction(ValuesSingleton.INSTANCE.tableData[0][column].getNumerator().multiply(BigInteger.valueOf(-1)), ValuesSingleton.INSTANCE.tableData[0][column].getDenominator()));
            }
        }  
        return new CommandUndoMakeBasis(tableChoosed, row0Choosed);
    }
    
    public int checkMin(int selectedColumn){
        //error
        if (selectedColumn <= 0)
            return -4;
        if (check0Column() <0)
                return -3;
        //question
        if (ValuesSingleton.INSTANCE.tableData[0][selectedColumn].getNumerator().compareTo(BigInteger.ZERO)>0)
            return -1;
        //OK
        return 0;
    }

    public int minimum(int selectedColumn) {     
        
        int minIdx = -2;
        BigFraction minimal = new BigFraction(Long.MAX_VALUE);
        
        for (int i = 1; i <= ValuesSingleton.INSTANCE.rows; i++) {
            if (ValuesSingleton.INSTANCE.tableData[i][selectedColumn].getNumerator().compareTo(BigInteger.ZERO)<=0) {
                continue;
            }
            BigFraction actual = new BigFraction(ValuesSingleton.INSTANCE.tableData[i][0].getNumerator(),ValuesSingleton.INSTANCE.tableData[i][0].getDenominator());
            actual = actual.divide(ValuesSingleton.INSTANCE.tableData[i][selectedColumn]);
            if (minimal.compareTo(actual)>0) {
                minimal = actual;
                minIdx = i;
            }
        }
        
        return minIdx;
    }

    public int checkMax(int selectedRow, int selectedColumn){
        //error
        if (selectedRow <= 0)
            return -4; //0. riadok, nehladam max
        if (check0Row() <0)
                return -3;//nulty riadok ma byt kladny       
        //question
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][0].getNumerator().compareTo(BigInteger.ZERO)>0)
                return -1;//v 0. stlpci ma byt zaporna hodnota tu
        //OK
        return 0;
    }
    
    public int maximum(int selectedRow, int selectedColumn) {
           
        int maxIdx = -2;
        BigFraction maximal = new BigFraction(Long.MIN_VALUE);
        int cols = ValuesSingleton.INSTANCE.suppRoleRunning ? ValuesSingleton.INSTANCE.columns :
                ValuesSingleton.INSTANCE.columns - ValuesSingleton.INSTANCE.suppRoleVariables;
        
        for (int i = 1; i <= cols; i++) {
            if (ValuesSingleton.INSTANCE.tableData[selectedRow][i].getNumerator().compareTo(BigInteger.ZERO)>=0) {
                continue;
            }
            BigFraction actual = new BigFraction(ValuesSingleton.INSTANCE.tableData[0][i].getNumerator(),ValuesSingleton.INSTANCE.tableData[0][i].getDenominator());
            actual = actual.divide(ValuesSingleton.INSTANCE.tableData[selectedRow][i]);
            if (maximal.compareTo(actual)<0) {
                maximal = actual;
                maxIdx = i;
            }
        }
        
        return maxIdx;
    }
    
    private boolean isWorseThanMin(int selectedRow, int selectedColumn){
        BigFraction valueHere = new BigFraction(ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getNumerator(), ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getDenominator());
        valueHere = ValuesSingleton.INSTANCE.tableData[selectedRow][0].divide(valueHere);
        
        int min = minimum(selectedColumn);
        BigFraction valueMin = new BigFraction(ValuesSingleton.INSTANCE.tableData[min][selectedColumn].getNumerator(), ValuesSingleton.INSTANCE.tableData[min][selectedColumn].getDenominator());
        valueMin = ValuesSingleton.INSTANCE.tableData[min][0].divide(valueMin);
        
        return (valueHere.compareTo(valueMin)>0);
    }
    
    private boolean isWorseThanMax(int selectedRow, int selectedColumn){
        BigFraction valueHere = new BigFraction(ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getNumerator(), ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getDenominator());
        valueHere = ValuesSingleton.INSTANCE.tableData[0][selectedColumn].divide(valueHere);
        
        int max = maximum(selectedRow, selectedColumn);
        BigFraction valueMax = new BigFraction(ValuesSingleton.INSTANCE.tableData[selectedRow][max].getNumerator(), ValuesSingleton.INSTANCE.tableData[selectedRow][max].getDenominator());
        valueMax = ValuesSingleton.INSTANCE.tableData[0][max].divide(valueMax);
        
        return (valueHere.compareTo(valueMax)<0);
    }
    
    public int checkPivot(int selectedRow, int selectedColumn){
        boolean isSuppSol = ValuesSingleton.INSTANCE.suppRoleRunning;

        //errory
        if (selectedRow<=0 || selectedColumn<=0 || (!ValuesSingleton.INSTANCE.suppRoleRunning && 
                selectedColumn>=ValuesSingleton.INSTANCE.columnNames.length-ValuesSingleton.INSTANCE.suppRoleVariables)) 
            return -1;//tu nepivotujem      
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getNumerator().compareTo(BigInteger.ZERO)==0) 
            return -2;//nepivotujem na 0
        if (isSuppSol && (ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getNumerator().compareTo(BigInteger.ZERO)<0) 
                && ((ValuesSingleton.INSTANCE.tableData[selectedRow][0].compareTo(BigFraction.ZERO)!=0)
                || (ValuesSingleton.INSTANCE.tableData[0][0].compareTo(BigFraction.ZERO)!=0)))
            return -2;//nepivotujem dualne v pomocnej
        
        if (check0Column()<0 && check0Row()<0) 
            return -3;//nezodpovedá SM
        //questiony
        //vetvenie na dva a v oboch po 2 Q a ked ano, posli rovno, neries dalsie, uz i tak nezodpoveda (ci 1 abo obi2)
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getNumerator().compareTo(BigInteger.ZERO)>0) {
            if (ValuesSingleton.INSTANCE.tableData[0][selectedColumn].getNumerator().compareTo(BigInteger.ZERO)>0) {
                return -4;
            }
            if (isWorseThanMin(selectedRow, selectedColumn)) {
                return -5;
            }
        } else {
            if (ValuesSingleton.INSTANCE.tableData[selectedRow][0].getNumerator().compareTo(BigInteger.ZERO)>0) {
                return -4;
            }
            if (isWorseThanMax(selectedRow, selectedColumn)) {
                return -5;
            }
        }          
        //OK
        return 0;
    }

    public Command pivot(int row, int column){
        BigFraction[] col = new BigFraction[ValuesSingleton.INSTANCE.tableData.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = new BigFraction(ValuesSingleton.INSTANCE.tableData[i][column].getNumerator(), ValuesSingleton.INSTANCE.tableData[i][column].getDenominator());
        }
        Command cmd = new CommandUndoPivot(row, column, ValuesSingleton.INSTANCE.basisDataIdx[row-1],col);
        
        BigInteger num=ValuesSingleton.INSTANCE.tableData[row][column].getNumerator();
        BigInteger denom=ValuesSingleton.INSTANCE.tableData[row][column].getDenominator();
        if (num.compareTo(BigInteger.ONE)!=0 || denom.compareTo(BigInteger.ONE)!=0) {
            multiplRow(row, new BigFraction(denom, num));   //nasobim prevratenou hodnototu=>1       
        }
        for (int i = 0; i <= ValuesSingleton.INSTANCE.rows; i++) {
            if (row==i) {
                continue;
            }
            addRowToRow(row, i, new BigFraction(ValuesSingleton.INSTANCE.tableData[i][column].getNumerator().multiply(BigInteger.valueOf(-1)), ValuesSingleton.INSTANCE.tableData[i][column].getDenominator()) );
        }
        ValuesSingleton.INSTANCE.basisDataIdx[row-1]=column;
        return cmd;
    }

    public boolean rightEndOfSuppRole(int pocetPomPremennych) {
        if (!this.isBased()) {
            return false;
        }
        
        if (ValuesSingleton.INSTANCE.tableData[0][0].getNumerator().compareTo(BigInteger.ZERO)!=0) {
            return false;
        }
        
        int pocetPovodStlpcov = ValuesSingleton.INSTANCE.columns-ValuesSingleton.INSTANCE.suppRoleVariables;
        for (int i = 0; i < ValuesSingleton.INSTANCE.rows; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i]>pocetPovodStlpcov) {
                
                if (ValuesSingleton.INSTANCE.tableData[i+1][0].getNumerator().compareTo(BigInteger.ZERO)!=0) {
                    return false;
                }
                for (int j = 1; j <= pocetPovodStlpcov; j++) {
                    if (ValuesSingleton.INSTANCE.tableData[i+1][j].getNumerator().compareTo(BigInteger.ZERO)!=0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int checkGomory(int selectedRow, int selectedColumn) {
        //errory
        if (this.check0Column()<0) {
            return -1; //v nepripustnom rieseni
        }
        if (!this.isBased()) {
            return -2; //nema bazu
        }
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getDenominator().compareTo(BigInteger.ONE)==0) {
            return -3; //neje zlomok
        }
        //question
        if (this.check0Row()<0) {
            return -4; //este sa da pivotovat
        }
        //OK
        return 0;
    }

    public int canBeMultiplied(int selectedRow) {
        //errory
        if (ValuesSingleton.INSTANCE.basisDataIdx[selectedRow-1]>0) {
            return -1; //ma tam bazu
        } 
        if (check0Row()==1) {
            return 0; //kladny 0. riadok
        }
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][0].getNumerator().compareTo(BigInteger.ZERO)>=0) {
            return -2; //v 0. stlpci neje zaporne
        }
        //OK
        return 0;
    }

    public Command deleteRow(int row) {
        int basisIdxOld = ValuesSingleton.INSTANCE.basisDataIdx[row-1];
        
        if (row<=0 || row>=ValuesSingleton.INSTANCE.tableData.length) {
            return null;
        }
        //ci je riadok na vymazanie
        for (int i = 0; i < ValuesSingleton.INSTANCE.showColumns; i++) {
            if (ValuesSingleton.INSTANCE.tableData[row][i].compareTo(BigFraction.ZERO)!=0) {
                return null;
            }
        }
        
        BigFraction[] rowDeleted = ValuesSingleton.INSTANCE.tableData[row];
        //vymazanie ho
        BigFraction[][] pole = new BigFraction[ValuesSingleton.INSTANCE.tableData.length-1][ValuesSingleton.INSTANCE.tableData[0].length];
        int idx=0;
        for (int i = 0; i < ValuesSingleton.INSTANCE.tableData.length; i++) {
            if (i!=row) {
                pole[idx]=ValuesSingleton.INSTANCE.tableData[i];
                idx++;
            }
        }
        ValuesSingleton.INSTANCE.tableData=pole;
        pole=null;
        //a bazy
        int[] basisPole = new int[ValuesSingleton.INSTANCE.basisDataIdx.length-1];
        int basisIdx=0;
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            if (i!=row-1) {
                basisPole[basisIdx]=ValuesSingleton.INSTANCE.basisDataIdx[i];
                basisIdx++;
            }
        }
        ValuesSingleton.INSTANCE.basisDataIdx=basisPole;
        basisPole=null;
        ValuesSingleton.INSTANCE.rows--;
        return new CommandUndoDeleteRow(row, rowDeleted, basisIdxOld);
    }

    public Hint hint() {
        //ak mam situaciu na prenasobenie riadka -1
        if (check0Column() == -1 && (check0Row() == -1 || !isBased())) {
            for (int i = 1; i < ValuesSingleton.INSTANCE.tableData.length; i++) {
                if (ValuesSingleton.INSTANCE.tableData[i][0].compareTo(BigFraction.ZERO)<0) {
                    return new Hint(1, i, 0, "Vynásobte riadok zápornou konštantou. (-1)");
                }
            }
        }
        //ak dualne pivotovanie
        if(isBased() && check0Column()==-1 && check0Row()==1 && !ValuesSingleton.INSTANCE.suppRoleRunning) {
            int row = firstNegativeRow();
            int column = -1;
            for (int i = 1; i < ValuesSingleton.INSTANCE.showColumns; i++) {
                if (ValuesSingleton.INSTANCE.tableData[row][i].compareTo(BigFraction.ZERO)<0) {
                    column = i;
                    break;
                }
            }
            if (column == -1) {
                return new Hint(0, "Úloha je duálne neprípustná (??)");
            }
            return new Hint(1, row, column, "Duálne pivotovanie na ["+row+", "+column+"].");
        }
        //nema 0 nad bazou
        if (!have0overBasis()) {
            return new Hint(0, "Vybázuj.");
        }
        //pomocná uloha
        if(!isBased()){
            return new Hint(0, "Spustite pomocnú úlohu.");
        }
        //ukonc pomocnu
        if (ValuesSingleton.INSTANCE.suppRoleRunning && rightEndOfSuppRole(ValuesSingleton.INSTANCE.suppRoleVariables)) {
            return new Hint(0, "Ukonči pomocnú úlohu");
        }
        //pivotovanie
        int column = firstNegativeColumn();
        if (column!=-1) {
            int row = blandPivotRow(column);
            return new Hint(1, row, column, "Pivotovanie na ["+row+", "+column+"].");
        }
        //asi hotovo
        if (ValuesSingleton.INSTANCE.suppRoleRunning) {
            return new Hint(0, "Úloha nemá riešenie. (??) ");
        } else {
            return new Hint(0, "Úloha je vyriešená. ");
        }
    }

    public  boolean suppVariableInBasis() {
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i]>=
                    ValuesSingleton.INSTANCE.tableData[0].length-ValuesSingleton.INSTANCE.suppRoleVariables) {
                return true;
            }
        }
        return false;
    }

    public int firstNegativeColumn() {
        for (int i = 1; i < ValuesSingleton.INSTANCE.showColumns; i++) {
            if (ValuesSingleton.INSTANCE.tableData[0][i].compareTo(BigFraction.ZERO) < 0){
                return i;
            }
        }
        return -1;
    }
    
    public int firstNegativeRow() {
        for (int i = 1; i < ValuesSingleton.INSTANCE.tableData.length; i++) {
            if (ValuesSingleton.INSTANCE.tableData[i][0].compareTo(BigFraction.ZERO) < 0){
                return i;
            }
        }
        return -1;
    }

    public int blandPivotRow(int column) {
        int bestRow = ValuesSingleton.INSTANCE.rows+10;
        int bestColumn = ValuesSingleton.INSTANCE.columns+10;
        BigFraction min = new BigFraction(-1);
        for (int i = 1; i < ValuesSingleton.INSTANCE.tableData.length; i++) {
            BigFraction posFR = ValuesSingleton.INSTANCE.tableData[i][column];
            if (posFR.compareTo(BigFraction.ZERO)<=0) {
                continue;
            }
            BigFraction pomer = ValuesSingleton.INSTANCE.tableData[i][0].divide(posFR);
            if (min.compareTo(BigFraction.MINUS_ONE) == 0 || 
                    pomer.compareTo(min) < 0 || 
                    (pomer.compareTo(min) == 0 && ValuesSingleton.INSTANCE.basisDataIdx[i-1] < bestColumn)) {
                bestColumn = ValuesSingleton.INSTANCE.basisDataIdx[i-1];
                bestRow = i;
                min = pomer;
            }
            
        }
        
        if (bestRow == ValuesSingleton.INSTANCE.rows+10) {
            return -1;
        }
        
        return bestRow;
    }

    
}

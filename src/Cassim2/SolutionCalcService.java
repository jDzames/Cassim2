package Cassim2;



import java.math.BigInteger;
import org.apache.commons.math3.fraction.BigFraction;


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
        for (int i=1; i<= ValuesSingleton.INSTANCE.columns; i++) {
            if (ValuesSingleton.INSTANCE.tableData[0][i].getNumerator().compareTo(BigInteger.ZERO) <0){
                return -1;
            }
        }
        return 1;
    }  
    
    public void multiplRow(int row, BigFraction multipl){
        for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
            ValuesSingleton.INSTANCE.tableData[row][j] = ValuesSingleton.INSTANCE.tableData[row][j].multiply(multipl);
        }
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
    
    public void makeZeroOverBasis(){
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            int column = ValuesSingleton.INSTANCE.basisDataIdx[i];
            if (column>0) {
                int row = i+1;
                multiplRow(row, new BigFraction(ValuesSingleton.INSTANCE.tableData[row][column].getDenominator(), ValuesSingleton.INSTANCE.tableData[row][column].getNumerator()));
                addRowToRow(row, 0, new BigFraction(ValuesSingleton.INSTANCE.tableData[0][column].getNumerator().multiply(BigInteger.valueOf(-1)), ValuesSingleton.INSTANCE.tableData[0][column].getDenominator()));
            }
        }  
    }
    
    public int checkMin(int selectedRow, int selectedColumn){
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

    public int minimum(int selectedRow, int selectedColumn) {     
        
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
        
        for (int i = 1; i <= ValuesSingleton.INSTANCE.columns; i++) {
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
        
        int min = minimum(selectedRow, selectedColumn);
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
        if (isSuppSol && (ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getNumerator().compareTo(BigInteger.ZERO)<0)) 
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

    public void pivot(int row, int column){
        
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
    }

    public boolean rightEndOfSuppRole(int pocetPomPremennych) {
        if (!this.isBased()) {
            return false;
        }
        
        if (ValuesSingleton.INSTANCE.tableData[0][0].getNumerator().compareTo(BigInteger.ZERO)!=0) {
            return false;
        }
        
        int pocetPovodStlpcov = ValuesSingleton.INSTANCE.showColumns;
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

    public boolean deleteRow(int row) {
        
        if (row<=0 || row>=ValuesSingleton.INSTANCE.tableData.length) {
            return false;
        }
        //ci je riadok na vymazanie
        for (int i = 0; i < ValuesSingleton.INSTANCE.showColumns; i++) {
            if (ValuesSingleton.INSTANCE.tableData[row][i].compareTo(BigFraction.ZERO)!=0) {
                return false;
            }
        }
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
        return true;
    }

    
}

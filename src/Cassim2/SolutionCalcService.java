
package Cassim2;

import org.apache.commons.math3.fraction.Fraction;


public class SolutionCalcService {
    
    
    private String[] columnNames = ValuesSingleton.INSTANCE.getColumnNames();
    private String[][] data = ValuesSingleton.INSTANCE.getData();

    public int check0Column(){
        //-1:ak v 0. stlpci je zaporne, +1:inak
        for (int i=1; i<= ValuesSingleton.INSTANCE.rows; i++) {
            if (ValuesSingleton.INSTANCE.tableData[i][0].getNumerator() <0){
                return -1;
            }
        }       
        return 1;      
    }
    
    public int check0Row(){
        //-1:ak v 0. riadku je zaporne, +1:inak
        for (int i=1; i<= ValuesSingleton.INSTANCE.columns; i++) {
            if (ValuesSingleton.INSTANCE.tableData[0][i].getNumerator() <0){
                return -1;
            }
        }
        return 1;
    }
    
    
    private void multiplRow(int row, Fraction multipl){
        for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
            ValuesSingleton.INSTANCE.tableData[row][j] = ValuesSingleton.INSTANCE.tableData[row][j].multiply(multipl);
        }
    }
    
    private void addRowToRow(int addingRow, int toRow, Fraction multipl){
        for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
            ValuesSingleton.INSTANCE.tableData[toRow][j] = 
                    ValuesSingleton.INSTANCE.tableData[toRow][j].add(ValuesSingleton.INSTANCE.tableData[addingRow][j].multiply(multipl));
        }
    }
    
    public void findBasis() {

        for (int i = 1; i <= ValuesSingleton.INSTANCE.columns; i++) {
            int row=0;
            int inBasis = 0;
            
            for (int j = 1; j <= ValuesSingleton.INSTANCE.rows; j++) {
                if (!(ValuesSingleton.INSTANCE.getTableData()[j][i].getNumerator()==0)) {
                    inBasis++;
                    row=j;
                }              
            }
            if (inBasis==1) {
                multiplRow(row, new Fraction(ValuesSingleton.INSTANCE.tableData[row][i].getDenominator(), ValuesSingleton.INSTANCE.tableData[row][i].getNumerator()));
                addRowToRow(row, 0, new Fraction(-1*ValuesSingleton.INSTANCE.tableData[0][i].getNumerator(), ValuesSingleton.INSTANCE.tableData[0][i].getDenominator()));

                ValuesSingleton.INSTANCE.basisDataIdx[row-1]=i;
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
        if (ValuesSingleton.INSTANCE.tableData[0][selectedColumn].getNumerator()>0)
            return -1;
        //OK
        return 0;
    }

    public int minimum(int selectedRow, int selectedColumn) {     
        
        int minIdx = -2;
        Fraction minimal = new Fraction(Integer.MAX_VALUE);
        
        for (int i = 1; i <= ValuesSingleton.INSTANCE.rows; i++) {
            if (ValuesSingleton.INSTANCE.tableData[i][selectedColumn].getNumerator()<=0) {
                continue;
            }
            Fraction actual = new Fraction(ValuesSingleton.INSTANCE.tableData[i][0].getNumerator(),ValuesSingleton.INSTANCE.tableData[i][0].getDenominator());
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
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][0].getNumerator()>0)
                return -1;//v 0. stlpci ma byt zaporna hodnota tu
        //OK
        return 0;
    }
    
    public int maximum(int selectedRow, int selectedColumn) {
           
        int maxIdx = -2;
        Fraction maximal = new Fraction(Integer.MIN_VALUE);
        
        for (int i = 1; i <= ValuesSingleton.INSTANCE.columns; i++) {
            if (ValuesSingleton.INSTANCE.tableData[selectedRow][i].getNumerator()>=0) {
                continue;
            }
            Fraction actual = new Fraction(ValuesSingleton.INSTANCE.tableData[0][i].getNumerator(),ValuesSingleton.INSTANCE.tableData[0][i].getDenominator());
            actual = actual.divide(ValuesSingleton.INSTANCE.tableData[selectedRow][i]);
            if (maximal.compareTo(actual)<0) {
                maximal = actual;
                maxIdx = i;
            }
        }
        
        return maxIdx;
    }
    
    public int checkPivot(int selectedRow, int selectedColumn){
        //errory
        if (selectedRow<=0 || selectedColumn<=0) 
            return -1;//tu nepivotujem      
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getNumerator()==0) 
            return -2;//nepivotujem na 0
        if (check0Column()<0 && check0Row()<0) 
            return -3;//nezodpovedá SM
        //questiony
        //vetvenie na dva a v oboch po 2 Q a ked ano, posli rovno, neries dalsie, uz i tak nezodpoveda (ci 1 abo obi2)
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][selectedColumn].getNumerator()>0) {
            if (ValuesSingleton.INSTANCE.tableData[0][selectedColumn].getNumerator()>0) {
                return -4;
            }
            if (minimum(selectedRow, selectedColumn)!=selectedRow) {
                return -5;
            }
        } else {
            if (ValuesSingleton.INSTANCE.tableData[selectedRow][0].getNumerator()>0) {
                return -4;
            }
            if (maximum(selectedRow, selectedColumn)!=selectedColumn) {
                return -5;
            }
        }          
        //OK
        return 0;
    }

    public void pivot(int row, int column){
        
        int num=ValuesSingleton.INSTANCE.tableData[row][column].getNumerator();
        int denom=ValuesSingleton.INSTANCE.tableData[row][column].getDenominator();
        if (num!=1 || denom!=1) {
            multiplRow(row, new Fraction(denom, num));   //nasobim prevratenou hodnototu=>1       
        }
        for (int i = 0; i <= ValuesSingleton.INSTANCE.rows; i++) {
            if (row==i) {
                continue;
            }
            addRowToRow(row, i, new Fraction(-1*ValuesSingleton.INSTANCE.tableData[i][column].getNumerator(), ValuesSingleton.INSTANCE.tableData[i][column].getDenominator()) );
        }
        ValuesSingleton.INSTANCE.basisDataIdx[row-1]=column;
    }

    boolean rightEndOfSuppRole(int pocetPomPremennych) {
        if (ValuesSingleton.INSTANCE.tableData[0][0].getNumerator()!=0) {
            return false;
        }
        
        int pocetPovodStlpcov = ValuesSingleton.INSTANCE.columns-pocetPomPremennych;
        for (int i = 0; i < ValuesSingleton.INSTANCE.rows; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i]>pocetPovodStlpcov) {
                return false;
            }
        }
        return true;
    }
    
}


package Cassim2;

import org.apache.commons.math3.fraction.Fraction;


public class SolutionCalcService {
    
    //private String[] basisData = ValuesSingleton.INSTANCE.getBasisData();
    private String[] columnNames = ValuesSingleton.INSTANCE.getColumnNames();
    private String[][] data = ValuesSingleton.INSTANCE.getData();

    public int check0Row(){
        //-1:if all<0, +1:if all>=0, 0:else
        boolean positive=false;
        boolean negative=false;
        for (int i=1; i<= ValuesSingleton.INSTANCE.rows; i++) {
            if (ValuesSingleton.INSTANCE.tableData[i][0].getNumerator() <0){
                negative=true;
            }else{
                positive=true;
            }
            if (positive&&negative) {
                return 0;
            }
        }
        if (negative) {
            return -1;
        }else{
            return 1;
        }
    }
    
    public int check0Column(){
        //-1:if all<0, +1:if all>=0, 0:else
        boolean positive=false;
        boolean negative=false;
        for (int i=1; i<= ValuesSingleton.INSTANCE.columns; i++) {
            if (ValuesSingleton.INSTANCE.tableData[0][i].getNumerator() <0){
                negative=true;
            }else{
                positive=true;
            }
            if (positive&&negative) {
                return 0;
            }
        }
        if (negative) {
            return -1;
        }else{
            return 1;
        }
        
    }
    
    public void multiplRow(int row, Fraction multipl){
        for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
            ValuesSingleton.INSTANCE.tableData[row][j] = ValuesSingleton.INSTANCE.tableData[row][j].multiply(multipl);
        }
    }
    
    public void addRowToRow(int addingRow, int toRow, Fraction multipl){
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
                if (!data[j][i].trim().equals("0")) {
                    inBasis++;
                    row=j;
                }              
            }
            if (inBasis==1) {
                Fraction oldBasisNumber = new Fraction(ValuesSingleton.INSTANCE.tableData[row][i].getNumerator(), ValuesSingleton.INSTANCE.tableData[row][i].getDenominator());
                Fraction numberToZero = new Fraction(ValuesSingleton.INSTANCE.tableData[0][i].getNumerator(), ValuesSingleton.INSTANCE.tableData[0][i].getDenominator());
                for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
                    ValuesSingleton.INSTANCE.tableData[row][j] = ValuesSingleton.INSTANCE.tableData[row][j].divide(oldBasisNumber);
                    ValuesSingleton.INSTANCE.tableData[0][j] = ValuesSingleton.INSTANCE.tableData[0][j].add(ValuesSingleton.INSTANCE.tableData[row][j].multiply(numberToZero).negate());
                }
                ValuesSingleton.INSTANCE.basisData[row-1]=columnNames[i];
                /*ValuesSingleton.INSTANCE.tableData[0][i] = ValuesSingleton.INSTANCE.tableData[0][i].divide(ValuesSingleton.INSTANCE.tableData[row][i]); 
                ValuesSingleton.INSTANCE.tableData[row][i] = new Fraction(1);*/
            } 
        }
    }

    public int minimum(int selectedRow, int selectedColumn) {
        if (selectedColumn == 0)
            return -4;
        if (ValuesSingleton.INSTANCE.tableData[0][selectedColumn].getNumerator()>0)
            return -1;
        for (int i=1; i<= ValuesSingleton.INSTANCE.rows; i++) {
            if (ValuesSingleton.INSTANCE.tableData[i][0].getNumerator() <0)
                return -3;
        }
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

    public int maximum(int selectedRow, int selectedColumn) {
        if (selectedRow == 0)
            return -4; //0. riadok, nehladam max
        if (ValuesSingleton.INSTANCE.tableData[selectedRow][0].getNumerator()>0)
                return -1;//v 0. stlpci ma byt zaporna hodnota tu
        for (int i=1; i<= ValuesSingleton.INSTANCE.columns; i++) {
            if (ValuesSingleton.INSTANCE.tableData[0][i].getNumerator() <0)
                return -3;//nulty riadok ma byt kladny
        }
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

    public int pivot(int row, int column){
        if (row==0 || column==0) {
            return -1;//tu nepivotujem
        }
        int num=ValuesSingleton.INSTANCE.tableData[row][column].getNumerator();
        int denom=ValuesSingleton.INSTANCE.tableData[row][column].getDenominator();
        if (num!=1 || denom!=1) {
            multiplRow(row, new Fraction(denom, num));   //nasobim prevratenou hodnototu=>1       
        }
        for (int i = 0; i <= ValuesSingleton.INSTANCE.rows; i++) {
            if (row==i) {
                continue;
            }
            addRowToRow(row, i, new Fraction(-1*ValuesSingleton.INSTANCE.tableData[i][column].getDenominator(), ValuesSingleton.INSTANCE.tableData[i][column].getNumerator()));
        }
        return 0; //=vsetko zbehlo OK
    }
    
}

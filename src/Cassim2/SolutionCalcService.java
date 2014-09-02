
package Cassim2;

import org.apache.commons.math3.fraction.Fraction;


public class SolutionCalcService {
    
    //private String[] basisData = ValuesSingleton.INSTANCE.getBasisData();
    private String[] columnNames = ValuesSingleton.INSTANCE.getColumnNames();
    private String[][] data = ValuesSingleton.INSTANCE.getData();

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
   
    
    
}

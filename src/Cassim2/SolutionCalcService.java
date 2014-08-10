
package Cassim2;


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
                System.out.println("row "+row+" premenna"+columnNames[i]);
                ValuesSingleton.INSTANCE.basisData[row-1]=columnNames[i];
            } 
        }
    }
   
    
    
}


package Cassim2;

import java.util.Arrays;
import java.util.LinkedList;
import org.apache.commons.math3.fraction.Fraction;


public enum ValuesSingleton {
    INSTANCE;
    
    public int columns;
    public int rows;
    
    public String[] columnNames;
    public String[][] data;
    public String[] porovnaniasPS; //porovnanie +1 =(prislusne) data (od prveho riadku - lebo bez ucelovej)
    public String[] nezapornost;
    
    public int[] basisDataIdx;
    public Fraction[][] tableData;
    public int selectedRow;
    public int selectedColumn;
    
    public int suppRoleVariables;
    private int gomoryVariables=0;
    
    public Fraction[][] tableDataSaved;
    public int[] basisDataIdxSaved;
    
    public boolean onlyOnce = true; //na nastavenie vysky bunky,nech to nerobi viac krat

    
    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public String[][] getData() {
        return data;
    }

    public String[] getNezapornost() {
        return nezapornost;
    }
    
    public Fraction[][] getTableData() {
        return tableData;
    }

    public boolean isOnlyOnce() {
        return onlyOnce;
    }

    public String[] getPorovnaniasPS() {
        return porovnaniasPS;
    }

    public int[] getBasisData() {
        return basisDataIdx;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public int getSelectedColumn() {
        return selectedColumn;
    }
    

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public void setSelectedColumn(int selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public void setNezapornost(String[] nezapornost) {
        this.nezapornost = nezapornost;
    }

    public void setTableData(Fraction[][] tableData) {
        this.tableData = tableData;
    }

    public void setOnlyOnce(boolean onlyOnce) {
        this.onlyOnce = onlyOnce;
    }

    public void setBasisData(int[] basisData) {
        this.basisDataIdx = basisData;
    }

    public void setPorovnaniasPS(String[] porovnaniasPS) {
        this.porovnaniasPS = porovnaniasPS;
    }

    public void startSuppRole(int pocetPomPremennych) {
        this.columns = this.columns+pocetPomPremennych;
        this.basisDataIdxSaved = this.basisDataIdx.clone();  
        this.tableDataSaved = this.tableData;
        Fraction[][] pole = new Fraction[this.tableData.length][this.tableData[0].length+pocetPomPremennych];
        String[] colNames = new String[this.columnNames.length+pocetPomPremennych];
        System.arraycopy( this.columnNames, 0, colNames, 0, this.columnNames.length );
        int idx=1;
        for (int i = this.columnNames.length; i < this.columnNames.length+pocetPomPremennych; i++) {
            colNames[i] = ""+"p"+idx;
            idx++;
        }
        this.columnNames = colNames;
        
        for(int j=0; j<this.tableData[0].length; j++){
            pole[0][j]=Fraction.ZERO;
        }
        for(int j=this.tableData[0].length; j<pole[0].length; j++){
            pole[0][j]=Fraction.ONE;
        }
        
        for(int i=1; i<pole.length; i++){
            for(int j=0; j<this.tableData[0].length; j++){
                pole[i][j]=new Fraction(this.tableDataSaved[i][j].getNumerator(), this.tableDataSaved[i][j].getDenominator());
            }
            for(int j=this.tableData[0].length; j<pole[0].length; j++){
                pole[i][j]=new Fraction(0);
            }
        }
        
        this.tableData = pole;
        
        int columnPomPremennych=0;
        for (int i = 0; i < this.basisDataIdx.length; i++) {
            if (this.basisDataIdx[i]<0) {
                this.tableData[i+1][this.tableDataSaved[0].length+columnPomPremennych]= Fraction.ONE;
                this.basisDataIdx[i]=this.tableDataSaved[0].length+columnPomPremennych;
                columnPomPremennych++;
            }        
        }  
        this.suppRoleVariables=pocetPomPremennych;
    }

    public void endOfSuppRoleNotOpt(int pocetPomPremennych) {
        this.columns = this.columns-pocetPomPremennych;
        
        ValuesSingleton.INSTANCE.tableData=ValuesSingleton.INSTANCE.tableDataSaved;
        
        ValuesSingleton.INSTANCE.basisDataIdx=ValuesSingleton.INSTANCE.basisDataIdxSaved;
        
        String[] colNames = new String[this.columnNames.length-pocetPomPremennych];
        System.arraycopy( this.columnNames, 0, colNames, 0, colNames.length );      
        this.columnNames = colNames;
        this.suppRoleVariables=0;
    }

    public int[] toIntArray(LinkedList<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i).intValue();
        return ret;
    }
    
    public void endOfSuppRoleOpt(int pocetPomPremennych) {
        this.columns = this.columns-pocetPomPremennych;
        
        /*potom skontroluj v singletone na rightendof supprole 
                a vyhod riadky+1 co su p v baze v riadku (vyhodit z tblData aj basisIdx)*/
        int rowsToRemove = 0;
        this.basisDataIdxSaved=this.basisDataIdx;
        LinkedList<Integer> newBasis = new LinkedList<>();
        for (int i = 0; i < this.basisDataIdxSaved.length; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i]>this.columns) {
                rowsToRemove++;
            }else{
                newBasis.add(ValuesSingleton.INSTANCE.basisDataIdx[i]);
            }
        }
        this.basisDataIdx=toIntArray(newBasis);
        
        Fraction[][] pole = new Fraction[this.tableData.length-rowsToRemove][this.tableData[0].length-pocetPomPremennych];
        for(int j=0; j<pole[0].length; j++){
            pole[0][j]=new Fraction(this.tableDataSaved[0][j].getNumerator(), this.tableDataSaved[0][j].getDenominator());
        }
        int actRowToWrite=1;
        for(int i=1; i<pole.length; i++){
            if (ValuesSingleton.INSTANCE.basisDataIdxSaved[i-1]<=this.columns) {
                for(int j=0; j<pole[0].length; j++){
                    pole[actRowToWrite][j]=new Fraction(this.tableData[i][j].getNumerator(), this.tableData[i][j].getDenominator());
                }
                actRowToWrite++;
            }
        }
        ValuesSingleton.INSTANCE.tableData = pole;
        ValuesSingleton.INSTANCE.rows=ValuesSingleton.INSTANCE.rows-rowsToRemove;
        
        String[] colNames = new String[this.columnNames.length-pocetPomPremennych];
        System.arraycopy( this.columnNames, 0, colNames, 0, colNames.length );      
        this.columnNames = colNames;
        this.suppRoleVariables = 0;
    }

    public void doGomory(int selectedRow) {
        this.columns++;
        this.rows++;
        this.gomoryVariables++;
        
        this.basisDataIdxSaved = this.basisDataIdx;  
        this.tableDataSaved = this.tableData;
        
        String[] colNames = new String[this.columnNames.length+1];
        System.arraycopy( this.columnNames, 0, colNames, 0, this.columnNames.length );
        colNames[colNames.length-1]="G"+this.gomoryVariables;
        this.columnNames = colNames;
        
        this.basisDataIdx=new int[this.basisDataIdxSaved.length+1];
        System.arraycopy( this.basisDataIdxSaved, 0, this.basisDataIdx, 0, this.basisDataIdxSaved.length );
        this.basisDataIdx[this.basisDataIdx.length-1]=this.tableDataSaved[0].length;
        
        Fraction[][] pole = new Fraction[this.tableData.length+1][this.tableData[0].length+1];
        for (int i = 0; i < this.tableDataSaved.length; i++) { //riadky od 0 po predposledny
            for (int j = 0; j < this.tableDataSaved[0].length; j++) { //stlpce od 0 po predposledny
                pole[i][j]=new Fraction(this.tableDataSaved[i][j].getNumerator(), this.tableDataSaved[i][j].getDenominator());
            }
            pole[i][this.tableDataSaved[0].length]=Fraction.ZERO; //posledny stlpec
        }
        for (int j = 0; j < this.tableDataSaved[0].length; j++) { //stlpce od 0 po predposl. v posl. riadku
            pole[this.tableDataSaved.length][j]=new Fraction(this.tableDataSaved[selectedRow][j].intValue());
            pole[this.tableDataSaved.length][j]=pole[this.tableDataSaved.length][j].subtract(pole[selectedRow][j]);
        }
        pole[this.tableDataSaved.length][this.tableDataSaved[0].length]=Fraction.ONE; //posledny
        this.tableData=pole;
        
    }
    
    
    
}


package Cassim2;

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
    
    public boolean onlyOnce = true;

    
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
    
    
    
}
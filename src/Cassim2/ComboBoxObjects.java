package Cassim2;


public class ComboBoxObjects {
    
    private final int column;
    private final String colName;

    public ComboBoxObjects(int column, String colName) {
        this.column = column;
        this.colName = colName;
    }

    public int getColumn() {
        return column;
    }

    public String getColName() {
        return colName;
    }

    @Override
    public String toString() {
        return this.colName;
    }
    
    
}


package Cassim2;


public class Hint {
    
    public int type;
    public int selectedRow;
    public int selectedColumn;
    public String text;

    public Hint() {
    }

    public Hint(int type, int selectedRow, int selectedColumn, String text) {
        this.type = type;
        this.text = text;
        this.selectedRow = selectedRow;
        this.selectedColumn = selectedColumn;
    }
    
    public Hint(int type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public int getType() {
        return type;
    }
    
}

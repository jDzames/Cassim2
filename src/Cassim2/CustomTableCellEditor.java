
package Cassim2;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;


public class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor {
        private TableCellEditor editor;
        private int rows = ValuesSingleton.INSTANCE.data.length;
        private int columns = ValuesSingleton.INSTANCE.columnNames.length;

        @Override
        public Object getCellEditorValue() {
            if (editor != null) {
                return editor.getCellEditorValue();
            }
            return null;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (row==0 && column==columns) {
                JComboBox<String> comboBoxUcel = new JComboBox<String>();
                comboBoxUcel.addItem(" max ");
                comboBoxUcel.addItem(" min ");
                editor = new DefaultCellEditor(comboBoxUcel);
                
                return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
            }
            if (row>=1 && row<rows && column==columns-1) {    
                JComboBox<String> comboBoxsPS = new JComboBox<String>();
                comboBoxsPS.addItem(" = ");
                comboBoxsPS.addItem(" <= ");
                comboBoxsPS.addItem(" >= ");
                editor = new DefaultCellEditor(comboBoxsPS);
                
                return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
            }
                
            if (row==rows && column<=columns-2) {    
                JComboBox<String> comboBoxNezapor = new JComboBox<String>();
                comboBoxNezapor.addItem(" >= ");
                comboBoxNezapor.addItem(" <> ");
                editor = new DefaultCellEditor(comboBoxNezapor);
                
                return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
            }
             else {
                editor = new DefaultCellEditor(new JTextField());
            }

            return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
        }
    }

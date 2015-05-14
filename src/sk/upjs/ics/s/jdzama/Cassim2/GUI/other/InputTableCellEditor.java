
package sk.upjs.ics.s.jdzama.Cassim2.GUI.other;

import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;


public class InputTableCellEditor extends AbstractCellEditor implements TableCellEditor {
        private TableCellEditor editor;
        private int rows = ValuesSingleton.INSTANCE.data.length;
        private int columns = ValuesSingleton.INSTANCE.columnNames.length;
        protected JTextField textField;
        protected int roww;
        protected int coll;

        @Override
        public Object getCellEditorValue() {
            if (editor != null) {
                return editor.getCellEditorValue();
            }
            return null;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            roww = row;
            coll = column;
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
                
                textField = new JTextField();
                
                textField.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                textField.selectAll();
                            }
                        });
                    }
                });
                
                textField.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {}
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyReleased(KeyEvent e) {
                        /*if ( e.getKeyCode() == KeyEvent.VK_MINUS && textField.getText().equals("0") ) {
                            ValuesSingleton.INSTANCE.data[roww][coll+1] = " -";
                            textField.setText(" -");
                        }*/
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (coll==columns) {
                                ValuesSingleton.INSTANCE.data[roww][0] = textField.getText();
                            }else{
                                ValuesSingleton.INSTANCE.data[roww][coll+1] = textField.getText();
                            }
                        }
                    }
                });
                
                editor = new DefaultCellEditor(textField);
            }

            return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
        }
    }

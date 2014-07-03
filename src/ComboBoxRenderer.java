


import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
/*
public class ComboBoxRenderer extends JComboBox<String> implements TableCellRenderer {

        private int minHeight = 5;
        private JComboBox<String> combo = new JComboBox<String>();       
        
        public ComboBoxRenderer() { super(); }


        public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

            Component c = null;
           
            combo.addItem(" = ");            
            combo.addItem(" <= ");
            combo.addItem(" >= ");
            setSelectedItem(ValuesSingleton.INSTANCE.getNezapornost()[column]);
            
            c = combo;

            if (ValuesSingleton.INSTANCE.isOnlyOnce()) {
                    table.setRowHeight(40);
                    ValuesSingleton.INSTANCE.onlyOnce = false;
                }
                /*minHeight = 5;*//*

            System.out.println("som v rendereri a vraciam combo");
            return c;
        }

    }
*/
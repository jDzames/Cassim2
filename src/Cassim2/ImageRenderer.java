
package Cassim2;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class ImageRenderer extends JLabel implements TableCellRenderer {

        private int minHeight = 5;
        private JLabel label = new JLabel();       
        
        public ImageRenderer() { super(); }


        public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

            Component c = null;
            
            TeXIcon icon;
            String latex;
            if (row<1 && column<1) {
                latex = "0";
            } else {
                if (ValuesSingleton.INSTANCE.getTableData()[row][column].getDenominator()==1) {
                    latex = ""+ValuesSingleton.INSTANCE.getTableData()[row][column].getNumerator();
                } else {
                    String sign = "";
                    String numerator = "";
                    if (ValuesSingleton.INSTANCE.getTableData()[row][column].getNumerator()<0) {
                        sign="-";
                        numerator = ""+ValuesSingleton.INSTANCE.getTableData()[row][column].getNumerator()*(-1);
                    } else{
                        numerator = ""+ValuesSingleton.INSTANCE.getTableData()[row][column].getNumerator();
                    }                
                    latex = sign+"\\frac{"+numerator+"}{"
                            +ValuesSingleton.INSTANCE.getTableData()[row][column].getDenominator()+"}";
                    }                
            }
            
            TeXFormula formula = new TeXFormula(latex);
            icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY)
	.setSize(13)
	.setWidth(TeXConstants.UNIT_PIXEL, 256f, TeXConstants.ALIGN_CENTER)
	.setIsMaxWidth(true).setInterLineSpacing(TeXConstants.UNIT_PIXEL, 20f)
	.build();
            
            //ImageIcon icon = (ImageIcon) value;
            minHeight = Math.max(minHeight, icon.getIconHeight()+10);
            label.setIcon(icon);
            c = label;


            if (ValuesSingleton.INSTANCE.isOnlyOnce()) {
                    table.setRowHeight(40);
                    ValuesSingleton.INSTANCE.onlyOnce = false;
                }
                /*minHeight = 5;*/

            System.out.println("som v rendereri a vraciam label");
            return c;
        }

    }

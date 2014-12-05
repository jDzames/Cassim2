

package Cassim2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import org.apache.commons.math3.fraction.Fraction;

public class SolutionFractionCellRenderer extends JPanel implements TableCellRenderer{
   
    private Fraction value;
    
    public Fraction getValue() {
		return value;
	}

	public void setValue(Fraction value) {
		this.value = value;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (value == null) {
			return;
		}

		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

            if (value.getDenominator()==1) {
                // vytvorime stringy s obsahom, ktory ideme zobrazit
		boolean negative = false;
                if (value.getNumerator()<0) {
                    negative = true;
                }

                // vytvorime stringy s obsahom, ktory ideme zobrazit
                String numeratorStr;
                if (negative) {
                    numeratorStr = Long.toString(value.getNumerator()*-1);
                } else{
                    numeratorStr = Long.toString(value.getNumerator());
                }

		// nechame si vypocitat rozmery podla aktualneho fontu
                g2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		FontMetrics fm = g2.getFontMetrics();
		Rectangle2D numeratorBounds = fm.getStringBounds(numeratorStr, g2);
		Rectangle2D spaceBounds = fm.getStringBounds("", g2);
                
		double boxYCenter = getHeight() / 2;
		double fractionXCenter = getWidth()/2 - spaceBounds.getWidth() - numeratorBounds.getWidth() / 2;
               
                if (negative) {
                    g2.draw(new Line2D.Double(fractionXCenter -10, boxYCenter-2,
				fractionXCenter -4 , boxYCenter-2));
                }
                
		g2.drawString(numeratorStr,
				(float) (fractionXCenter),
				(float) (boxYCenter + fm.getDescent()));
		
		g2.dispose();
            } else{
                boolean negative = false;
                if (value.getNumerator()<0) {
                    negative = true;
                }

                // vytvorime stringy s obsahom, ktory ideme zobrazit
                String numeratorStr;
                if (negative) {
                    numeratorStr = Long.toString(value.getNumerator()*-1);
                } else{
                    numeratorStr = Long.toString(value.getNumerator());
                }
		String denominatorStr = Long.toString(value.getDenominator());
                
		// nechame si vypocitat rozmery podla aktualneho fontu
                g2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		FontMetrics fm = g2.getFontMetrics();
		Rectangle2D numeratorBounds = fm.getStringBounds(numeratorStr, g2);
		Rectangle2D denominatorBounds = fm.getStringBounds(denominatorStr, g2);
		Rectangle2D spaceBounds = fm.getStringBounds("", g2);

		double lineWidth = Math.max(numeratorBounds.getWidth(),
				denominatorBounds.getWidth());
		double boxYCenter = getHeight() / 2;
		double fractionNumXCenter = getWidth()/2 - numeratorBounds.getWidth() / 2;
                double fractionDenomXCenter = getWidth()/2 - denominatorBounds.getWidth() / 2;
                double fractionXCenter = getWidth()/2 - spaceBounds.getWidth()
				- lineWidth / 2;
                
		g2.draw(new Line2D.Double(fractionXCenter , boxYCenter,
				fractionXCenter + lineWidth , boxYCenter));
                
                if (negative) {
                    g2.draw(new Line2D.Double(fractionXCenter -10, boxYCenter,
				fractionXCenter -4 , boxYCenter));
                }

		g2.drawString(numeratorStr,
				(float) (fractionNumXCenter ),
				(float) (boxYCenter - fm.getDescent()));
		
		g2.drawString(denominatorStr,
				(float) (fractionDenomXCenter),
				(float) (boxYCenter + denominatorBounds.getHeight() - fm.getDescent()));

		g2.dispose();
            }
		
	}

	public Component getTableCellRendererComponent(JTable table,
			Object cellValue, boolean isSelected, boolean hasFocus, int row,
			int column) {
            
            if (hasFocus) {
                setBackground(new Color(170,170,255));
            } else {
                setBackground(Color.white);
                if (row==0 || column==0) {
                    setBackground(new Color(220,220,220));
                }
            }

            setValue(ValuesSingleton.INSTANCE.tableData[row][column]);
            
            return this;
	}

}

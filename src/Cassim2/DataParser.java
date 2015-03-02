
package Cassim2;

import org.apache.commons.math3.fraction.BigFraction;


public class DataParser {
    
    private BigFraction fraction;
    
    private double number;
    
    private int numerator;
    private int denumerator;
    
    private boolean isFracion_notDouble=false;
    
    public BigFraction parseString(String cell){
                     
        String numer="";
        String denum="";
        StringBuilder working=new StringBuilder();
        isFracion_notDouble = false;
        for (int i = 0; i < cell.length(); i++) {
            switch(cell.charAt(i)){
                case '.': isFracion_notDouble = false;
                    working.append(".");
                    break;
                case ',': isFracion_notDouble = false;
                    working.append(".");
                    break;
                case '/': isFracion_notDouble = true;
                    numer = working.toString();
                    working = new StringBuilder();
                    break;
                case (char)92: isFracion_notDouble = true;
                    numer = working.toString();
                    working = new StringBuilder();
                    break;
                case ':': isFracion_notDouble = true;
                    numer = working.toString();
                    working = new StringBuilder();
                    break;
                case ' ': 
                    break;
                default: working.append(cell.charAt(i));
                     break;    
            }            
        }
        
        if (isFracion_notDouble) {
                denum = working.toString();
                numerator = Integer.parseInt(numer);
                denumerator = Integer.parseInt(denum);
                if (denumerator<0) {
                    denumerator = denumerator*(-1);
                    numerator = numerator*(-1);
                }
                fraction = new BigFraction(numerator, denumerator);
            } else {
                number = Double.parseDouble(working.toString());
                fraction = new BigFraction(number);
            }
            
        return fraction;
    }
    
}

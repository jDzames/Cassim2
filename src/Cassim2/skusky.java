package Cassim2;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.math3.fraction.Fraction;

/**
 *
 * @author jDzama
 */
public class skusky {
    
    public static void main(String args[]) {
        Set<String> mnozina = new HashSet<String>();
        mnozina.add("/");
        mnozina.add(":");
        mnozina.add(String.valueOf((char)92));
        String co = "4:4"+String.valueOf((char)92)+"4/l";
        if (mnozina.contains(String.valueOf(co.charAt(5)))) {
            System.out.println("obsahuje " +co.charAt(5));
        }
        
        
        
        Fraction fract = new Fraction(Double.parseDouble("0.2"));
        System.out.println(fract.toString());
        
        Fraction f = new Fraction(0);
        System.out.println(f.toString());
    }
    
}

package Cassim2;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.xml.stream.events.Characters;
import org.apache.commons.math3.fraction.Fraction;

/**
 *
 * @author jDzama
 */
public class skusky {
    
    public static void main(String args[]) {
        /*Set<String> mnozina = new HashSet<String>();
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
        
        Fraction a = new Fraction(1,-3);
        System.out.println(a.getDenominator());
        
        
        System.out.println(""+'a');
        
        System.out.println(" "+(char) 65);*/
        
        BlockingQueue<String[]> q = new LinkedBlockingQueue<>();
        SavingWriterThread vlakno = new SavingWriterThread();
        
        String[] s = {"jeden"};
        ValuesSingleton.INSTANCE.putToSavingQueue(s);
        String[] ss = {"POISON_PILL"};
        vlakno.run();
        System.out.println("za runom");
        ValuesSingleton.INSTANCE.putToSavingQueue(ss);
        
        System.out.println("konec");
    }
    
    
    
}

package sk.upjs.ics.s.jdzama.Cassim2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.xml.stream.events.Characters;
import org.apache.commons.math3.fraction.BigFraction;
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
        
        Fraction f = new Fraction(-5,3);
        System.out.println(f.toString());
        
        f.multiply(Fraction.MINUS_ONE);
        System.out.println(f.toString());
        
        
        System.out.println(""+'a');
        
        System.out.println(" "+(char) 65);*/
        
        /*BlockingQueue<String[]> q = new LinkedBlockingQueue<>();
        SavingWriterThread vlakno = new SavingWriterThread();
        
        String[] s = {"jeden"};
        ValuesSingleton.INSTANCE.putToSavingQueue(s);
        String[] ss = {"POISON_PILL"};
        vlakno.run();
        System.out.println("za runom");
        ValuesSingleton.INSTANCE.putToSavingQueue(ss);
        vlakno.run();
        vlakno.append();
        System.out.println("konec");*/
/*
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        int[][] ab = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ab[i][j]=i*j;
                System.out.print(i*j+" ");
            }
            System.out.println("");
        }
        ab[0]=b;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ab[i][j]+" ");
            }
            System.out.println("");
        }
    
    */
        
        Fraction f = new Fraction(-5,3);
        System.out.println(f.toString());
        
        f.reciprocal();
        System.out.println(f.reciprocal());
    }
}

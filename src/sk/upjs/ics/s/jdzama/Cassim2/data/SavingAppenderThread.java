
package sk.upjs.ics.s.jdzama.Cassim2.data;

import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import sk.upjs.ics.s.jdzama.Cassim2.exceptions.FileWritingException;


public class SavingAppenderThread implements Runnable{

    private FileWriter wr;
    private BufferedWriter bufferWritter;
    private final Stack<String> stack;

    public SavingAppenderThread(Stack<String> stack) {
        this.stack = stack;
    }
    
    @Override
    public void run() {
        try {
            File subor = ValuesSingleton.INSTANCE.file;
            wr = new FileWriter(subor, true);
            bufferWritter = new BufferedWriter(wr);
            
            bufferWritter.write(stack.size()+";");
            bufferWritter.newLine();
            bufferWritter.flush();
            
            System.out.println(stack.toString());
            int number = stack.size();
            for(int i = 0; i < number;  i++) {
                String row = stack.pop();
                
                if (row==null) {
                    bufferWritter.close();
                    return;
                }
                
                //zapisanie do suboru
                bufferWritter.write(row+";");
                bufferWritter.newLine();
                bufferWritter.flush();
                
            }
        } catch (FileNotFoundException ex) {
            throw new FileWritingException("Nenájdený súbor.");    
        } catch (IOException ex) {
            throw new FileWritingException("Problém so súborom/zápisom.");    
        } catch(Exception ex){
            System.out.println("Zapisane.");
        } finally{
            if (bufferWritter!=null) {
                try {
                    bufferWritter.close();
                } catch (IOException ex) {
                    throw new FileWritingException("Problém so zavrením súboru.");  
                }
            }
        }
    }
    
}

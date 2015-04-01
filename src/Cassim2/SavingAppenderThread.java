
package Cassim2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;


public class SavingAppenderThread implements Runnable{

    private FileWriter wr;
    private BufferedWriter bufferWritter;
    private final Stack<String> stack;

    public SavingAppenderThread(Stack<String> undoStack) {
        this.stack = undoStack;
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
            
            for(int i = 0; i < stack.size();  i++) {
                String row = stack.get(i);
                
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

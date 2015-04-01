
package Cassim2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class SavingAppenderThread implements Runnable{

    private FileWriter wr;
    private BufferedWriter bufferWritter;
    
    @Override
    public void run() {
        try {
            File subor = ValuesSingleton.INSTANCE.file;
            wr = new FileWriter(subor, true);
            bufferWritter = new BufferedWriter(wr);
            while(true) {
                String[] row = ValuesSingleton.INSTANCE.takeFromSavingQueue();
                if (row==null) {
                    bufferWritter.close();
                    return;
                }
                if (row.length==1 && row[0].equals("POISON_PILL")){
                    System.out.println("Dopisane, konci vlakno.");
                    bufferWritter.close();
                    return;
                }
                //zapisanie do suboru
                for (int i = 0; i < row.length; i++) {
                    String string = row[i];
                    bufferWritter.write(string+";");
                }
                bufferWritter.newLine();
                bufferWritter.flush();
            }
        } catch (FileNotFoundException ex) {
            throw new FileWritingException("Nenájdený súbor.");    
        } catch (IOException ex) {
            throw new FileWritingException("Problém so súborom/zápisom.");    
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

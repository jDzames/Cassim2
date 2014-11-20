

import Cassim2.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SavingWriterThread implements Runnable{

    private PrintWriter wr;
    //private BlockingQueue<String[]> q;

    /*public SavingWriterThread(BlockingQueue<String[]> q) {
        this.q = q;
    }*/
    
    @Override
    public void run() {
        try {
            File subor = new File("tmp_posledneRiesenie.csv");
            wr = new PrintWriter(subor);
            //while(true) {
                System.out.println("tu som");
                String[] row = ValuesSingleton.INSTANCE.takeFromSavingQueue();
                if (row==null) {
                    //continue;
                }
                if (row.length==1 && row[0].equals("POISON_PILL")){
                    System.out.println("closeujem");
                    wr.close();
                    //http://stackoverflow.com/questions/1158777/renaming-a-file-using-java
                    //http://www.mkyong.com/java/how-to-append-content-to-file-in-java/
                    //break;
                    return;
                }
                //zapisanie do suboru
                System.out.println("takeol som");
                for (int i = 0; i < row.length-1; i++) {
                    String string = row[i];
                    wr.print(string+",");
                }
                wr.println(row[row.length-1]);
                wr.flush();
                System.out.println("zapisal som");
            //}
        } catch (FileNotFoundException ex) {
            throw new FileWritingException("Nenájdený súbor.");    
        } finally{
            if (wr!=null) {
                wr.close();
            }
        }
        
    }
    
    
    
}

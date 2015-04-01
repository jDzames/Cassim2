package Cassim2;


import Cassim2.Commands.Command;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import org.apache.commons.math3.fraction.BigFraction;


public class SavedSolutionReader {
    
    private BufferedReader bufReader;
    
    protected void readForEdit(File file) throws FileWritingException{
        try {            
            FileReader reader = new FileReader(file);
            bufReader = new BufferedReader(reader);
            
            String s = bufReader.readLine();
            String[] stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.rows = Integer.parseInt(stringsArray[0])-4;
            ValuesSingleton.INSTANCE.columns = Integer.parseInt(stringsArray[1])-1;
            
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.columnNames = stringsArray;
            
            String[][] data = new String [ValuesSingleton.INSTANCE.rows+1][ValuesSingleton.INSTANCE.columns+1];
            for (int i = 0; i < ValuesSingleton.INSTANCE.rows+1; i++) {
                s = bufReader.readLine();
                stringsArray = s.split(";");
                data[i] = stringsArray;
            }
            ValuesSingleton.INSTANCE.data = data;
            
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.porovnaniasPS = stringsArray;
            
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.nezapornost = stringsArray;
            
        } catch (FileNotFoundException ex) {
            throw new FileWritingException("Nenájdený súbor!");
        } catch (IOException exx) {
            throw new FileWritingException("Problém s čítaním, pravdepodobne zle formátovaný súbor!");
        } catch (NumberFormatException exxx){
            throw new FileWritingException("Zle formátovaný alebo poškodený súbor!");
        } catch(Exception exxxx){
            throw new FileWritingException("Netypická chyba pri čítaní súboru");
        } finally{
            if (bufReader!=null) {
                try {
                    bufReader.close();
                } catch (IOException ex) {
                    throw new FileWritingException("Problém so zatvorením súboru súboru");
                }
            }
        }        
    }

    protected void readForSolution(File file, Stack<Command> redoStack) {
        try {
            FileReader reader = new FileReader(file);
            bufReader = new BufferedReader(reader);
            
            String s = bufReader.readLine();
            String[] stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.rows = Integer.parseInt(stringsArray[0])-4;
            ValuesSingleton.INSTANCE.columns = Integer.parseInt(stringsArray[1])-1;
            
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.columnNamesSaved = stringsArray;
            
            String[][] data = new String [ValuesSingleton.INSTANCE.rows+1][ValuesSingleton.INSTANCE.columns+1];
            for (int i = 0; i < ValuesSingleton.INSTANCE.rows+1; i++) {
                s = bufReader.readLine();
                stringsArray = s.split(";");
                data[i] = stringsArray;
            }
            ValuesSingleton.INSTANCE.data = data;
            
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.porovnaniasPS = stringsArray;
            
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.nezapornost = stringsArray;
            
            //fractions
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.rows = Integer.parseInt(stringsArray[0])-1;
            ValuesSingleton.INSTANCE.columns = Integer.parseInt(stringsArray[1])-1;
            
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.columnNames = stringsArray;
            
            BigFraction[][] tData = new BigFraction [ValuesSingleton.INSTANCE.rows+1][ValuesSingleton.INSTANCE.columns+1];
            for (int i = 0; i < ValuesSingleton.INSTANCE.rows+1; i++) {
                s = bufReader.readLine();
                stringsArray = s.split(";");
                for (int j = 0; j < ValuesSingleton.INSTANCE.columns+1; j++) {
                    String[] oneBigFraction = stringsArray[j].split(":");
                    BigFraction fr = new BigFraction(Integer.parseInt(oneBigFraction[0]), Integer.parseInt(oneBigFraction[1]));
                    tData[i][j] = fr;
                }
            }
            ValuesSingleton.INSTANCE.tableData = tData;
            
            //history
            
            int number = bufReader.read();
            for (int i = 0; i < number; i++) {
                Command command = null;

                int nextType = bufReader.read();
                
                
                redoStack.push(command);
            }


        } catch (FileNotFoundException ex) {
            throw new FileWritingException("Nenájdený súbor!");
        } catch (IOException exx) {
            throw new FileWritingException("Problém s čítaním, pravdepodobne zle formátovaný súbor!");
        } catch (NumberFormatException exxx){
            throw new FileWritingException("Zle formátovaný alebo poškodený súbor!");
        } catch (NullPointerException exxxx){
            throw new FileWritingException("Zle formátovaný alebo poškodený súbor!");
        }catch(Exception exxxxx){
            throw new FileWritingException("Netypická chyba pri čítaní súboru");
        } finally{
            if (bufReader!=null) {
                try {
                    bufReader.close();
                } catch (IOException ex) {
                    throw new FileWritingException("Problém so zatvorením súboru súboru");
                }
            }
        }
    }
}

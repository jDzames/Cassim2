

package Cassim2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.math3.fraction.Fraction;


public class SavedSolutionReader {
    
    BufferedReader bufReader;
    
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

    protected void readForSolution(File file) {
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
            
            //fractions
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.rows = Integer.parseInt(stringsArray[0])-1;
            ValuesSingleton.INSTANCE.columns = Integer.parseInt(stringsArray[1])-1;
            
            s = bufReader.readLine();
            stringsArray = s.split(";");
            ValuesSingleton.INSTANCE.columnNames = stringsArray;
            
            Fraction[][] tData = new Fraction [ValuesSingleton.INSTANCE.rows+1][ValuesSingleton.INSTANCE.columns+1];
            for (int i = 0; i < ValuesSingleton.INSTANCE.rows+1; i++) {
                s = bufReader.readLine();
                stringsArray = s.split(";");
                for (int j = 0; j < ValuesSingleton.INSTANCE.columns+1; j++) {
                    String[] oneFraction = stringsArray[j].split(":");
                    Fraction fr = new Fraction(Integer.parseInt(oneFraction[0]), Integer.parseInt(oneFraction[1]));
                    tData[i][j] = fr;
                }
            }
            ValuesSingleton.INSTANCE.tableData = tData;
            
            //history
            
            
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

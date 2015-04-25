package Cassim2;


import Cassim2.Commands.Command;
import Cassim2.Commands.CommandChangeFunction;
import Cassim2.Commands.CommandDeleteRow;
import Cassim2.Commands.CommandEndSuppRoleNotOpt;
import Cassim2.Commands.CommandEndSuppRoleOpt;
import Cassim2.Commands.CommandGomory;
import Cassim2.Commands.CommandMakeBasis;
import Cassim2.Commands.CommandMultiplyRow;
import Cassim2.Commands.CommandPivot;
import Cassim2.Commands.CommandRevidedStart;
import Cassim2.Commands.CommandRevidedStop;
import Cassim2.Commands.CommandStartSuppRole;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
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
            String lineStart = bufReader.readLine();
            if (lineStart == null || lineStart.length() == 0) {
                return;
            }
            int number = Integer.parseInt(lineStart.split(";")[0]);
            
            for (int i = 0; i < number; i++) {
                Command command = null;
                String[] line = bufReader.readLine().split(";");
                int nextType = Integer.parseInt(line[0]);
                
                switch(nextType){
                    case 1: command = new CommandMakeBasis();
                        break;
                    case 2: command = new CommandGomory(Integer.parseInt(line[1]));
                        break;    
                    case 3: command = new CommandPivot(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                        break;
                    case 4: command = new CommandStartSuppRole();
                        break;    
                    case 5: command = new CommandEndSuppRoleOpt();
                        break;    
                    case 6: command = new CommandEndSuppRoleNotOpt();
                        break;    
                    case 7: command = new CommandMultiplyRow(Integer.parseInt(line[1]), 
                            new BigFraction(Integer.parseInt(line[2]), Integer.parseInt(line[3])));
                        break;
                    case 8: command = new CommandDeleteRow(Integer.parseInt(line[1]));
                        break;
                    case 9: command = new CommandRevidedStop();
                        break;
                    case 10: command = new CommandRevidedStart();
                        break;
                    case 11: BigFraction[] row = new BigFraction[(line.length-1)/2];
                        for (int j = 0; j < row.length; j++) {
                            row[j] = new BigFraction(Integer.parseInt(line[2*j+1]), Integer.parseInt(line[2*j+2]));
                        }
                        command = new CommandChangeFunction(row);
                        break;    
                    default: break;    
                }
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

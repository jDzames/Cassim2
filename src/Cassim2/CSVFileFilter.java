
package Cassim2;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class CSVFileFilter extends FileFilter  
{  
   public boolean accept(File f)  
   {  
      if (f==null) {
          return false;
      }
      if (f.isDirectory()) { 
         return true;  
      }  
       
      String name = f.getName();  
      
      return name.endsWith("*.csv");  
   }  

    @Override
    public String getDescription() {
        return "*.csv";
    }
}

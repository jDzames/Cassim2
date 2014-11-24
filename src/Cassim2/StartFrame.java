
package Cassim2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class StartFrame extends javax.swing.JFrame {

    private boolean solutionIsReady;
    private SavedSolutionReader reader;
    
    public StartFrame() {
        initComponents();
        this.setTitle("Cassim 2");
        solutionIsReady = false;
        reader = new SavedSolutionReader();
        this.options = new String[]{"Áno", "Nie"};
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtColumns = new javax.swing.JTextField();
        txtRows = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCreateTable = new javax.swing.JButton();
        btnStartSolution = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chckBoxOpenSolution = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("stĺpcov:");

        jLabel2.setText("riadkov:");

        btnCreateTable.setText("Vytvor tabuľku");
        btnCreateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTableActionPerformed(evt);
            }
        });

        btnStartSolution.setText("Otvor výpočet");
        btnStartSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartSolutionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 90)); // NOI18N
        jLabel3.setText("Cassim 2");

        jLabel4.setText("Prosím o ohlásenie akýchkoľvek chýb na jozef.dzama@gmail.com");

        chckBoxOpenSolution.setText("Otvor uloženú úlohu");
        chckBoxOpenSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckBoxOpenSolutionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(0, 132, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRows, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtColumns, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnCreateTable)
                .addGap(41, 41, 41)
                .addComponent(btnStartSolution)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chckBoxOpenSolution)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartSolution)
                    .addComponent(jLabel2)
                    .addComponent(txtRows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateTable)
                    .addComponent(txtColumns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chckBoxOpenSolution)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTableActionPerformed
        
        if (chckBoxOpenSolution.isSelected()) {
            
            JFileChooser chooser = new JFileChooser();
            chooser.setToolTipText("Zadajte názov alebo vyberte súbor typu csv");
            chooser.setVisible(true);
            /*FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".csv", "csv");*/
            chooser.setFileFilter(new CSVFileFilter());
            int returnVal = chooser.showOpenDialog(this);
            
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(this, "Vyberte *.csv súbor (s uloženou úlohou LP)!", "Chyba", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //otvorit a nacitat data
                try {
                    reader.readForEdit(file);
                } catch (FileWritingException ex) {
                    JOptionPane.showMessageDialog(this, "Problém pri načítaní súboru: "+ex.sprava, "Chyba", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("Otvoril som file: "+file.getName());
            } else {
                //JOptionPane.showMessageDialog(this, "Vyberte *.csv súbor (s uloženou úlohou LP)!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            }    
            
        } else {
            
            try {
                ValuesSingleton.INSTANCE.columns = Integer.parseInt(txtColumns.getText());
                ValuesSingleton.INSTANCE.rows = Integer.parseInt(txtRows.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Počet riadkov a stĺpcov musia byť celé kladné čísla!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            }


            String[][] data = new String [ValuesSingleton.INSTANCE.rows+1][ValuesSingleton.INSTANCE.columns+1];
            for (int i = 0; i <= ValuesSingleton.INSTANCE.rows; i++) {
                for (int j = 0; j <= ValuesSingleton.INSTANCE.columns; j++) {
                    data[i][j]="0";
                }
            }
            ValuesSingleton.INSTANCE.data = data;  

            String[] porovnania = new String [ValuesSingleton.INSTANCE.rows];
            for (int i = 0; i < ValuesSingleton.INSTANCE.rows; i++) {
                porovnania[i] = " = ";
            }
            ValuesSingleton.INSTANCE.porovnaniasPS = porovnania;

            String[] nezapornost = new String[ValuesSingleton.INSTANCE.columns];        
            String[] columnNames = new String[ValuesSingleton.INSTANCE.columns+1];
            for (int i = 0; i < ValuesSingleton.INSTANCE.columns; i++) {
                columnNames[i]="x"+i;
                nezapornost[i]=" >= ";
            }
            columnNames[ValuesSingleton.INSTANCE.columns]="x"+ValuesSingleton.INSTANCE.columns;
            ValuesSingleton.INSTANCE.columnNames = columnNames; //new String [ValuesSingleton.INSTANCE.columns]; 
            ValuesSingleton.INSTANCE.nezapornost = nezapornost;
        }
        
        InputTableDialog inputTableDialog = new InputTableDialog(this, rootPaneCheckingEnabled);
        inputTableDialog.setVisible(true);
        
        solutionIsReady = true;
    }//GEN-LAST:event_btnCreateTableActionPerformed

    private void btnStartSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartSolutionActionPerformed
       
        if (chckBoxOpenSolution.isSelected()) {
            
            JFileChooser chooser = new JFileChooser();
            chooser.setToolTipText("Zadajte názov alebo vyberte súbor typu csv");
            chooser.setVisible(true);
            /*FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".csv", "csv");*/
            chooser.setFileFilter(new CSVFileFilter());
            int returnVal = chooser.showOpenDialog(this);
            
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(this, "Vyberte *.csv súbor (s uloženou úlohou LP)!", "Chyba", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //otvorit a nacitat data
                try {
                    reader.readForSolution(file);
                } catch (FileWritingException ex) {
                    JOptionPane.showMessageDialog(this, "Problém pri načítaní súboru: "+ex.sprava, "Chyba", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("Otvoril som file: "+file.getName());
            } else {
                //JOptionPane.showMessageDialog(this, "Vyberte *.csv súbor (s uloženou úlohou LP)!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            }    
            
        } else {
            
            if (!solutionIsReady) {
                JOptionPane.showMessageDialog(this, "Najprv zadajte vstup!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            ValuesSingleton.INSTANCE.onlyOnce = true; 

            ValuesSingleton.INSTANCE.rows = ValuesSingleton.INSTANCE.tableData.length-1;
            ValuesSingleton.INSTANCE.columns = ValuesSingleton.INSTANCE.tableData[0].length-1;
            if (ValuesSingleton.INSTANCE.columnNames.length!=ValuesSingleton.INSTANCE.columns+1) {
                String[] columnNames = new String[ValuesSingleton.INSTANCE.columns+1];
                for (int i = 0; i < ValuesSingleton.INSTANCE.columns; i++) {
                    columnNames[i]="x"+i;
                }
                ValuesSingleton.INSTANCE.columnNames = columnNames;
            }

        }
        
        SolutionDialog solutionDialog = new SolutionDialog(this, rootPaneCheckingEnabled);
        solutionDialog.setVisible(true); 
        
    }//GEN-LAST:event_btnStartSolutionActionPerformed

    private void chckBoxOpenSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckBoxOpenSolutionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckBoxOpenSolutionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    private final String[] options;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateTable;
    private javax.swing.JButton btnStartSolution;
    private javax.swing.JCheckBox chckBoxOpenSolution;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtColumns;
    private javax.swing.JTextField txtRows;
    // End of variables declaration//GEN-END:variables
}



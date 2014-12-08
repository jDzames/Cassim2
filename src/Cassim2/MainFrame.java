package Cassim2;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import org.apache.commons.math3.fraction.Fraction;


public class MainFrame  extends javax.swing.JFrame {

    private ImageTableModel imageTableModel = new ImageTableModel();
    private BasisTableModel basisTableModel = new BasisTableModel();
    private final SavedSolutionReader reader = new SavedSolutionReader();
    private final SolutionCalcService solutionCalculations = new SolutionCalcService();
    private int pocetPomPremennych;
    private boolean isLoaded;
    

    public MainFrame() {
        //super(parent, modal);
        this.options = new String[]{"Áno", "Nie"};
        this.setTitle("Cassim 2");
        
        initComponents();
        
        //jScrollPane1.setVisible(false);
        //jScrollPane2.setVisible(false);
        closeSolution();
        
    }
    
    public void openOffer(){
        StartingOfferDialog startDialog = new StartingOfferDialog(this, true);
        startDialog.setVisible(true);
        int result = startDialog.getResult();
        
        switch (result) {
            case 1:  this.jMenuItemOpenNewActionPerformed(null);
                     return;
            case 2:  this.jMenuItemOpenSavedInputActionPerformed(null);
                     return;
            case 3:  this.jMenuItemOpenSavedSolutionActionPerformed(null);
                     return;    
            default: return;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolution = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBaza = new javax.swing.JTable();
        btnKoniecPomUlohy = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpenNew = new javax.swing.JMenuItem();
        jMenuItemOpenSavedInput = new javax.swing.JMenuItem();
        jMenuItemOpenSavedSolution = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuTable = new javax.swing.JMenu();
        jMenuItemRevided = new javax.swing.JMenuItem();
        jMenuItemGomory = new javax.swing.JMenuItem();
        jMenuItemPomocnaUloha = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemMakeBasis = new javax.swing.JMenuItem();
        jMenuItemPivot = new javax.swing.JMenuItem();
        jMenuItemMin = new javax.swing.JMenuItem();
        jMenuItemMax = new javax.swing.JMenuItem();
        jMenuPomocneOperacie = new javax.swing.JMenu();
        jMenuItemPrenasobRiadok = new javax.swing.JMenuItem();
        jMenuHistory = new javax.swing.JMenu();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jMenuItemAboutAuthors = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblSolution.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSolution.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tblSolution);
        tblSolution.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        tblBaza.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        tblBaza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBaza.setFocusable(false);
        tblBaza.setRowHeight(45);
        tblBaza.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(tblBaza);

        btnKoniecPomUlohy.setText("Ukončiť pomocnú úlohu");
        btnKoniecPomUlohy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoniecPomUlohyActionPerformed(evt);
            }
        });

        jMenuFile.setText("Úloha ");

        jMenuItemOpenNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpenNew.setText("Začni novú úlohu");
        jMenuItemOpenNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenNew);

        jMenuItemOpenSavedInput.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpenSavedInput.setText("Otvor uložené zadanie");
        jMenuItemOpenSavedInput.setToolTipText("Načíta uložené zadanie na upravovanie");
        jMenuItemOpenSavedInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenSavedInputActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenSavedInput);

        jMenuItemOpenSavedSolution.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpenSavedSolution.setText("Otvor uloženú úlohu");
        jMenuItemOpenSavedSolution.setToolTipText("Načíta riešenie úlohy (aj s históriou) a možno pokračovať");
        jMenuItemOpenSavedSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenSavedSolutionActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenSavedSolution);

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setText("Uložiť ako");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemExit.setText("Ukončiť program");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar.add(jMenuFile);

        jMenuTable.setText("Tabuľka");

        jMenuItemRevided.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRevided.setText("Revidovaná úloha");
        jMenuTable.add(jMenuItemRevided);

        jMenuItemGomory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGomory.setText("Gomoryho rez");
        jMenuItemGomory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGomoryActionPerformed(evt);
            }
        });
        jMenuTable.add(jMenuItemGomory);

        jMenuItemPomocnaUloha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPomocnaUloha.setText("Riešiť pomocnú úlohu");
        jMenuItemPomocnaUloha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPomocnaUlohaActionPerformed(evt);
            }
        });
        jMenuTable.add(jMenuItemPomocnaUloha);

        jMenuBar.add(jMenuTable);

        jMenuEdit.setText("Prepočty");

        jMenuItemMakeBasis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, 0));
        jMenuItemMakeBasis.setText("Bázuj");
        jMenuItemMakeBasis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMakeBasisActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemMakeBasis);

        jMenuItemPivot.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        jMenuItemPivot.setText("Pivotuj");
        jMenuItemPivot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPivotActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemPivot);

        jMenuItemMin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, 0));
        jMenuItemMin.setText("Minimum");
        jMenuItemMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMinActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemMin);

        jMenuItemMax.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, 0));
        jMenuItemMax.setText("Maximum");
        jMenuItemMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMaxActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemMax);

        jMenuBar.add(jMenuEdit);

        jMenuPomocneOperacie.setText("Pomocné operácie");

        jMenuItemPrenasobRiadok.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, 0));
        jMenuItemPrenasobRiadok.setText("Prenásob riadok");
        jMenuItemPrenasobRiadok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrenasobRiadokActionPerformed(evt);
            }
        });
        jMenuPomocneOperacie.add(jMenuItemPrenasobRiadok);

        jMenuBar.add(jMenuPomocneOperacie);

        jMenuHistory.setText("História");
        jMenuHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHistoryActionPerformed(evt);
            }
        });
        jMenuBar.add(jMenuHistory);

        jMenuHelp.setText("Pomocník");

        jMenuItemHelp.setText("Pomocník");
        jMenuHelp.add(jMenuItemHelp);

        jMenuItemAboutAuthors.setText("Autori");
        jMenuHelp.add(jMenuItemAboutAuthors);

        jMenuBar.add(jMenuHelp);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKoniecPomUlohy)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnKoniecPomUlohy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void closeSolution(){
        tblSolution.setVisible(false);
        tblBaza.setVisible(false);
        
        jMenuHistory.setEnabled(false);
        jMenuEdit.setEnabled(false);
        jMenuPomocneOperacie.setEnabled(false);
        jMenuTable.setEnabled(false);
        jMenuItemSave.setEnabled(false);
        
        btnKoniecPomUlohy.setVisible(false);
    }
    
    private void initSolution(){
        //pustim ked prvy raz sa zjavia tabulky
        tblBaza = new JTable();
        tblSolution = new JTable();
        
        tblBaza.setRowHeight(44);
        tblSolution.setRowHeight(44);
        tblSolution.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

        JTableHeader header = tblSolution.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer(tblSolution));
        JTableHeader header2 = tblBaza.getTableHeader();
        header2.setDefaultRenderer(new HeaderRenderer(tblBaza));

        tblBaza.setVisible(true);
        tblSolution.setVisible(true);
        jMenuItemSave.setEnabled(true);
        
        tblSolution.setDefaultRenderer(JLabel.class, new SolutionFractionCellRenderer()); 
        tblBaza.setDefaultRenderer(JLabel.class, new BasisRenderer(tblBaza));
        tblBaza.setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        jMenuHistory.setEnabled(true);
        jMenuEdit.setEnabled(true);
        jMenuPomocneOperacie.setEnabled(true);
        jMenuTable.setEnabled(true);
        jMenuItemSave.setEnabled(true);
        
        int[] pole = new int[ValuesSingleton.INSTANCE.rows];
        for (int i = 0; i < pole.length; i++) {
            pole[i]=-1;          
        }
        ValuesSingleton.INSTANCE.basisDataIdx = pole;
        this.pocetPomPremennych=ValuesSingleton.INSTANCE.suppRoleVariables;
        
        if (ValuesSingleton.INSTANCE.columnNames.length>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        solutionCalculations.findBasis();
        
        tblSolution.setModel(imageTableModel);
        tblSolution.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tblSolution);
        tblSolution.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        tblBaza.setModel(basisTableModel);
        tblBaza.setFocusable(false);
        tblBaza.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(tblBaza);
    }
    
    private void saveTables() {
        String[] size = {""+(ValuesSingleton.INSTANCE.data.length+3),""+ValuesSingleton.INSTANCE.data[0].length};
        ValuesSingleton.INSTANCE.putToSavingQueue(size);
        String[] colNames = new String[ValuesSingleton.INSTANCE.data[0].length];
        System.arraycopy(ValuesSingleton.INSTANCE.columnNames, 0, colNames, 0, ValuesSingleton.INSTANCE.data[0].length);
        ValuesSingleton.INSTANCE.putToSavingQueue(colNames);
        for (int i = 0; i < ValuesSingleton.INSTANCE.data.length; i++) {
            ValuesSingleton.INSTANCE.putToSavingQueue(ValuesSingleton.INSTANCE.data[i]);
        }
        ValuesSingleton.INSTANCE.putToSavingQueue(ValuesSingleton.INSTANCE.porovnaniasPS);
        ValuesSingleton.INSTANCE.putToSavingQueue(ValuesSingleton.INSTANCE.nezapornost);
        String[] size2 = {""+(ValuesSingleton.INSTANCE.rows+1),""+(ValuesSingleton.INSTANCE.columns+1)};
        ValuesSingleton.INSTANCE.putToSavingQueue(size2);
        ValuesSingleton.INSTANCE.putToSavingQueue(ValuesSingleton.INSTANCE.columnNames);
        for (int i = 0; i < ValuesSingleton.INSTANCE.rows+1; i++) {
            String[] frac = new String[ValuesSingleton.INSTANCE.columns+1];
            for (int j = 0; j < ValuesSingleton.INSTANCE.columns+1; j++) {
                String string = ValuesSingleton.INSTANCE.tableData[i][j].getNumerator()+":"+ValuesSingleton.INSTANCE.tableData[i][j].getDenominator();
                frac[j] =string;
            }
            ValuesSingleton.INSTANCE.putToSavingQueue(frac);
        }
        String[] end = {"POISON_PILL"};
        ValuesSingleton.INSTANCE.putToSavingQueue(end);
        SavingWriterThread saver = new SavingWriterThread();
        try {
            saver.run();
        } catch (FileWritingException e) {
            JOptionPane.showMessageDialog(this, "Chyba pri ukladaní vstupu! -> "+e.sprava, "Chyba", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setToolTipText("Zadajte názov alebo vyberte súbor typu csv");
        chooser.setVisible(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            ".csv", "csv");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Save");
        chooser.setApproveButtonText("Select");
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file.getAbsolutePath().equals(ValuesSingleton.INSTANCE.file.getAbsolutePath())) {
                JOptionPane.showMessageDialog(this, "Tu už je tento súbor uložený.", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            String s = file.getName();
            int position = s.indexOf('.');
            if (position < s.length()&&position>=0) {
                s = s.substring(0, position);
            }
            //s.sub
            String filePath = file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf(File.separator));
            file = new File(filePath+File.separator+s+".csv");
            System.out.println(file.getAbsolutePath());
            Path newdir = Paths.get(filePath);
            Path source = ValuesSingleton.INSTANCE.file.toPath();
            try {
                Files.move(source, newdir.resolve(file.getName()), REPLACE_EXISTING);
                ValuesSingleton.INSTANCE.file = new File(filePath+File.separator+s+".csv");
            } catch (IOException ex) {
                ValuesSingleton.INSTANCE.resetSavingQueue();
                JOptionPane.showMessageDialog(this, "Chyba pri ukladaní vstupu. Skuste súbor nazvať inak (lebo takýto súbor už pravdepodobne existuje) alebo súbor vytvorte inde (kvôli chýbajúcim právam).", "Chyba", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemMakeBasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMakeBasisActionPerformed
        solutionCalculations.makeZeroOverBasis();
        //tblSolution.repaint();
        //tblBaza.repaint();
        imageTableModel.fireTableDataChanged();
        SavingWriterThread saver = new SavingWriterThread();
        
            String[] row = {"0"};
            ValuesSingleton.INSTANCE.putToSavingQueue(row);
            String[] end = {"POISON_PILL"};
            ValuesSingleton.INSTANCE.putToSavingQueue(end);
            saver.append();
    }//GEN-LAST:event_jMenuItemMakeBasisActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemGomoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGomoryActionPerformed
        int selectedRow = tblSolution.getSelectedRow();
        if (selectedRow<=0) {
            JOptionPane.showMessageDialog(this, "Vyberte vhodný riadok!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        if (!(solutionCalculations.isBased() && solutionCalculations.have0overBasis())) {
            JOptionPane.showMessageDialog(this, "Tabuľka musí byť najprv bázovaná!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;            
        }  //ci napr po pom ulohe dal bazovat a vynuloval nad bazou
        
        int checkedGomory = solutionCalculations.checkGomory(tblSolution.getSelectedRow(), tblSolution.getSelectedColumn());
        //tu zisti ci napr mame bazu
        
        switch(checkedGomory){
            case -1: JOptionPane.showMessageDialog(this, "Ste v neprípustnom riešení!", "Riešenie", JOptionPane.PLAIN_MESSAGE);
                    return;
            case -2: JOptionPane.showMessageDialog(this, "Najprv musí mať tabuľka bázu!", "Chyba", JOptionPane.ERROR_MESSAGE);
                    return;
            case -3: JOptionPane.showMessageDialog(this, "Nemá zmysel použit Gomoryo rez na tomto riadku!", "Nevhodné použitie", JOptionPane.PLAIN_MESSAGE);
                    return;    
            case -4: /*int potvrdenie = JOptionPane.showOptionDialog(this, "Lineárna optimalizácia ešte nie je ukončena. Naozaj chcete teraz použiť Gomoryho rez?",
                    "Varovanie", 0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                    if (potvrdenie != JOptionPane.YES_OPTION) {
                        return;
                    }*/
                    JOptionPane.showMessageDialog(this, "Ešte nie je optimum!", "Nevhodné použitie", JOptionPane.PLAIN_MESSAGE);
                    return;
            default: ValuesSingleton.INSTANCE.doGomory(tblSolution.getSelectedRow());
                    imageTableModel = new ImageTableModel();
                    tblSolution.setModel(imageTableModel);
                    basisTableModel = new BasisTableModel();
                    tblBaza.setModel(basisTableModel);
                    SavingWriterThread saver = new SavingWriterThread();
                    
                        String[] row = {"5",""+selectedRow};
                        ValuesSingleton.INSTANCE.putToSavingQueue(row);
                        String[] end = {"POISON_PILL"};
                        ValuesSingleton.INSTANCE.putToSavingQueue(end);
                        saver.append();
                    
        }
    }//GEN-LAST:event_jMenuItemGomoryActionPerformed

    private void jMenuItemMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMinActionPerformed
        int checkedMin = solutionCalculations.checkMin(tblSolution.getSelectedRow(), tblSolution.getSelectedColumn());

        switch(checkedMin){
            case -4: JOptionPane.showMessageDialog(this, "Vyberte bunku kde je možné pivotovať!", "Chyba", JOptionPane.ERROR_MESSAGE);
                    return;
            case -3: JOptionPane.showMessageDialog(this, "Ste v neprípustnom riešení!", "Riešenie", JOptionPane.PLAIN_MESSAGE);
                    return;
            case -1: int potvrdenie = JOptionPane.showOptionDialog(this, "Hľadanie minima v tomto stĺpci nezodpovedá Simplexovej metóde. Naozaj chcete pokračovať?",
                    "Varovanie", 0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                    if (potvrdenie != JOptionPane.YES_OPTION) {
                        return;
                    }
            default: int focusRow = solutionCalculations.minimum(tblSolution.getSelectedRow(), tblSolution.getSelectedColumn());
                    if (focusRow==-2 && ValuesSingleton.INSTANCE.tableData[0][tblSolution.getSelectedColumn()].getNumerator()<0) {
                        JOptionPane.showMessageDialog(this, "Úloha je neohraničená!", "Riešenie", JOptionPane.PLAIN_MESSAGE);
                        return;
                    }
                    if (focusRow>0 && focusRow<= ValuesSingleton.INSTANCE.rows) {
                        tblSolution.changeSelection(focusRow, tblSolution.getSelectedColumn(), false, false);
                     } else {
                        JOptionPane.showMessageDialog(this, "Chybový stav!", "Chyba", JOptionPane.ERROR_MESSAGE);
                     }
        }

    }//GEN-LAST:event_jMenuItemMinActionPerformed

    private void jMenuItemMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMaxActionPerformed
        int checkMax = solutionCalculations.checkMax(tblSolution.getSelectedRow(), tblSolution.getSelectedColumn());

        switch(checkMax){
            case -4: JOptionPane.showMessageDialog(this, "Vyberte bunku kde je možné pivotovať!", "Chyba", JOptionPane.ERROR_MESSAGE);
                    return; 
            case -3: JOptionPane.showMessageDialog(this, "Ste v neprípustnom riešení duálu!", "Riešenie", JOptionPane.PLAIN_MESSAGE);
                    return;
            case -2: 
            case -1: int potvrdenie = JOptionPane.showOptionDialog(this, "Hľadanie maxima v tomto riadku nezodpovedá Simplexovej metóde. Naozaj chcete pokračovať?",
                    "Varovanie", 0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                    if (potvrdenie != JOptionPane.YES_OPTION) {
                        return;
                    }
            default: int focusColumn = solutionCalculations.maximum(tblSolution.getSelectedRow(), tblSolution.getSelectedColumn());
                    if (focusColumn==-2 && ValuesSingleton.INSTANCE.tableData[tblSolution.getSelectedRow()][0].getNumerator()<0) {
                        JOptionPane.showMessageDialog(this, "Duálna úloha je neohraničená!", "Riešenie", JOptionPane.PLAIN_MESSAGE);
                        return;
                    }
                    if (focusColumn>0 && focusColumn<= ValuesSingleton.INSTANCE.columns) {
                        tblSolution.changeSelection(tblSolution.getSelectedRow(), focusColumn, false, false);
                     } else {
                        JOptionPane.showMessageDialog(this, "Chybový stav!", "Chyba", JOptionPane.ERROR_MESSAGE);
                     }
        }

    }//GEN-LAST:event_jMenuItemMaxActionPerformed

    private void jMenuItemPivotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPivotActionPerformed
        if (!solutionCalculations.isBased()) {
            JOptionPane.showMessageDialog(this, "Tabuľka musí byť najprv bázovaná!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;            
        }
        int selectedRow = tblSolution.getSelectedRow();
        int selectedColumn = tblSolution.getSelectedColumn();
        int checkPivot = solutionCalculations.checkPivot(selectedRow, selectedColumn, (this.pocetPomPremennych==0));
        switch(checkPivot){
            case -1: JOptionPane.showMessageDialog(this, "Vyberte riadok/stĺpec kde je možné pivotovať!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            case -2: JOptionPane.showMessageDialog(this, "Nie je možné pivotovať na 0 (čísle menšom ako 0).", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            case -3: JOptionPane.showMessageDialog(this, "Ste v neprípustnom riešení!", "Riešenie", JOptionPane.PLAIN_MESSAGE);
                return;
            case -4: int potvrdenie = JOptionPane.showOptionDialog(this,"Daná operácia nezodpovedá Simplexovej metóde (v 0. riadku/stĺpci nie je záporné číslo). Naozaj chcete pokračovať?", "Varonanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                if (potvrdenie != JOptionPane.YES_OPTION) {
                    return;
                } 
            case -5: int potvrdenie2 = JOptionPane.showOptionDialog(this,"Daná operácia nezodpovedá Simplexovej metóde (v tejto bunke nie je minimum/maximum). Naozaj chcete pokračovať?", "Varonanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                if (potvrdenie2 != JOptionPane.YES_OPTION) {
                    return;
                } 
            default: //pivotuj
                solutionCalculations.pivot(selectedRow, selectedColumn);                   
                imageTableModel.fireTableDataChanged();
                basisTableModel.fireTableDataChanged();
                SavingWriterThread saver = new SavingWriterThread();
                
                    String[] row = {"1",""+selectedRow,""+selectedColumn};
                    ValuesSingleton.INSTANCE.putToSavingQueue(row);
                    String[] end = {"POISON_PILL"};
                    ValuesSingleton.INSTANCE.putToSavingQueue(end);
                    saver.append();
                
        }
        
        
    }//GEN-LAST:event_jMenuItemPivotActionPerformed

    private void jMenuItemPomocnaUlohaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPomocnaUlohaActionPerformed
        if (!solutionCalculations.have0overBasis()) {
            JOptionPane.showMessageDialog(this, "Tabuľka musí byť najprv bázovaná", "Pomocná úloha", JOptionPane.PLAIN_MESSAGE);
            return;
        }       
        
        pocetPomPremennych = 0;
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i]<0) {
                pocetPomPremennych++;
            }
        }
        if (pocetPomPremennych==0) {
            JOptionPane.showMessageDialog(this, "Pomocná úloha nie je potrebná", "Pomocná úloha", JOptionPane.PLAIN_MESSAGE);
            return;
        }
      
        ValuesSingleton.INSTANCE.startSuppRole(pocetPomPremennych);  
        /*for (int i = 0; i < pocetPomPremennych; i++) {
            tblSolution.addColumn(new TableColumn());
        }   */
        
        if (ValuesSingleton.INSTANCE.columnNames.length>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        
        imageTableModel = new ImageTableModel();
        tblSolution.setModel(imageTableModel);
        basisTableModel.fireTableDataChanged();
        btnKoniecPomUlohy.setVisible(true);
        SavingWriterThread saver = new SavingWriterThread();
        
            String[] row = {"2"};
            ValuesSingleton.INSTANCE.putToSavingQueue(row);
            String[] end = {"POISON_PILL"};
            ValuesSingleton.INSTANCE.putToSavingQueue(end);
            saver.append();
        
    }//GEN-LAST:event_jMenuItemPomocnaUlohaActionPerformed

    private void btnKoniecPomUlohyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoniecPomUlohyActionPerformed
        //este skoncenie - 1.spravne podmienky a 2. ked nespravne ta savedTableData nahodit
        if (solutionCalculations.rightEndOfSuppRole(pocetPomPremennych)) {
            
            ValuesSingleton.INSTANCE.endOfSuppRoleOpt(pocetPomPremennych);
            
            imageTableModel = new ImageTableModel();
            tblSolution.setModel(imageTableModel);
            basisTableModel = new BasisTableModel();
            tblBaza.setModel(basisTableModel);
            btnKoniecPomUlohy.setVisible(false);
            SavingWriterThread saver = new SavingWriterThread();
            
                String[] row = {"3"};
                ValuesSingleton.INSTANCE.putToSavingQueue(row);
                String[] end = {"POISON_PILL"};
                ValuesSingleton.INSTANCE.putToSavingQueue(end);
                saver.append();
            
        } else{
            int potvrdenie = JOptionPane.showOptionDialog(this,"Daná tabuľka nezodpovedá optimálnej tabuľke na ukončenie pomocnej úlohy. Naozaj chcete pokračovať? (Budete vrátení do stavu pred pomocnou úlohou.)", "Varonanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
            if (potvrdenie != JOptionPane.YES_OPTION) {
                return;
            }
            ValuesSingleton.INSTANCE.endOfSuppRoleNotOpt(pocetPomPremennych);
            
            imageTableModel = new ImageTableModel();
            tblSolution.setModel(imageTableModel);
            basisTableModel.fireTableDataChanged();
            btnKoniecPomUlohy.setVisible(false);
            SavingWriterThread saver = new SavingWriterThread();
            
                String[] row = {"4"};
                ValuesSingleton.INSTANCE.putToSavingQueue(row);
                String[] end = {"POISON_PILL"};
                ValuesSingleton.INSTANCE.putToSavingQueue(end);
                saver.append();
            
        }
        
    }//GEN-LAST:event_btnKoniecPomUlohyActionPerformed

    private void jMenuItemPrenasobRiadokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrenasobRiadokActionPerformed
        int selectedRow = tblSolution.getSelectedRow();
        if (selectedRow<=0) {
            JOptionPane.showMessageDialog(this, "Najprv vyberte vhodný riadok!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ValuesSingleton.INSTANCE.isOK = false;
         
        MultiplyRowDialog multRow = new MultiplyRowDialog(this, true);
        multRow.setVisible(true);
        
        if (!ValuesSingleton.INSTANCE.isOK) {
            JOptionPane.showMessageDialog(this, "Prebiehajúca akcia bola prerušená.", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        ValuesSingleton.INSTANCE.isOK = false;
        Fraction multBy = ValuesSingleton.INSTANCE.multBy;
        
        int canBeMult = solutionCalculations.canBeMultiplied(selectedRow);
        switch(canBeMult){
            case -1: JOptionPane.showMessageDialog(this, "Tento riadok nie je možné násobiť! (Môže sa pokaziť báza.)", "Chyba", JOptionPane.ERROR_MESSAGE);
                return; //je tam baza
            case -2: JOptionPane.showMessageDialog(this, "Táto operácia by viedla k neprípustnej úlohe!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return; //0. riadok zaporny a aj v 0. stlpci to vyrabam
            default: //vynasobim, prezriem a zrusim nepotrebne componenty
                solutionCalculations.multiplRow(selectedRow, multBy);
                imageTableModel.fireTableDataChanged();
                solutionCalculations.findBasis();//ak by mohlo ist do bazy

                SavingWriterThread saver = new SavingWriterThread();
                
                    String[] row = {"6",""+selectedRow,""+multBy.getNumerator(),""+multBy.getDenominator()};
                    ValuesSingleton.INSTANCE.putToSavingQueue(row);
                    String[] end = {"POISON_PILL"};
                    ValuesSingleton.INSTANCE.putToSavingQueue(end);
                    saver.append();
                
        }
    }//GEN-LAST:event_jMenuItemPrenasobRiadokActionPerformed

    private void jMenuHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHistoryActionPerformed
        
        //otvor okno s vypisanou historiou
    }//GEN-LAST:event_jMenuHistoryActionPerformed

    private void jMenuItemOpenNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenNewActionPerformed
        ValuesSingleton.INSTANCE.isOK=false;
        
        InputGetDimensionsDialog inputDimensions = new InputGetDimensionsDialog(this, true);
        inputDimensions.setVisible(true);

        if (!ValuesSingleton.INSTANCE.isOK) {
            ValuesSingleton.INSTANCE.rows=ValuesSingleton.INSTANCE.tableData.length-1;
            ValuesSingleton.INSTANCE.columns=ValuesSingleton.INSTANCE.tableData[0].length-1;
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
        
        ValuesSingleton.INSTANCE.isOK=false;
        
        InputTableDialog inputTableDialog = new InputTableDialog(this, true);
        inputTableDialog.setVisible(true);
        
        if (!ValuesSingleton.INSTANCE.isOK) {
            JOptionPane.showMessageDialog(this, "Prebiehajúca akcia bola prerušená.", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
            closeSolution();
            return;
        }
        ValuesSingleton.INSTANCE.isOK=false;
        
        ValuesSingleton.INSTANCE.suppRoleVariables = 0;
        this.pocetPomPremennych = 0;
        
        int[] pole = new int[ValuesSingleton.INSTANCE.rows];
        for (int i = 0; i < pole.length; i++) {
            pole[i]=-1;          
        }
        ValuesSingleton.INSTANCE.basisDataIdx = pole;
        
        ValuesSingleton.INSTANCE.file =  new File("tmp_posledneRiesenie.csv");
        this.saveTables();
        
        if (ValuesSingleton.INSTANCE.columnNames.length>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        
        basisTableModel = new BasisTableModel();
        imageTableModel = new ImageTableModel();
        
        if (!tblSolution.isVisible()) {
            initSolution();
        } else {
            
            tblSolution.setModel(imageTableModel);
            tblBaza.setModel(basisTableModel);
            solutionCalculations.findBasis();
            basisTableModel.fireTableDataChanged();
        }
        
        btnKoniecPomUlohy.setVisible(false);
    }//GEN-LAST:event_jMenuItemOpenNewActionPerformed

    private void jMenuItemOpenSavedInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenSavedInputActionPerformed
        
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
                closeSolution();
                return;
            }
            System.out.println("Otvoril som file: "+file.getName());
        } else {
            //JOptionPane.showMessageDialog(this, "Vyberte *.csv súbor (s uloženou úlohou LP)!", "Chyba", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Prebiehajúca akcia bola prerušená.", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        InputTableDialog inputTableDialog = new InputTableDialog(this, rootPaneCheckingEnabled);
        inputTableDialog.setVisible(true);
        
        if (!ValuesSingleton.INSTANCE.isOK) {
            JOptionPane.showMessageDialog(this, "Prebiehajúca akcia bola prerušená.", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
            closeSolution();
            return;
        }
        ValuesSingleton.INSTANCE.isOK=false;
        
        int[] pole = new int[ValuesSingleton.INSTANCE.rows];
        for (int i = 0; i < pole.length; i++) {
            pole[i]=-1;          
        }
        ValuesSingleton.INSTANCE.basisDataIdx = pole;
        
        ValuesSingleton.INSTANCE.suppRoleVariables = 0;
        this.pocetPomPremennych = 0;
        btnKoniecPomUlohy.setVisible(false);
        
        basisTableModel = new BasisTableModel();
        imageTableModel = new ImageTableModel();
        
        ValuesSingleton.INSTANCE.file =  new File("tmp_posledneRiesenie.csv");
        this.saveTables();
        
        if (!tblSolution.isVisible()) {
            initSolution();
            
        } else {
            if (ValuesSingleton.INSTANCE.columnNames.length>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
                tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }
            
            tblSolution.setModel(imageTableModel);
            tblBaza.setModel(basisTableModel);
            solutionCalculations.findBasis();
            basisTableModel.fireTableDataChanged();
        }
    }//GEN-LAST:event_jMenuItemOpenSavedInputActionPerformed

    private void jMenuItemOpenSavedSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenSavedSolutionActionPerformed
        
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
                ValuesSingleton.INSTANCE.onlyOnce = true;
                ValuesSingleton.INSTANCE.file = file;
                
            } catch (FileWritingException ex) {
                JOptionPane.showMessageDialog(this, "Problém pri načítaní súboru: "+ex.sprava, "Chyba", JOptionPane.ERROR_MESSAGE);
                closeSolution();
                return;
            }
            System.out.println("Otvoril som file: "+file.getName());
        } else {
            //JOptionPane.showMessageDialog(this, "Vyberte *.csv súbor (s uloženou úlohou LP)!", "Chyba", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Prebiehajúca akcia bola prerušená.", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        ValuesSingleton.INSTANCE.suppRoleVariables = 0;
        this.pocetPomPremennych = 0;
        btnKoniecPomUlohy.setVisible(false);
        
        int[] pole = new int[ValuesSingleton.INSTANCE.rows];
        for (int i = 0; i < pole.length; i++) {
            pole[i]=-1;          
        }
        ValuesSingleton.INSTANCE.basisDataIdx = pole;     
        
        basisTableModel = new BasisTableModel();
        imageTableModel = new ImageTableModel();
        
        ValuesSingleton.INSTANCE.file =  new File("tmp_posledneRiesenie.csv");
        this.saveTables();
        
        if (!tblSolution.isVisible()) {
            initSolution();
            
        } else {
            if (ValuesSingleton.INSTANCE.columnNames.length>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
                tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }
            
            tblBaza.setModel(basisTableModel);
            tblSolution.setModel(imageTableModel);
            solutionCalculations.findBasis();
            basisTableModel.fireTableDataChanged();
        }
        
        btnKoniecPomUlohy.setVisible((this.pocetPomPremennych>0));
    }//GEN-LAST:event_jMenuItemOpenSavedSolutionActionPerformed

    
    
    
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
                mf.openOffer();
            }
        });
    }
    
    
    
    private final String[] options;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKoniecPomUlohy;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenu jMenuHistory;
    private javax.swing.JMenuItem jMenuItemAboutAuthors;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemGomory;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemMakeBasis;
    private javax.swing.JMenuItem jMenuItemMax;
    private javax.swing.JMenuItem jMenuItemMin;
    private javax.swing.JMenuItem jMenuItemOpenNew;
    private javax.swing.JMenuItem jMenuItemOpenSavedInput;
    private javax.swing.JMenuItem jMenuItemOpenSavedSolution;
    private javax.swing.JMenuItem jMenuItemPivot;
    private javax.swing.JMenuItem jMenuItemPomocnaUloha;
    private javax.swing.JMenuItem jMenuItemPrenasobRiadok;
    private javax.swing.JMenuItem jMenuItemRevided;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenu jMenuPomocneOperacie;
    private javax.swing.JMenu jMenuTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBaza;
    private javax.swing.JTable tblSolution;
    // End of variables declaration//GEN-END:variables

    
}

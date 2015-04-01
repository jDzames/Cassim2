package Cassim2;

import Cassim2.Commands.Command;
import Cassim2.Commands.CommandUndoRevidedStart;
import Cassim2.Commands.CommandUndoRevidedStop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import org.apache.commons.math3.fraction.BigFraction;


public class MainFrame  extends javax.swing.JFrame {

    private ImageTableModel imageTableModel = new ImageTableModel();
    private BasisTableModel basisTableModel = new BasisTableModel();
    private RevidedImageTableModel revidedTableModel = new RevidedImageTableModel();
    private final SavedSolutionReader reader = new SavedSolutionReader();
    private final SolutionCalcService solutionCalculations = new SolutionCalcService();
    private int pocetPomPremennych;
    private boolean youCan=true;
    private File directoryForSaves;
    
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public MainFrame() {
        this.directoryForSaves = null;
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
        jComboBoxRevidedVariable = new javax.swing.JComboBox();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpenNew = new javax.swing.JMenuItem();
        jMenuItemOpenSavedInput = new javax.swing.JMenuItem();
        jMenuItemOpenSavedSolution = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemAutomat = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuTable = new javax.swing.JMenu();
        jMenuItemSuppRole = new javax.swing.JMenuItem();
        jMenuItemBasisSolution = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemGomory = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemMakeBasis = new javax.swing.JMenuItem();
        jMenuItemPivot = new javax.swing.JMenuItem();
        jMenuItemMin = new javax.swing.JMenuItem();
        jMenuItemMax = new javax.swing.JMenuItem();
        jMenuHelpOperations = new javax.swing.JMenu();
        jMenuItemPrenasobRiadok = new javax.swing.JMenuItem();
        jMenuItemShowSuppVariables = new javax.swing.JMenuItem();
        jMenuItemRemoveZeroLine = new javax.swing.JMenuItem();
        jMenuItemHint = new javax.swing.JMenuItem();
        jMenuRevidedMethod = new javax.swing.JMenu();
        jMenuItemRevidedSwitch = new javax.swing.JMenuItem();
        jMenuItemRevided0Row = new javax.swing.JMenuItem();
        jMenuItemRevidedRowValue = new javax.swing.JMenuItem();
        jMenuHistory = new javax.swing.JMenu();
        jMenuItemUNDO = new javax.swing.JMenuItem();
        jMenuItemREDO = new javax.swing.JMenuItem();
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

        jComboBoxRevidedVariable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxRevidedVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRevidedVariableActionPerformed(evt);
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

        jMenuItemOpenSavedInput.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
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

        jMenuItemAutomat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAutomat.setText("Automatický výpočet");
        jMenuItemAutomat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAutomatActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemAutomat);

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

        jMenuItemSuppRole.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSuppRole.setText("Riešiť pomocnú úlohu");
        jMenuItemSuppRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSuppRoleActionPerformed(evt);
            }
        });
        jMenuTable.add(jMenuItemSuppRole);

        jMenuItemBasisSolution.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBasisSolution.setText("Bázické riešenie");
        jMenuItemBasisSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBasisSolutionActionPerformed(evt);
            }
        });
        jMenuTable.add(jMenuItemBasisSolution);
        jMenuTable.add(jSeparator1);

        jMenuItemGomory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGomory.setText("Gomoryho rez");
        jMenuItemGomory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGomoryActionPerformed(evt);
            }
        });
        jMenuTable.add(jMenuItemGomory);

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

        jMenuHelpOperations.setText("Pomocné operácie");

        jMenuItemPrenasobRiadok.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, 0));
        jMenuItemPrenasobRiadok.setText("Prenásob riadok");
        jMenuItemPrenasobRiadok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrenasobRiadokActionPerformed(evt);
            }
        });
        jMenuHelpOperations.add(jMenuItemPrenasobRiadok);

        jMenuItemShowSuppVariables.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        jMenuItemShowSuppVariables.setText("Zobraz pomocné stĺpce");
        jMenuItemShowSuppVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemShowSuppVariablesActionPerformed(evt);
            }
        });
        jMenuHelpOperations.add(jMenuItemShowSuppVariables);

        jMenuItemRemoveZeroLine.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItemRemoveZeroLine.setText("Odstráň nulový riadok");
        jMenuItemRemoveZeroLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoveZeroLineActionPerformed(evt);
            }
        });
        jMenuHelpOperations.add(jMenuItemRemoveZeroLine);

        jMenuItemHint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        jMenuItemHint.setText("Hint k Simplex. metóde");
        jMenuItemHint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHintActionPerformed(evt);
            }
        });
        jMenuHelpOperations.add(jMenuItemHint);

        jMenuBar.add(jMenuHelpOperations);

        jMenuRevidedMethod.setText("Revidovaná metóda");

        jMenuItemRevidedSwitch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRevidedSwitch.setText("Začať revidovanú metódu");
        jMenuItemRevidedSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRevidedSwitchActionPerformed(evt);
            }
        });
        jMenuRevidedMethod.add(jMenuItemRevidedSwitch);

        jMenuItemRevided0Row.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, 0));
        jMenuItemRevided0Row.setText("Vypočítaj účelovú funkciu");
        jMenuItemRevided0Row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRevided0RowActionPerformed(evt);
            }
        });
        jMenuRevidedMethod.add(jMenuItemRevided0Row);

        jMenuItemRevidedRowValue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, 0));
        jMenuItemRevidedRowValue.setText("Vypočítaj stĺpec");
        jMenuItemRevidedRowValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRevidedRowValueActionPerformed(evt);
            }
        });
        jMenuRevidedMethod.add(jMenuItemRevidedRowValue);

        jMenuBar.add(jMenuRevidedMethod);

        jMenuHistory.setText("História");
        jMenuHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHistoryActionPerformed(evt);
            }
        });

        jMenuItemUNDO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUNDO.setText("UNDO ");
        jMenuItemUNDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUNDOActionPerformed(evt);
            }
        });
        jMenuHistory.add(jMenuItemUNDO);

        jMenuItemREDO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemREDO.setText("REDO");
        jMenuItemREDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemREDOActionPerformed(evt);
            }
        });
        jMenuHistory.add(jMenuItemREDO);

        jMenuBar.add(jMenuHistory);

        jMenuHelp.setText("Pomocník");

        jMenuItemHelp.setText("Pomocník");
        jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemHelp);

        jMenuItemAboutAuthors.setText("Autori");
        jMenuItemAboutAuthors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutAuthorsActionPerformed(evt);
            }
        });
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKoniecPomUlohy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxRevidedVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnKoniecPomUlohy)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxRevidedVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void closeSolution(){
        tblSolution.setVisible(false);
        tblBaza.setVisible(false);
        
        jMenuHistory.setEnabled(false);
        jMenuEdit.setEnabled(false);
        jMenuHelpOperations.setEnabled(false);
        jMenuRevidedMethod.setEnabled(false);
        jMenuItemRevidedSwitch.setEnabled(false);
        jMenuItemRevided0Row.setEnabled(false);
        jMenuItemRevidedRowValue.setEnabled(false);
        jMenuTable.setEnabled(false);
        jMenuItemSave.setEnabled(false);
        jMenuItemBasisSolution.setEnabled(false);
        jMenuItemShowSuppVariables.setEnabled(false);
        jMenuItemGomory.setEnabled(false);
        jMenuItemMakeBasis.setEnabled(false);
        jMenuItemMax.setEnabled(false);
        jMenuItemAutomat.setEnabled(false);
        jMenuItemHint.setEnabled(false);
        
        jComboBoxRevidedVariable.removeAllItems();
        
        btnKoniecPomUlohy.setVisible(false);
        jComboBoxRevidedVariable.setVisible(false);
        
        ValuesSingleton.INSTANCE.revidedMethodRunning = false;
        ValuesSingleton.INSTANCE.suppRoleRunning = false;
        jComboBoxRevidedVariable.setVisible(false);
    }
    
    private void initSolution(){
        //pustim ked prvy raz sa zjavia tabulky
        ValuesSingleton.INSTANCE.showColumns = ValuesSingleton.INSTANCE.columnNames.length;
        ValuesSingleton.INSTANCE.revidedMethodRunning = false;
        
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
        
        tblSolution.setDefaultRenderer(JLabel.class, new SolutionBigFractionCellRenderer()); 
        tblBaza.setDefaultRenderer(JLabel.class, new BasisRenderer(tblBaza));
        tblBaza.setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        jMenuItemSave.setEnabled(true);
            
        jMenuTable.setEnabled(true);
        jMenuItemGomory.setEnabled(true);
        jMenuItemSuppRole.setEnabled(true);
        jMenuItemBasisSolution.setEnabled(true);
        jMenuItemAutomat.setEnabled(true);

        jMenuEdit.setEnabled(true);
        jMenuItemMax.setEnabled(true);
        jMenuItemMakeBasis.setEnabled(true);

        jMenuHelpOperations.setEnabled(true);
        jMenuItemShowSuppVariables.setEnabled(true);
        jMenuItemHint.setEnabled(true);

        jMenuRevidedMethod.setEnabled(true);
        jMenuItemRevidedSwitch.setEnabled(true);
        jMenuItemRevided0Row.setEnabled(false);
        jMenuItemRevidedRowValue.setEnabled(false);        
        jComboBoxRevidedVariable.setVisible(false);

        jMenuHistory.setEnabled(true);
        
        ValuesSingleton.INSTANCE.showColumns=ValuesSingleton.INSTANCE.columnNames.length;
        
        int[] pole = new int[ValuesSingleton.INSTANCE.rows];
        for (int i = 0; i < pole.length; i++) {
            pole[i]=-1;          
        }
        ValuesSingleton.INSTANCE.basisDataIdx = pole;
        this.pocetPomPremennych=ValuesSingleton.INSTANCE.suppRoleVariables;
        
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        ValuesSingleton.INSTANCE.putToSavingQueue(ValuesSingleton.INSTANCE.columnNamesSaved);
        for (int i = 0; i < ValuesSingleton.INSTANCE.data.length; i++) {
            ValuesSingleton.INSTANCE.putToSavingQueue(ValuesSingleton.INSTANCE.data[i]);
        }
        ValuesSingleton.INSTANCE.putToSavingQueue(ValuesSingleton.INSTANCE.porovnaniasPS);
        ValuesSingleton.INSTANCE.putToSavingQueue(ValuesSingleton.INSTANCE.nezapornost);
        String[] size2 = {""+(ValuesSingleton.INSTANCE.rows+1),""+(ValuesSingleton.INSTANCE.columns+1)};
        ValuesSingleton.INSTANCE.putToSavingQueue(size2);
        String[] colNames = new String[ValuesSingleton.INSTANCE.columnNames.length];
        System.arraycopy(ValuesSingleton.INSTANCE.columnNames, 0, colNames, 0, ValuesSingleton.INSTANCE.columnNames.length);
        ValuesSingleton.INSTANCE.putToSavingQueue(colNames);
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
        if (directoryForSaves != null && directoryForSaves.exists()) {
            chooser.setCurrentDirectory(directoryForSaves);
        }
        chooser.setVisible(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            ".csv", "csv");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Save");
        chooser.setApproveButtonText("Select");
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            directoryForSaves = chooser.getCurrentDirectory();
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
                SavingAppenderThread saver = new SavingAppenderThread(ValuesSingleton.INSTANCE.stack);
                saver.run();
            } catch (IOException ex) {
                ValuesSingleton.INSTANCE.resetSavingQueue();
                JOptionPane.showMessageDialog(this, "Chyba pri ukladaní vstupu. Skuste súbor nazvať inak (lebo takýto súbor už pravdepodobne existuje) alebo súbor vytvorte inde (kvôli chýbajúcim právam).", "Chyba", JOptionPane.ERROR_MESSAGE);
            } 
            ValuesSingleton.INSTANCE.stack = new Stack<>();
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemMakeBasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMakeBasisActionPerformed
        Command cmd = solutionCalculations.makeZeroOverBasis();
        undoStack.push(cmd);
        jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
        ValuesSingleton.INSTANCE.stack.push("1");
        if (!redoStack.isEmpty()) {
            redoStack = new Stack<>();
        }
        
        //tblSolution.repaint();
        //tblBaza.repaint();
        if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
            revidedTableModel.fireTableDataChanged();
            tblSolution.repaint();
        }else{
            imageTableModel.fireTableDataChanged();
        }
        
    }//GEN-LAST:event_jMenuItemMakeBasisActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemGomoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGomoryActionPerformed
        int selectedRow = tblSolution.getSelectedRow();
        if (selectedRow<0) {
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
            default: Command cmd = ValuesSingleton.INSTANCE.doGomory(tblSolution.getSelectedRow());
                    undoStack.push(cmd);
                    jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
                    ValuesSingleton.INSTANCE.stack.push("2;"+selectedRow);
                    if (!redoStack.isEmpty()) {
                        redoStack = new Stack<>();
                    }
                    
                    imageTableModel = new ImageTableModel();
                    tblSolution.setModel(imageTableModel);
                    basisTableModel = new BasisTableModel();
                    tblBaza.setModel(basisTableModel);
                    
                    
        }
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_jMenuItemGomoryActionPerformed

    private void jMenuItemMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMinActionPerformed
        int selColumn = tblSolution.getSelectedColumn();
        if (selColumn<0 || selColumn>=ValuesSingleton.INSTANCE.columnNames.length) {
            JOptionPane.showMessageDialog(this, "Vyberte stĺpec v tabuľke", "Riešenie", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
            if (selColumn == ValuesSingleton.INSTANCE.rows + 1) {
                if (!(ValuesSingleton.INSTANCE.revidedColumnCell[0] && ValuesSingleton.INSTANCE.revidedColumnCell[1])) {
                    JOptionPane.showMessageDialog(this, "Nie je vypočítaný stĺpec!", "Nevhodné použitie", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                selColumn = ValuesSingleton.INSTANCE.revidedShownIdx;
            } else if (selColumn == 0) {
                selColumn = 0;
            } else {
                int rowinBasis = 0;
                for (int i = 0; i < ValuesSingleton.INSTANCE.rows; i++) {
                    if (ValuesSingleton.INSTANCE.tableData[i+1][selColumn].compareTo(BigFraction.ZERO)!=0) {
                        rowinBasis = i;
                        break;
                    }
                }
                selColumn = ValuesSingleton.INSTANCE.basisDataIdx[rowinBasis];
            }
        }
        
        if (!solutionCalculations.isBased() || !solutionCalculations.have0overBasis()) {
            JOptionPane.showMessageDialog(this, "Úloha nie je vybázovaná", "Riešenie", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        int checkedMin = solutionCalculations.checkMin(tblSolution.getSelectedRow(), selColumn);

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
            default: int focusRow = solutionCalculations.minimum(tblSolution.getSelectedRow(), selColumn);
                    if (focusRow==-2 && ValuesSingleton.INSTANCE.tableData[0][selColumn].getNumerator().longValue()<0) {
                        JOptionPane.showMessageDialog(this, "Úloha je neohraničená!", "Riešenie", JOptionPane.PLAIN_MESSAGE);
                        return;
                    } else
                        if (focusRow==-2 && ValuesSingleton.INSTANCE.tableData[0][selColumn].getNumerator().longValue()==0) {
                            JOptionPane.showMessageDialog(this, "Tento stĺpec nie je vhodný na hľadanie minima.", "Nevhodný stĺpec", JOptionPane.PLAIN_MESSAGE);
                            return;
                        }
                    if (focusRow>0 && focusRow<= ValuesSingleton.INSTANCE.rows) {
                        tblSolution.changeSelection(focusRow, tblSolution.getSelectedColumn(), false, false);
                     } else {
                        JOptionPane.showMessageDialog(this, "V tomto stĺpci nie je možné nájsť minimum podľa postupu Simplexovej metódy!", "Chyba", JOptionPane.ERROR_MESSAGE);
                     }
        }

    }//GEN-LAST:event_jMenuItemMinActionPerformed

    private void jMenuItemMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMaxActionPerformed
        int selecRow = tblSolution.getSelectedRow();
        if (selecRow<0 || selecRow>=ValuesSingleton.INSTANCE.tableData.length) {
            JOptionPane.showMessageDialog(this, "Vyberte stĺpec v tabuľke", "Riešenie", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!solutionCalculations.isBased() || !solutionCalculations.have0overBasis()) {
            JOptionPane.showMessageDialog(this, "Úloha nie je vybázovaná", "Riešenie", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        int checkMax = solutionCalculations.checkMax(selecRow, tblSolution.getSelectedColumn());

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
            default: int focusColumn = solutionCalculations.maximum(selecRow, tblSolution.getSelectedColumn());
                    if (focusColumn==-2 && ValuesSingleton.INSTANCE.tableData[selecRow][0].getNumerator().longValue()<0) {
                        JOptionPane.showMessageDialog(this, "Duálna úloha je neohraničená!", "Riešenie", JOptionPane.PLAIN_MESSAGE);
                        return;
                    } else
                        if (focusColumn==-2 && ValuesSingleton.INSTANCE.tableData[selecRow][0].getNumerator().longValue()==0) {
                            JOptionPane.showMessageDialog(this, "Tento riadok nie je vhodný na hľadanie maxima.", "Nevhodný riadok", JOptionPane.PLAIN_MESSAGE);
                            return;
                        }
                    if (focusColumn>0 && focusColumn<= ValuesSingleton.INSTANCE.columns) {
                        tblSolution.changeSelection(selecRow, focusColumn, false, false);
                     } else {
                        JOptionPane.showMessageDialog(this, "V tomto stĺpci nie je možné nájsť minimum podľa postupu Simplexovej metódy!", "Chyba", JOptionPane.ERROR_MESSAGE);
                     }
        }

    }//GEN-LAST:event_jMenuItemMaxActionPerformed

    private void jMenuItemPivotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPivotActionPerformed
        /*if (!solutionCalculations.isBased()) {
            JOptionPane.showMessageDialog(this, "Tabuľka musí byť najprv bázovaná!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;            
        }*/
        int selectedRow = tblSolution.getSelectedRow();
        int selectedColumn = tblSolution.getSelectedColumn();
        
        if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
            if (selectedColumn == ValuesSingleton.INSTANCE.rows + 1) {
                if (!(ValuesSingleton.INSTANCE.revidedColumnCell[0] && ValuesSingleton.INSTANCE.revidedColumnCell[1])) {
                    JOptionPane.showMessageDialog(this, "Nie je vypočítaný stĺpec!", "Nevhodné použitie", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                selectedColumn = ValuesSingleton.INSTANCE.revidedShownIdx;
            } else if (selectedColumn == 0) {
                selectedColumn = 0;
            } else {
                int rowinBasis = 0;
                for (int i = 0; i < ValuesSingleton.INSTANCE.rows; i++) {
                    if (ValuesSingleton.INSTANCE.tableData[i+1][selectedColumn].compareTo(BigFraction.ZERO)!=0) {
                        rowinBasis = i;
                        break;
                    }
                }
                selectedColumn = ValuesSingleton.INSTANCE.basisDataIdx[rowinBasis];
            }
        }
        
        int checkPivot = solutionCalculations.checkPivot(selectedRow, selectedColumn);
        switch(checkPivot){
            case -1: JOptionPane.showMessageDialog(this, "Vyberte riadok/stĺpec kde je možné pivotovať!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            case -2: JOptionPane.showMessageDialog(this, "Nie je možné pivotovať na 0 (čísle menšom ako 0).", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            case -3: int potvrdenie3 = JOptionPane.showOptionDialog(this,"Daná operácia (0. riadok alebo stĺpec) nezodpovedá Simplexovej metóde. Naozaj chcete pokračovať?", "Varovanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                if (potvrdenie3 != JOptionPane.YES_OPTION) {
                    return;
                }
            case -4: int potvrdenie = JOptionPane.showOptionDialog(this,"Daná operácia nezodpovedá Simplexovej metóde. Naozaj chcete pokračovať?", "Varovanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                if (potvrdenie != JOptionPane.YES_OPTION) {
                    return;
                } 
            case -5: int potvrdenie2 = JOptionPane.showOptionDialog(this,"Daná operácia nezodpovedá Simplexovej metóde (v tejto bunke nie je minimum/maximum). Naozaj chcete pokračovať?", "Varovanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
                if (potvrdenie2 != JOptionPane.YES_OPTION) {
                    return;
                } 
            default: //pivotuj      
                Command cmd;
                if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                    cmd = solutionCalculations.pivot(selectedRow, selectedColumn);  
                    revidedTableModel= new RevidedImageTableModel();
                    tblSolution.setModel(revidedTableModel);
                }else{
                    cmd = solutionCalculations.pivot(selectedRow, selectedColumn);     
                    imageTableModel.fireTableDataChanged();
                }
                undoStack.push(cmd);
                jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
                ValuesSingleton.INSTANCE.stack.push("2;"+selectedRow+";"+selectedColumn);
                if (!redoStack.isEmpty()) {
                    redoStack = new Stack<>();
                }
        
                basisTableModel.fireTableDataChanged();
                
        }
        
        
    }//GEN-LAST:event_jMenuItemPivotActionPerformed

    private void jMenuItemSuppRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSuppRoleActionPerformed
        if (!solutionCalculations.have0overBasis()) {
            JOptionPane.showMessageDialog(this, "Tabuľka musí byť najprv bázovaná", "Pomocná úloha", JOptionPane.PLAIN_MESSAGE);
            return;
        }       
        
        this.pocetPomPremennych = 0;
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            if (ValuesSingleton.INSTANCE.basisDataIdx[i]<0) {
                pocetPomPremennych++;
            }
        }
        if (pocetPomPremennych==0) {
            JOptionPane.showMessageDialog(this, "Pomocná úloha nie je potrebná", "Pomocná úloha", JOptionPane.PLAIN_MESSAGE);
            return;
        }
      
        Command cmd = ValuesSingleton.INSTANCE.startSuppRole(pocetPomPremennych); 
        undoStack.push(cmd);
        jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
        ValuesSingleton.INSTANCE.stack.push("4");
        if (!redoStack.isEmpty()) {
            redoStack = new Stack<>();
        }
        
        /*for (int i = 0; i < pocetPomPremennych; i++) {
            tblSolution.addColumn(new TableColumn());
        }   */
        
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
        
        jMenuItemSuppRole.setEnabled(false);
        imageTableModel = new ImageTableModel();
        tblSolution.setModel(imageTableModel);
        basisTableModel.fireTableDataChanged();
        btnKoniecPomUlohy.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemSuppRoleActionPerformed

    private void btnKoniecPomUlohyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoniecPomUlohyActionPerformed
        //este skoncenie - 1.spravne podmienky a 2. ked nespravne ta savedTableData nahodit
        youCan = false;
        if (solutionCalculations.rightEndOfSuppRole(pocetPomPremennych)) {
            
            Command cmd = ValuesSingleton.INSTANCE.endOfSuppRoleOpt(pocetPomPremennych);
            undoStack.push(cmd);
            jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
            ValuesSingleton.INSTANCE.stack.push("5");
            if (!redoStack.isEmpty()) {
                redoStack = new Stack<>();
            }
        
            if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                revidedTableModel= new RevidedImageTableModel();
                tblSolution.setModel(revidedTableModel);
            }else{
                imageTableModel = new ImageTableModel();
                tblSolution.setModel(imageTableModel);
            }
            
            basisTableModel = new BasisTableModel();
            tblBaza.setModel(basisTableModel);
            btnKoniecPomUlohy.setVisible(false);
            
        } else{
            int potvrdenie = JOptionPane.showOptionDialog(this,"Daná tabuľka nezodpovedá optimálnej tabuľke na ukončenie pomocnej úlohy. Naozaj chcete pokračovať? (Budete vrátení do stavu pred pomocnou úlohou.)", "Varonanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
            if (potvrdenie != JOptionPane.YES_OPTION) {
                return;
            }
            Command cmd = ValuesSingleton.INSTANCE.endOfSuppRoleNotOpt(pocetPomPremennych);
            undoStack.push(cmd);
            jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
            ValuesSingleton.INSTANCE.stack.push("6");
            if (!redoStack.isEmpty()) {
                redoStack = new Stack<>();
            }
        
            if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                revidedTableModel= new RevidedImageTableModel();
                tblSolution.setModel(revidedTableModel);
            }else{
                imageTableModel = new ImageTableModel();
                tblSolution.setModel(imageTableModel);
            }
            jComboBoxRevidedVariable.removeAllItems();
            jComboBoxRevidedVariable.addItem(new ComboBoxObjects(-1, ""));
            fillComboBoxAfterSuppRole();
            basisTableModel.fireTableDataChanged();
            btnKoniecPomUlohy.setVisible(false);
            
        }
        ValuesSingleton.INSTANCE.suppRoleRunning = false;
        youCan = true;
        
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        BigFraction multBy = ValuesSingleton.INSTANCE.multBy;
        
        int canBeMult = solutionCalculations.canBeMultiplied(selectedRow);
        /*switch(canBeMult){
            case -1: JOptionPane.showMessageDialog(this, "Tento riadok nie je možné násobiť! (Môže sa pokaziť báza.)", "Chyba", JOptionPane.ERROR_MESSAGE);
                return; //je tam baza
            case -2: JOptionPane.showMessageDialog(this, "Táto operácia by viedla k neprípustnej úlohe!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return; //0. riadok zaporny a aj v 0. stlpci to vyrabam
            default: //vynasobim, prezriem a zrusim nepotrebne componenty*/
        if (canBeMult==-1) {
            int potvrdenie = JOptionPane.showOptionDialog(this,"Vyhodíte prvok z bázy. Naozaj chcete pokračovať?", "Varovanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
            if (potvrdenie != JOptionPane.YES_OPTION) {
                return;
            }
        }
        Command cmd = solutionCalculations.multiplRow(selectedRow, multBy);
        undoStack.push(cmd);
        jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
        ValuesSingleton.INSTANCE.stack.push("7;"+multBy.getNumerator()+";"+multBy.getDenominator());
        if (!redoStack.isEmpty()) {
            redoStack = new Stack<>();
        }
        
        imageTableModel.fireTableDataChanged();
        ValuesSingleton.INSTANCE.basisDataIdx[selectedRow-1]=-1;
        solutionCalculations.findBasis();//ak by mohlo ist do bazy
        basisTableModel.fireTableDataChanged();
        
        //}
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
        ValuesSingleton.INSTANCE.gomoryVariables = 0;
        this.pocetPomPremennych = 0;
        
        int[] pole = new int[ValuesSingleton.INSTANCE.rows];
        for (int i = 0; i < pole.length; i++) {
            pole[i]=-1;          
        }
        ValuesSingleton.INSTANCE.basisDataIdx = pole;
        
        ValuesSingleton.INSTANCE.file =  new File("tmp_posledneRiesenie.csv");
        this.saveTables();
        
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        ValuesSingleton.INSTANCE.stack = new Stack<>();
        
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
        
        ValuesSingleton.INSTANCE.showColumns=ValuesSingleton.INSTANCE.columnNames.length;
        ValuesSingleton.INSTANCE.revidedMethodRunning=false;
        
        basisTableModel = new BasisTableModel();
        imageTableModel = new ImageTableModel();
        
        if (!tblSolution.isVisible()) {
            initSolution();
        } else {
            jMenuItemSave.setEnabled(true);
            
            jMenuTable.setEnabled(true);
            jMenuItemGomory.setEnabled(true);
            jMenuItemSuppRole.setEnabled(true);
            jMenuItemBasisSolution.setEnabled(true);
            jMenuItemAutomat.setEnabled(true);
            
            jMenuEdit.setEnabled(true);
            jMenuItemMax.setEnabled(true);
            jMenuItemMakeBasis.setEnabled(true);
            
            jMenuHelpOperations.setEnabled(true);
            jMenuItemShowSuppVariables.setEnabled(true);
            jMenuItemHint.setEnabled(true);
            
            jMenuRevidedMethod.setEnabled(true);
            jMenuItemRevidedSwitch.setEnabled(true);
            jMenuItemRevidedSwitch.setText("Začať revidovanú metódu");
            jMenuItemRevided0Row.setEnabled(false);
            jMenuItemRevidedRowValue.setEnabled(false);        
            jComboBoxRevidedVariable.setVisible(false);
            
            jMenuHistory.setEnabled(true);
            
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
        if (directoryForSaves != null && directoryForSaves.exists()) {
            chooser.setCurrentDirectory(directoryForSaves);
        }
        chooser.setVisible(true);
        /*FileNameExtensionFilter filter = new FileNameExtensionFilter(
            ".csv", "csv");*/
        chooser.setFileFilter(new CSVFileFilter());
        int returnVal = chooser.showOpenDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            directoryForSaves = chooser.getCurrentDirectory();
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
            closeSolution();
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
        ValuesSingleton.INSTANCE.gomoryVariables = 0;
        ValuesSingleton.INSTANCE.showColumns=ValuesSingleton.INSTANCE.columnNames.length;
        ValuesSingleton.INSTANCE.revidedMethodRunning=false;
        
        this.pocetPomPremennych = 0;
        btnKoniecPomUlohy.setVisible(false);
        
        basisTableModel = new BasisTableModel();
        imageTableModel = new ImageTableModel();
        
        ValuesSingleton.INSTANCE.file =  new File("tmp_posledneRiesenie.csv");
        this.saveTables();
        
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        ValuesSingleton.INSTANCE.stack = new Stack<>();
        
        if (!tblSolution.isVisible()) {
            initSolution();
            
        } else {
            
            jMenuItemSave.setEnabled(true);
            
            jMenuTable.setEnabled(true);
            jMenuItemGomory.setEnabled(true);
            jMenuItemSuppRole.setEnabled(true);
            jMenuItemBasisSolution.setEnabled(true);
            jMenuItemAutomat.setEnabled(true);
            
            jMenuEdit.setEnabled(true);
            jMenuItemMax.setEnabled(true);
            jMenuItemMakeBasis.setEnabled(true);
            
            jMenuHelpOperations.setEnabled(true);
            jMenuItemShowSuppVariables.setEnabled(true);
            jMenuItemHint.setEnabled(true);
            
            jMenuRevidedMethod.setEnabled(true);
            jMenuItemRevidedSwitch.setEnabled(true);
            jMenuItemRevidedSwitch.setText("Začať revidovanú metódu");
            jMenuItemRevided0Row.setEnabled(false);
            jMenuItemRevidedRowValue.setEnabled(false);        
            jComboBoxRevidedVariable.setVisible(false);
            
            jMenuHistory.setEnabled(true);
            
            tblSolution.setModel(imageTableModel);
            tblBaza.setModel(basisTableModel);
            solutionCalculations.findBasis();
            basisTableModel.fireTableDataChanged();
        }
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_jMenuItemOpenSavedInputActionPerformed

    private void jMenuItemOpenSavedSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenSavedSolutionActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.setToolTipText("Zadajte názov alebo vyberte súbor typu csv");
        if (directoryForSaves != null && directoryForSaves.exists()) {
            chooser.setCurrentDirectory(directoryForSaves);
        }
        chooser.setVisible(true);
        /*FileNameExtensionFilter filter = new FileNameExtensionFilter(
            ".csv", "csv");*/
        chooser.setFileFilter(new CSVFileFilter());
        int returnVal = chooser.showOpenDialog(this);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            directoryForSaves = chooser.getCurrentDirectory();
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "Vyberte *.csv súbor (s uloženou úlohou LP)!", "Chyba", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //otvorit a nacitat data
            try {
                reader.readForSolution(file, redoStack);
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
        ValuesSingleton.INSTANCE.gomoryVariables = 0;
        this.pocetPomPremennych = 0;
        ValuesSingleton.INSTANCE.showColumns=ValuesSingleton.INSTANCE.columnNames.length;
        ValuesSingleton.INSTANCE.revidedMethodRunning=false;
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
        
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        ValuesSingleton.INSTANCE.stack = new Stack<>();
        
        if (!tblSolution.isVisible()) {
            initSolution();
            
        } else {
            
            jMenuItemSave.setEnabled(true);
            
            jMenuTable.setEnabled(true);
            jMenuItemGomory.setEnabled(true);
            jMenuItemSuppRole.setEnabled(true);
            jMenuItemBasisSolution.setEnabled(true);
            jMenuItemAutomat.setEnabled(true);
            
            jMenuEdit.setEnabled(true);
            jMenuItemMax.setEnabled(true);
            jMenuItemMakeBasis.setEnabled(true);
            
            jMenuHelpOperations.setEnabled(true);
            jMenuItemShowSuppVariables.setEnabled(true);
            jMenuItemHint.setEnabled(true);
            
            jMenuRevidedMethod.setEnabled(true);
            jMenuItemRevidedSwitch.setEnabled(true);
            jMenuItemRevidedSwitch.setText("Začať revidovanú metódu");
            jMenuItemRevided0Row.setEnabled(false);
            jMenuItemRevidedRowValue.setEnabled(false);        
            jComboBoxRevidedVariable.setVisible(false);
            
            jMenuHistory.setEnabled(true);
            
            tblBaza.setModel(basisTableModel);
            tblSolution.setModel(imageTableModel);
            solutionCalculations.findBasis();
            basisTableModel.fireTableDataChanged();
        }
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
        //btnKoniecPomUlohy.setVisible((this.pocetPomPremennych>0));
    }//GEN-LAST:event_jMenuItemOpenSavedSolutionActionPerformed

    private void jMenuItemBasisSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBasisSolutionActionPerformed
        
        BasisSolutionDialog basisSolDialog = new BasisSolutionDialog(this, true);
        basisSolDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemBasisSolutionActionPerformed

    private void jMenuItemShowSuppVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemShowSuppVariablesActionPerformed
        if (ValuesSingleton.INSTANCE.showColumns==ValuesSingleton.INSTANCE.columnNames.length) {
            ValuesSingleton.INSTANCE.showColumns = ValuesSingleton.INSTANCE.showColumns-ValuesSingleton.INSTANCE.suppRoleVariables;
            jMenuItemShowSuppVariables.setText("Zobraz pomocné stĺpce");
        }else{
            ValuesSingleton.INSTANCE.showColumns = ValuesSingleton.INSTANCE.showColumns+ValuesSingleton.INSTANCE.suppRoleVariables;
            jMenuItemShowSuppVariables.setText("Skry pomocné stĺpce");
        }
        imageTableModel = new ImageTableModel();
        tblSolution.setModel(imageTableModel);
    }//GEN-LAST:event_jMenuItemShowSuppVariablesActionPerformed

    private void jMenuItemRemoveZeroLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoveZeroLineActionPerformed
        Command cmd = solutionCalculations.deleteRow(tblSolution.getSelectedRow());
        boolean vymazane =  cmd == null;
        if (!vymazane) {
            JOptionPane.showMessageDialog(this, "Prebiehajúca akcia bola prerušená.", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
        }else{
            undoStack.push(cmd);
            jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
            ValuesSingleton.INSTANCE.stack.push("8;"+tblSolution.getSelectedRow());
        
            imageTableModel = new ImageTableModel();
            basisTableModel = new BasisTableModel();
            tblBaza.setModel(basisTableModel);
            tblSolution.setModel(imageTableModel);
        }
    }//GEN-LAST:event_jMenuItemRemoveZeroLineActionPerformed

    private void jMenuItemRevidedSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRevidedSwitchActionPerformed
        if (!solutionCalculations.isBased()) {
            JOptionPane.showMessageDialog(this, "Tabuľka nemá bázu!", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
            jMenuItemShowSuppVariables.setEnabled(true);
            jMenuItemGomory.setEnabled(true);
            jMenuHelpOperations.setEnabled(true);
            jMenuItemMax.setEnabled(true);
            jMenuItemRevided0Row.setEnabled(false);
            jMenuItemRevidedRowValue.setEnabled(false);
            jMenuItemRevidedSwitch.setText("Začať revidovanú metódu");
            jComboBoxRevidedVariable.setVisible(false);
            jMenuItemHint.setEnabled(true);
            jMenuItemAutomat.setEnabled(true);
            
            ValuesSingleton.INSTANCE.revidedMethodRunning=false;
            
            Command cmd = new CommandUndoRevidedStop();
            undoStack.push(cmd);
            jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
            ValuesSingleton.INSTANCE.stack.push("9");
            if (!redoStack.isEmpty()) {
                redoStack = new Stack<>();
            }
            
            imageTableModel = new ImageTableModel();
            tblSolution.setModel(imageTableModel);
        } else {
            jMenuItemShowSuppVariables.setEnabled(false);
            jMenuItemGomory.setEnabled(false);
            jMenuHelpOperations.setEnabled(false);
            jMenuItemMax.setEnabled(false);
            jMenuItemRevided0Row.setEnabled(false);
            jMenuItemRevidedRowValue.setEnabled(false);
            jMenuItemHint.setEnabled(false);
            jMenuItemAutomat.setEnabled(false);
            jMenuItemRevidedSwitch.setText("Ukončiť revidovanú metódu");
            jComboBoxRevidedVariable.setVisible(true);
            ValuesSingleton.INSTANCE.revidedColumnCell=new boolean[2];
            jComboBoxRevidedVariable.addItem(new ComboBoxObjects(-1, ""));
            fillComboBox();
            addComboBoxListener();
            
            ValuesSingleton.INSTANCE.revidedMethodRunning=true;
            
            Command cmd = new CommandUndoRevidedStart();
            undoStack.push(cmd);
            jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
            ValuesSingleton.INSTANCE.stack.push("10");
            if (!redoStack.isEmpty()) {
                redoStack = new Stack<>();
            }
            
            //imageTableModel = new RevidedImageTableModel();
            revidedTableModel = new RevidedImageTableModel();
            tblSolution.setModel(revidedTableModel);
        }
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_jMenuItemRevidedSwitchActionPerformed

    private void jMenuItemRevided0RowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRevided0RowActionPerformed
        ValuesSingleton.INSTANCE.revidedColumnCell[0]=true;
        revidedTableModel.fireTableDataChanged();
        jMenuItemRevidedRowValue.setEnabled(true);
    }//GEN-LAST:event_jMenuItemRevided0RowActionPerformed

    private void jMenuItemRevidedRowValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRevidedRowValueActionPerformed
        /*int selectedRow = tblSolution.getSelectedRow();
        if (selectedRow<=0) {
            JOptionPane.showMessageDialog(this, "Vyberte nenulový riadok!", "Oznámenie", JOptionPane.PLAIN_MESSAGE);
            return;
        }*/
        ValuesSingleton.INSTANCE.revidedColumnCell[1]=true;
        revidedTableModel.fireTableDataChanged();
    }//GEN-LAST:event_jMenuItemRevidedRowValueActionPerformed

    private void jMenuItemUNDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUNDOActionPerformed
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            Command redoCmd = cmd.execute();
            ValuesSingleton.INSTANCE.stack.pop();
            
            switch(cmd.getType()){
                case 1 : basisTableModel.fireTableDataChanged();
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel.fireTableDataChanged();
                    } else {
                        imageTableModel.fireTableDataChanged();
                    }
                break;
                case 3 : basisTableModel.fireTableDataChanged();
                    btnKoniecPomUlohy.setVisible(false);
                    jMenuItemSuppRole.setEnabled(true);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;
                case 5 : basisTableModel.fireTableDataChanged();
                    btnKoniecPomUlohy.setVisible(true);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;   
                case 6 : basisTableModel = new BasisTableModel();
                    tblBaza.setModel(basisTableModel);
                    btnKoniecPomUlohy.setVisible(false);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;    
                case 7 : basisTableModel = new BasisTableModel();
                    tblBaza.setModel(basisTableModel);
                    btnKoniecPomUlohy.setVisible(true);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;    
                case 8 : basisTableModel = new BasisTableModel();
                    tblBaza.setModel(basisTableModel);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }  
                break;    
                case 9 : if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        jMenuItemShowSuppVariables.setEnabled(true);
                        jMenuItemGomory.setEnabled(true);
                        jMenuHelpOperations.setEnabled(true);
                        jMenuItemMax.setEnabled(true);
                        jMenuItemRevided0Row.setEnabled(false);
                        jMenuItemRevidedRowValue.setEnabled(false);
                        jMenuItemRevidedSwitch.setText("Začať revidovanú metódu");
                        jComboBoxRevidedVariable.setVisible(false);

                        ValuesSingleton.INSTANCE.revidedMethodRunning=false;

                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;
                case 10 : if (!ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        jMenuItemShowSuppVariables.setEnabled(false);
                        jMenuItemGomory.setEnabled(false);
                        jMenuHelpOperations.setEnabled(false);
                        jMenuItemMax.setEnabled(false);
                        jMenuItemRevided0Row.setEnabled(false);
                        jMenuItemRevidedRowValue.setEnabled(false);
                        jMenuItemRevidedSwitch.setText("Ukončiť revidovanú metódu");
                        jComboBoxRevidedVariable.setVisible(true);
                        ValuesSingleton.INSTANCE.revidedColumnCell=new boolean[2];
                        jComboBoxRevidedVariable.addItem(new ComboBoxObjects(-1, ""));
                        fillComboBox();
                        addComboBoxListener();

                        ValuesSingleton.INSTANCE.revidedMethodRunning=true;

                        //imageTableModel = new RevidedImageTableModel();
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    }
                break;
                default: ;  
            }
            
            redoStack.push(redoCmd);
            jMenuItemREDO.setToolTipText(redoCmd.toString());
        }
        if (!undoStack.isEmpty()) {
            jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
        }else{
            jMenuItemUNDO.setToolTipText("Nedá sa urobiť krok späť");
        }
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_jMenuItemUNDOActionPerformed

    private void jMenuItemREDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemREDOActionPerformed
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            Command undoCmd = cmd.execute();
            
            switch(cmd.getType()){
                case 1 : basisTableModel.fireTableDataChanged();
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel.fireTableDataChanged();
                    } else {
                        imageTableModel.fireTableDataChanged();
                    }
                break;
                case 2 : basisTableModel.fireTableDataChanged();
                    btnKoniecPomUlohy.setVisible(true);
                    jMenuItemSuppRole.setEnabled(false);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;
                case 4 : basisTableModel.fireTableDataChanged();
                    btnKoniecPomUlohy.setVisible(false);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;    
                case 6 : basisTableModel = new BasisTableModel();
                    tblBaza.setModel(basisTableModel);
                    btnKoniecPomUlohy.setVisible(false);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;
                case 8 : basisTableModel = new BasisTableModel();
                    tblBaza.setModel(basisTableModel);
                    if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    } else {
                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    } 
                break;
                case 9 : if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        jMenuItemShowSuppVariables.setEnabled(true);
                        jMenuItemGomory.setEnabled(true);
                        jMenuHelpOperations.setEnabled(true);
                        jMenuItemMax.setEnabled(true);
                        jMenuItemRevided0Row.setEnabled(false);
                        jMenuItemRevidedRowValue.setEnabled(false);
                        jMenuItemRevidedSwitch.setText("Začať revidovanú metódu");
                        jComboBoxRevidedVariable.setVisible(false);

                        ValuesSingleton.INSTANCE.revidedMethodRunning=false;

                        imageTableModel = new ImageTableModel();
                        tblSolution.setModel(imageTableModel);
                    }
                break;
                case 10 : if (!ValuesSingleton.INSTANCE.revidedMethodRunning) {
                        jMenuItemShowSuppVariables.setEnabled(false);
                        jMenuItemGomory.setEnabled(false);
                        jMenuHelpOperations.setEnabled(false);
                        jMenuItemMax.setEnabled(false);
                        jMenuItemRevided0Row.setEnabled(false);
                        jMenuItemRevidedRowValue.setEnabled(false);
                        jMenuItemRevidedSwitch.setText("Ukončiť revidovanú metódu");
                        jComboBoxRevidedVariable.setVisible(true);
                        ValuesSingleton.INSTANCE.revidedColumnCell=new boolean[2];
                        jComboBoxRevidedVariable.addItem(new ComboBoxObjects(-1, ""));
                        fillComboBox();
                        addComboBoxListener();

                        ValuesSingleton.INSTANCE.revidedMethodRunning=true;

                        //imageTableModel = new RevidedImageTableModel();
                        revidedTableModel = new RevidedImageTableModel();
                        tblSolution.setModel(revidedTableModel);
                    }
                break;
                default: ; 
            }
            
            undoStack.push(undoCmd);
            jMenuItemUNDO.setToolTipText(undoCmd.toString());
        }
        if (!redoStack.isEmpty()) {
            jMenuItemREDO.setToolTipText(redoStack.peek().toString());
        }else{
            jMenuItemREDO.setToolTipText("Nedá sa urobiť krok späť");
        }
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_jMenuItemREDOActionPerformed

    private void jMenuItemAboutAuthorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutAuthorsActionPerformed
        JOptionPane.showMessageDialog(this, "Tento projekt vznikol ako bakalárska práca, "
                + "zároveň s účelom využitia na predmete LCO na UPJŠ. Autormi sú: "
                + "RNDr. Pavol Široczki, doc. RNDr. Roman Soták, PhD. a Jozef Džama.", 
                "Autori", JOptionPane.PLAIN_MESSAGE);
        
    }//GEN-LAST:event_jMenuItemAboutAuthorsActionPerformed

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
        JOptionPane.showMessageDialog(this, "V prípade otázok alebo nájdenia chyby sa obráťte "
                + "na vyučujúcich LCO na UPJŠ alebo na mail jozef.dzama@gmail.com. Za hlásenie chýb vopred ďakujeme.", 
                "Pomoc", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItemHelpActionPerformed

    private void jMenuItemAutomatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAutomatActionPerformed

        jMenuBar.setEnabled(false);
        
        AutomaticSolution automat = new AutomaticSolution(undoStack);
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<AutoSolObj> future;
        
        try {
            future = exec.submit(automat);
            
            JOptionPane.showMessageDialog(this, "Začal sa automatický výpočet. Tabuľka sa zmení"
                + " na výslednú.", "Automatický výpočet", JOptionPane.PLAIN_MESSAGE);
            
            AutoSolObj vysledok = future.get();
            
            jMenuBar.setEnabled(true);
            
            btnKoniecPomUlohy.setVisible(false);
            jMenuItemSave.setEnabled(true);
            
            jMenuTable.setEnabled(true);
            jMenuItemGomory.setEnabled(true);
            jMenuItemSuppRole.setEnabled(true);
            jMenuItemBasisSolution.setEnabled(true);
            
            jMenuEdit.setEnabled(true);
            jMenuItemMax.setEnabled(true);
            jMenuItemMakeBasis.setEnabled(true);
            
            jMenuHelpOperations.setEnabled(true);
            jMenuItemShowSuppVariables.setEnabled(true);
            
            jMenuRevidedMethod.setEnabled(true);
            jMenuItemRevidedSwitch.setEnabled(true);
            jMenuItemRevidedSwitch.setText("Začať revidovanú metódu");
            jMenuItemRevided0Row.setEnabled(false);
            jMenuItemRevidedRowValue.setEnabled(false);        
            jComboBoxRevidedVariable.setVisible(false);
            
            jMenuHistory.setEnabled(true);
            
            imageTableModel = new ImageTableModel();
            tblSolution.setModel(imageTableModel);
            basisTableModel = new BasisTableModel();
            tblBaza.setModel(basisTableModel);
            
            if (!undoStack.isEmpty()) {
                jMenuItemUNDO.setToolTipText(undoStack.peek().toString());
            }
            
            JOptionPane.showMessageDialog(this, vysledok.toString(), 
                "Automatický výpočet", JOptionPane.PLAIN_MESSAGE);
            
            exec.shutdownNow();
            future.cancel(true);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tblSolution.getColumnCount()>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }//GEN-LAST:event_jMenuItemAutomatActionPerformed

    private void jMenuItemHintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHintActionPerformed
        Hint hint = solutionCalculations.hint();
        JOptionPane.showMessageDialog(this, hint.toString(), 
                "Hint", JOptionPane.PLAIN_MESSAGE);
            
        switch(hint.getType()){
            case 1 : /*if (ValuesSingleton.INSTANCE.revidedMethodRunning) {
                    if (hint.text.contains("Duál") ||  hint.text.contains("Vynásob")) {
                        JOptionPane.showMessageDialog(this, "Nastala chyba", 
                            "Hint", JOptionPane.ERROR);
                        return;
                    }
                    jComboBoxRevidedVariable.setSelectedIndex(hint.selectedColumn+1);
                    jMenuItemRevided0RowActionPerformed(evt);
                    jMenuItemRevidedRowValueActionPerformed(evt);
                    tblSolution.requestFocus();
                    tblSolution.changeSelection(hint.selectedRow, ValuesSingleton.INSTANCE.rows+1, false, false);
                } else {
                }*/    
                tblSolution.requestFocus();
                    tblSolution.changeSelection(hint.selectedRow, hint.selectedColumn, false, false);
                break;
            default : break;    
        }
    }//GEN-LAST:event_jMenuItemHintActionPerformed

    private void jComboBoxRevidedVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRevidedVariableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRevidedVariableActionPerformed

    
    private void fillComboBox() {
        youCan = true;
        for (int i = 1; i < ValuesSingleton.INSTANCE.columnNames.length; i++) {
           jComboBoxRevidedVariable.addItem(new ComboBoxObjects(i, ValuesSingleton.INSTANCE.columnNames[i]));
        }
    }

    private void fillComboBoxAfterSuppRole() {
        for (int i = 1; i < ValuesSingleton.INSTANCE.showColumns; i++) {
            jComboBoxRevidedVariable.addItem(new ComboBoxObjects(i, ValuesSingleton.INSTANCE.columnNames[i]));
        }
    }
    
    private void addComboBoxListener() {
        jComboBoxRevidedVariable.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!youCan || !ValuesSingleton.INSTANCE.revidedMethodRunning) {
                    return;
                }
                ComboBoxObjects selected = (ComboBoxObjects)(jComboBoxRevidedVariable.getSelectedItem());
                if (selected == null) {
                    return;
                }
                ValuesSingleton.INSTANCE.revidedShownIdx = selected.getColumn();
                ValuesSingleton.INSTANCE.revidedColumnCell=new boolean[2];
                jMenuItemRevidedRowValue.setEnabled(false);
                if (selected.getColumn()!=-1) {
                    jMenuItemRevided0Row.setEnabled(true);
                }else{
                    jMenuItemRevided0Row.setEnabled(false);
                }
                revidedTableModel= new RevidedImageTableModel();
                tblSolution.setModel(revidedTableModel);
            }
        });
    }

    
    
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
    private javax.swing.JComboBox jComboBoxRevidedVariable;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenu jMenuHelpOperations;
    private javax.swing.JMenu jMenuHistory;
    private javax.swing.JMenuItem jMenuItemAboutAuthors;
    private javax.swing.JMenuItem jMenuItemAutomat;
    private javax.swing.JMenuItem jMenuItemBasisSolution;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemGomory;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemHint;
    private javax.swing.JMenuItem jMenuItemMakeBasis;
    private javax.swing.JMenuItem jMenuItemMax;
    private javax.swing.JMenuItem jMenuItemMin;
    private javax.swing.JMenuItem jMenuItemOpenNew;
    private javax.swing.JMenuItem jMenuItemOpenSavedInput;
    private javax.swing.JMenuItem jMenuItemOpenSavedSolution;
    private javax.swing.JMenuItem jMenuItemPivot;
    private javax.swing.JMenuItem jMenuItemPrenasobRiadok;
    private javax.swing.JMenuItem jMenuItemREDO;
    private javax.swing.JMenuItem jMenuItemRemoveZeroLine;
    private javax.swing.JMenuItem jMenuItemRevided0Row;
    private javax.swing.JMenuItem jMenuItemRevidedRowValue;
    private javax.swing.JMenuItem jMenuItemRevidedSwitch;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemShowSuppVariables;
    private javax.swing.JMenuItem jMenuItemSuppRole;
    private javax.swing.JMenuItem jMenuItemUNDO;
    private javax.swing.JMenu jMenuRevidedMethod;
    private javax.swing.JMenu jMenuTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tblBaza;
    private javax.swing.JTable tblSolution;
    // End of variables declaration//GEN-END:variables

    
}

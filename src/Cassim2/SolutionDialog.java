package Cassim2;

import javax.swing.JLabel;
import javax.swing.JTable;


public class SolutionDialog extends javax.swing.JDialog {

    ImageTableModel tableModel = new ImageTableModel();
    BasisTableModel basisTableModel = new BasisTableModel();
    SolutionCalcService solutionCalculations = new SolutionCalcService();
    
    /**
     * Creates new form SolutionDialog
     */
    public SolutionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        String[] pole = new String[ValuesSingleton.INSTANCE.rows];
        ValuesSingleton.INSTANCE.basisData = pole;
        solutionCalculations.findBasis();
                
        initComponents();
        
        tblSolution.setDefaultRenderer(JLabel.class, new ImageRenderer()); 
        if (ValuesSingleton.INSTANCE.columnNames.length>6) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblSolution.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolution = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBaza = new javax.swing.JTable();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemLoad = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemFindBasis = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblSolution.setModel(tableModel);
        jScrollPane1.setViewportView(tblSolution);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("v báze: ");

        tblBaza.setModel(basisTableModel);
        tblBaza.setFocusable(false);
        tblBaza.setRowHeight(38);
        tblBaza.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(tblBaza);

        jMenuFile.setText("File");

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemLoad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLoad.setText("Load");
        jMenuFile.add(jMenuItemLoad);

        jMenuBar.add(jMenuFile);

        jMenuEdit.setText("Edit");

        jMenuItemFindBasis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, 0));
        jMenuItemFindBasis.setText("Find basis");
        jMenuItemFindBasis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFindBasisActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemFindBasis);

        jMenuBar.add(jMenuEdit);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                .addGap(85, 85, 85))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        System.out.println("Daco");
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemFindBasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFindBasisActionPerformed
        solutionCalculations.findBasis();
        tblSolution.repaint();
        tblBaza.repaint();
    }//GEN-LAST:event_jMenuItemFindBasisActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemFindBasis;
    private javax.swing.JMenuItem jMenuItemLoad;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBaza;
    private javax.swing.JTable tblSolution;
    // End of variables declaration//GEN-END:variables
}

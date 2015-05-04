
package Cassim2;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.commons.math3.fraction.BigFraction;


public class ChangeFunctionDialog extends javax.swing.JDialog {

    private TableModel changeFunctionModel = new ChangeFunctionTableModel();
    
    public ChangeFunctionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        if (ValuesSingleton.INSTANCE.columns>5) { //6-pocet stlpcov ktore su este male ked sa nenatiahnu
            tblChangeFunction.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tblChangeFunction.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
        
        tblChangeFunction.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblChangeFunction = new javax.swing.JTable();
        jButtonChangeFunction = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblChangeFunction.setModel(changeFunctionModel);
        tblChangeFunction.setRowHeight(29);
        tblChangeFunction.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblChangeFunction);

        jButtonChangeFunction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonChangeFunction.setText("Zmeň účelovú funkciu");
        jButtonChangeFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeFunctionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Čitateľ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Menovateľ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonChangeFunction)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addGap(36, 36, 36)
                .addComponent(jButtonChangeFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChangeFunctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeFunctionActionPerformed
        if (tblChangeFunction.isEditing())
            tblChangeFunction.getCellEditor().stopCellEditing();
        
        String[] options = new String[]{"Áno", "Nie"};
        int potvrdenie = JOptionPane.showOptionDialog(this,"Chystáte sa zmeniť účelovú funkciu. Naozaj chcete pokračovať?", "Varovanie",
                    0, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
        if (potvrdenie != JOptionPane.YES_OPTION) {
            return;
        }
        
        ValuesSingleton.INSTANCE.tableData[0] = ValuesSingleton.INSTANCE.changeFunctionRow0;
        
        ValuesSingleton.INSTANCE.isOK = true;
        this.dispose();
    }//GEN-LAST:event_jButtonChangeFunctionActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChangeFunction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChangeFunction;
    // End of variables declaration//GEN-END:variables
}

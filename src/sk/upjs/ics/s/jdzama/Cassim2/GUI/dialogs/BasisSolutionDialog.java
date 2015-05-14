
package sk.upjs.ics.s.jdzama.Cassim2.GUI.dialogs;

import sk.upjs.ics.s.jdzama.Cassim2.data.ValuesSingleton;


public class BasisSolutionDialog extends javax.swing.JDialog {

    /**
     * Creates new form BasisSolutionDialog
     */
    public BasisSolutionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Aktuálne bázické riešenie");
        StringBuilder basisSolution = new StringBuilder("(");
        String[] parts = new String[ValuesSingleton.INSTANCE.columns];
        for (int i = 0; i < ValuesSingleton.INSTANCE.basisDataIdx.length; i++) {
            parts[ValuesSingleton.INSTANCE.basisDataIdx[i]-1]=""+ValuesSingleton.INSTANCE.tableData[i+1][0].getNumerator()+
                    "/"+ValuesSingleton.INSTANCE.tableData[i+1][0].getDenominator();
        }
        for (int i = 0; i < ValuesSingleton.INSTANCE.columns; i++) {
            if (parts[i]==null || parts[i].length()==0) {
                basisSolution.append("0, ");
            } else {
                basisSolution.append(parts[i]+", ");
            }
        }
        basisSolution.replace(basisSolution.length()-2, basisSolution.length(), ")");
        jLabelBasis.setText(basisSolution.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnOK = new javax.swing.JButton();
        jLabelBasis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnOK.setText("OK");
        jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKActionPerformed(evt);
            }
        });

        jLabelBasis.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelBasis, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelBasis, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jBtnOK)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnOK;
    private javax.swing.JLabel jLabelBasis;
    // End of variables declaration//GEN-END:variables
}

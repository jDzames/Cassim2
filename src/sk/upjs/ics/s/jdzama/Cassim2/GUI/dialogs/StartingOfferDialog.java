
package sk.upjs.ics.s.jdzama.Cassim2.GUI.dialogs;

public class StartingOfferDialog extends javax.swing.JDialog {

    private int result;

    public int getResult() {
        return result;
    }
    
    public StartingOfferDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        result = 0;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonStartNew = new javax.swing.JButton();
        jButtonOpenSavedInput = new javax.swing.JButton();
        jButtonOpenSavedSolution = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonStartNew.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonStartNew.setText("Začni novú úlohu");
        jButtonStartNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartNewActionPerformed(evt);
            }
        });

        jButtonOpenSavedInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonOpenSavedInput.setText("Otvor uložené zadanie");
        jButtonOpenSavedInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenSavedInputActionPerformed(evt);
            }
        });

        jButtonOpenSavedSolution.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonOpenSavedSolution.setText("Otvor uložené riešenie");
        jButtonOpenSavedSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenSavedSolutionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButtonStartNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonOpenSavedInput, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jButtonOpenSavedSolution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButtonOpenSavedInput, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonOpenSavedSolution, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButtonStartNew, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartNewActionPerformed
        result = 1;
        this.dispose();
    }//GEN-LAST:event_jButtonStartNewActionPerformed

    private void jButtonOpenSavedInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenSavedInputActionPerformed
        result = 2;
        this.dispose();
    }//GEN-LAST:event_jButtonOpenSavedInputActionPerformed

    private void jButtonOpenSavedSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenSavedSolutionActionPerformed
        result = 3;
        this.dispose();
    }//GEN-LAST:event_jButtonOpenSavedSolutionActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOpenSavedInput;
    private javax.swing.JButton jButtonOpenSavedSolution;
    private javax.swing.JButton jButtonStartNew;
    // End of variables declaration//GEN-END:variables
}

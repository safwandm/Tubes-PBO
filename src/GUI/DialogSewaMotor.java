/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import setoran.DatabaseUser;
import setoran.Koneksi;
import setoran.Motor;
import setoran.Transaksi;

/**
 *
 * @author daman1k
 */
public class DialogSewaMotor extends javax.swing.JDialog {

    /**
     * Creates new form DialogSewa
     */
        
    private static Motor m;
    private PanelSewa ps;
    
    public DialogSewaMotor(java.awt.Frame parent, boolean modal, Motor motor) {
        super(parent, modal);
        
        initComponents();
        
        m = motor;
        
        jdcSetMulaiSewa.setMinSelectableDate(new Date());
        jdcSetMulaiSewa.setDateFormatString("yyyy-MM-dd");
                
        jdcSetAkhirSewa.setMinSelectableDate(new Date());
        jdcSetAkhirSewa.setDateFormatString("yyyy-MM-dd");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdcSetAkhirSewa = new com.toedter.calendar.JDateChooser();
        btnConfirmTransaction = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcSetMulaiSewa = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnConfirmTransaction.setText("Confirm");
        btnConfirmTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmTransactionActionPerformed(evt);
            }
        });

        jLabel1.setText("Tanggal Penyewaan");

        jLabel2.setText("Mulai:");

        jLabel3.setText("Akhir:");

        jdcSetMulaiSewa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcSetMulaiSewaPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcSetAkhirSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcSetMulaiSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConfirmTransaction)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jdcSetMulaiSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdcSetAkhirSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmTransaction)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmTransactionActionPerformed
        // TODO add your handling code here:
        
        Date mulaiDate = jdcSetMulaiSewa.getDate();
        Date akhirDate = jdcSetAkhirSewa.getDate();
        
        if (mulaiDate == null || akhirDate == null) {
            JOptionPane. showMessageDialog (null, "Tanggal mulai/akhir penyewaan tidak boleh kosong"
                        , "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                
        String mulaiDateF = dateFormat.format(mulaiDate);
        String akhirDateF = dateFormat.format(akhirDate);
        
        int hariSewa = Transaksi.getHariSewa(mulaiDateF, mulaiDateF);

        String updateQ = String.format("insert into transaksi(id_user, id_motor, tanggal_mulai, tanggal_selesai, nominal, status_transaksi) values(%d, %d, '%s', '%s', %d, 'aktif')", 
                DatabaseUser.currentUser.getIdUser(), m.getIdMotor(), mulaiDateF, akhirDateF, m.getHargaHarian() * hariSewa);
        
        try {
            Koneksi.update(updateQ);
            changeStatus(m.getIdMotor());
            JOptionPane. showMessageDialog (null, "Pemesanan berhasil"
                        , "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            ((HomePage)this.getParent()).refresh();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnConfirmTransactionActionPerformed

    private void jdcSetMulaiSewaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcSetMulaiSewaPropertyChange
        // TODO add your handling code here:
                
        if (jdcSetAkhirSewa.getDate() != null) {
            if (jdcSetMulaiSewa.getDate().compareTo(jdcSetAkhirSewa.getDate()) >= 0) {
                jdcSetAkhirSewa.setDate(null);
            }
        }
        jdcSetAkhirSewa.setMinSelectableDate(jdcSetMulaiSewa.getDate());
    }//GEN-LAST:event_jdcSetMulaiSewaPropertyChange

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogSewaMotor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogSewaMotor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogSewaMotor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogSewaMotor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogSewaMotor dialog = new DialogSewaMotor(new javax.swing.JFrame(), true, m);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmTransaction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JDateChooser jdcSetAkhirSewa;
    private com.toedter.calendar.JDateChooser jdcSetMulaiSewa;
    // End of variables declaration//GEN-END:variables

    private void changeStatus(int idMotor) throws Exception {
        String updateQ = String.format("update Motor set status_motor = 'Disewa' where id_motor = %d", idMotor); 
            Koneksi.update(updateQ);
    }
}
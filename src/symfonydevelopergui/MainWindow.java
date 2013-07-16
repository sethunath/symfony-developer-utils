/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package symfonydevelopergui;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author sethunath.km
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        MainWindow.commands = new Commands(this.outPutTextPane,this.StatusTextLabel);
        DefaultCaret caret = (DefaultCaret)outPutTextPane.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        spotscloudPathTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                int len = e.getDocument().getLength();
                String txt = null;
                try {
                    txt = e.getDocument().getText(0, len);
                    Commands.setApplicationPath(txt);
                } catch (BadLocationException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(txt);
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Text changed");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        spotscloudPathTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        outPutTextPane = new javax.swing.JTextPane();
        DevCacheCheckbox = new javax.swing.JCheckBox();
        prodCacheCheckbox = new javax.swing.JCheckBox();
        StatusTextLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pullBeforeDumping = new javax.swing.JCheckBox();
        pushAfterDumping = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Project Path:");

        spotscloudPathTextField.setText("D:\\wamp\\www\\spotscloud");
        spotscloudPathTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spotscloudPathTextFieldActionPerformed(evt);
            }
        });
        spotscloudPathTextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spotscloudPathTextFieldPropertyChange(evt);
            }
        });

        jButton1.setText("Clear Cache");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(outPutTextPane);

        DevCacheCheckbox.setText("dev");

        prodCacheCheckbox.setText("prod");
        prodCacheCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodCacheCheckboxActionPerformed(evt);
            }
        });

        StatusTextLabel.setText("jLabel2");

        jButton2.setText("Dump Assets");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pullBeforeDumping.setText("Pull before dumping");

        pushAfterDumping.setText("FTP Push After dumping");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StatusTextLabel)
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(DevCacheCheckbox)
                        .addGap(18, 18, 18)
                        .addComponent(prodCacheCheckbox))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spotscloudPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pullBeforeDumping)
                        .addGap(18, 18, 18)
                        .addComponent(pushAfterDumping)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spotscloudPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(DevCacheCheckbox)
                    .addComponent(prodCacheCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(pullBeforeDumping)
                    .addComponent(pushAfterDumping))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(StatusTextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spotscloudPathTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spotscloudPathTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spotscloudPathTextFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* Create and display the form */
        new Thread(new Runnable() {
            @Override
            public void run() {
                MainWindow.commands.clearCache(MainWindow.DevCacheCheckbox.isSelected(),MainWindow.prodCacheCheckbox.isSelected());
            }
        }).start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void prodCacheCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodCacheCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodCacheCheckboxActionPerformed

    private void spotscloudPathTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spotscloudPathTextFieldPropertyChange
        System.out.println(evt.getPropertyName());
    }//GEN-LAST:event_spotscloudPathTextFieldPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                MainWindow.commands.dumpAssets(MainWindow.pullBeforeDumping.isSelected(),MainWindow.pushAfterDumping.isSelected());
            }
        }).start();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException, InvocationTargetException {
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
                
            }
        });
    }
    private static Commands commands;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JCheckBox DevCacheCheckbox;
    private javax.swing.JLabel StatusTextLabel;
    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane outPutTextPane;
    private static javax.swing.JCheckBox prodCacheCheckbox;
    private static javax.swing.JCheckBox pullBeforeDumping;
    public static javax.swing.JCheckBox pushAfterDumping;
    private javax.swing.JTextField spotscloudPathTextField;
    // End of variables declaration//GEN-END:variables
}
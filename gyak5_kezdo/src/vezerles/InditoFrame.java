/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vezerles;

import alaposztalyok.Diak;
import grafikonhoz.Oszlop;
import java.awt.Color;
import java.util.Calendar;

/**
 *
 * @author :)
 */
public class InditoFrame extends javax.swing.JFrame {

   private final int SZELESSEG = 696;
   private final int MAGASSAG = 438;
   private final String CIM = "Adatbázisos diákok";
   
    public InditoFrame() {
        initComponents();
        beallitas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diakPanel1 = new feluletek.DiakPanel();
        kimutatasPanel1 = new feluletek.KimutatasPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(diakPanel1, java.awt.BorderLayout.LINE_START);
        getContentPane().add(kimutatasPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(InditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InditoFrame().indit();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private feluletek.DiakPanel diakPanel1;
    private feluletek.KimutatasPanel kimutatasPanel1;
    // End of variables declaration//GEN-END:variables
    
    private void beallitas() {
        this.setSize(SZELESSEG, MAGASSAG);
        this.setTitle(CIM);
        this.setLocationRelativeTo(null);
    }
    
    private void statikusAdatok() {
        
        Diak.setAktEv(Calendar.getInstance().get(Calendar.YEAR));
        Diak.setAlsoJegy(1);
        Diak.setFelsoJegy(5);
        
        Oszlop.setAlap(330);
        Oszlop.setSzelesseg(30);  
        
        kimutatasPanel1.setDiakSzin(Color.blue);
        kimutatasPanel1.setKtgDiakSzin(Color.red);
        kimutatasPanel1.setOszlopNoveloLepeskoz(2);

    }

    private void indit() {
        this.setVisible(true);
        statikusAdatok();
        
        Vezerlo vezerlo = new Vezerlo(diakPanel1, kimutatasPanel1);
        diakPanel1.setVezerlo(vezerlo);
        
        vezerlo.indit();
    }

}

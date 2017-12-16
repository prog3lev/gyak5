/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezerles;

import adatkezeles.AdatBazisBevitel;
import adatkezeles.AdatBevitel;
import adatkezeles.FajlBevitel;
import alaposztalyok.Diak;
import alaposztalyok.KoltsegTeritesesDiak;
import alaposztalyok.Tantargy;
import feluletek.DiakPanel;
import feluletek.KimutatasPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hallgato
 */
public class Vezerlo {
    
    private String diakEleres = "/adatok/diakok.txt";
    private String tantargyEleres = "/adatok/tantargyak.txt";
    
    private DiakPanel diakPanel;
    private KimutatasPanel kimutatasPanel;

    private List<Diak>diakok;
    private List<Tantargy>tantargyak;

    private Connection kapcsolodas() throws ClassNotFoundException, SQLException {
// az adatbázis driver meghatározása
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
// az adatbázis definiálása
        String url = "jdbc:derby://localhost:1527/DiakDb";
// kapcsolodas az adatbázishoz
        return DriverManager.getConnection(url, "diak", "diak");

    }

    public enum OszlopTipus {DIAK, KOLTSEGTERITESES}


    public Vezerlo(DiakPanel diakPanel, KimutatasPanel kimutatasPanel) {
        this.diakPanel = diakPanel;
        this.kimutatasPanel = kimutatasPanel;
    }

    void indit() {
        beolvasas();
        diakPanel.kiir(diakok, tantargyak);
        kimutatasPanel.oszlopGeneralas();
    }

    private void beolvasas() {
        try {
            Connection kapcsolat = kapcsolodas();
            AdatBevitel adatBevitel =
//                    new FajlBevitel(diakEleres, tantargyEleres);
                     new AdatBazisBevitel(kapcsolat);
            diakok = adatBevitel.diakBevitel();
            tantargyak = adatBevitel.tantargyBevitel();
        } catch (Exception ex) {
            Logger.getLogger(Vezerlo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vizsgaztatas(Diak diak, Tantargy tantargy, int jegy) {
        try {
            if (jegy < Diak.getAlsoJegy()
                    || jegy > Diak.getFelsoJegy()) {
                throw new IllegalArgumentException();
            }
            diak.vizsgazik(jegy, tantargy);
            diakPanel.kiirDiakEredmeny(diak, tantargy, jegy);

            OszlopTipus tipus;
            if(diak instanceof KoltsegTeritesesDiak){
                tipus = OszlopTipus.KOLTSEGTERITESES;
            }else{
                tipus = OszlopTipus.DIAK;
            }
            
            kimutatasPanel.oszlopModositas(tipus, jegy);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(diakPanel, "Hibás jegy");
        }
    }

    


}

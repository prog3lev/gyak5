/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Diak;
import alaposztalyok.KoltsegTeritesesDiak;
import alaposztalyok.Tantargy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hallgato
 */
public class AdatBazisBevitel implements AdatBevitel{

    private Connection kapcsolat;

    public AdatBazisBevitel(Connection kapcsolat) {
        this.kapcsolat = kapcsolat;
    }
    
    

    @Override
    public List<Diak> diakBevitel() throws Exception {
        List<Diak> diakok = new ArrayList<>();
        String sqlUtasitas = "SELECT * FROM DIAKOK";
        try( Statement utasitasObj =
                kapcsolat.createStatement();
                ResultSet eredmenyHz = 
                        utasitasObj.executeQuery(sqlUtasitas)){
                String nev, kod;
                int szulEv;
                while (eredmenyHz.next()) {                
                nev = eredmenyHz.getString("nev");
                kod = eredmenyHz.getString("kod");
                szulEv = eredmenyHz.getInt("szuletesiev");
                if(eredmenyHz.getBoolean("koltsegteriteses")){
                    diakok.add(new KoltsegTeritesesDiak(nev, kod, szulEv));
                }else{
                    diakok.add(new Diak(nev, kod, szulEv));
                }                
            }
        }        
        return diakok;
    }

    @Override
    public List<Tantargy> tantargyBevitel() throws Exception {
        List<Tantargy>tantargyak = new ArrayList<>();
        
        String sqlUtasitas = "SELECT * FROM TANTARGYAK";
        
        try(Statement utasitasObj = kapcsolat.createStatement();
                ResultSet eredmenyHz = utasitasObj.executeQuery(sqlUtasitas)){
        
            String nev, kod;
            int kredit;
            while (eredmenyHz.next()) {                
                nev = eredmenyHz.getString("nev");
                kod = eredmenyHz.getString("kod");
                kredit = eredmenyHz.getInt("kredit");
                tantargyak.add(new Tantargy(nev, kod, kredit));
            }
        }
        
        return tantargyak;
             
    }
    
}

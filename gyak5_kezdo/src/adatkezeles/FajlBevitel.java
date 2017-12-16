/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Diak;
import alaposztalyok.KoltsegTeritesesDiak;
import alaposztalyok.Tantargy;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Az AdatBevitel interfész egy lehetséges implementálása a
 * fájlból való olvasás.
 * 
 */
public class FajlBevitel implements AdatBevitel{
    
    private String diakEleres;
    private String tantargyEleres;
    public static final String CHAR_SET = "UTF-8";

    public FajlBevitel(String diakEleres, String tantargyEleres) {
        this.diakEleres = diakEleres;
        this.tantargyEleres = tantargyEleres;
    }    
    
    /**
     * A diákok adatainak beolvasására szolgáló metódus, 
     * eredményül adja a diákok listáját.
     * 
     * @return List<Diak>
     * @throws Exception 
     */
    @Override
    public List<Diak> diakBevitel() throws Exception {
        List<Diak> diakok = new ArrayList<>();
//        Nagy János;NAJAPTE;1997
//        Sovány Gábor;SOGAPTE;1987;k
        try (InputStream ins = this.getClass().getResourceAsStream(diakEleres);
                Scanner fajlScanner = new Scanner(ins, CHAR_SET)) {
            String sor;
            String[] adatok;
            while (fajlScanner.hasNextLine()) {
                sor = fajlScanner.nextLine();
                adatok = sor.split(";");
                if (adatok.length == 3) {
                    diakok.add(new Diak(adatok[0], adatok[1], Integer.valueOf(adatok[2])));
                } else {
                    diakok.add(new KoltsegTeritesesDiak(adatok[0], adatok[1], Integer.valueOf(adatok[2])));
                }
            }
        }

        return diakok;
    }

    /**
     * A tantárgyak adatainak beolvasására szolgáló metódus, 
     * eredményül adja a tantárgyak listáját.
     * 
     * @return List<Tantargy>
     * @throws Exception 
     */
    @Override
    public List<Tantargy> tantargyBevitel() throws Exception {
        List<Tantargy> tantargyak = new ArrayList<>();
//        Progi1;PRO1KOD;3
        try (InputStream ins = this.getClass().getResourceAsStream(tantargyEleres);
                Scanner fajlScanner = new Scanner(ins, CHAR_SET)) {
            String sor;
            String[] adatok;
            while (fajlScanner.hasNextLine()) {
                sor = fajlScanner.nextLine();
                adatok = sor.split(";");
                tantargyak.add(new Tantargy(adatok[0], adatok[1], Integer.valueOf(adatok[2])));
            }
        }
        return tantargyak;
    }
}

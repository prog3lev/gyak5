/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

import java.util.ArrayList;
import java.util.List;


public class Diak {
    private String nev;
    private String kod;
    private int szuletesiEv;
     
    private double osszJegy;
    private int vizsgaSzam ;
    
    private int teljesitettKredit;
    private double atlag;
    private List<Tantargy> tantargyak = new ArrayList<>();
    
    private static int aktualisEv;
    private static int alsoJegy, felsoJegy;

    public Diak(String nev, String kod, int szuletesiEv) {
        this.nev = nev;
        this.kod = kod;
        this.szuletesiEv = szuletesiEv; 
    }

    /**
     * Adott tárgyból adott jegyre vizsgázik, 
     * a metódus érvényes vizsga esetén 
     * módosítja a teljesített kreditek számát, az átlagot, és
     * bővíti a teljesített tárgyak listáját.
     * 
     * @param jegy
     * @param targy 
     */
    public void vizsgazik(int jegy, Tantargy targy) {
        if (alsoJegy < jegy && jegy <= felsoJegy) {
            teljesitettKredit += targy.getKredit();
            osszJegy += jegy;
            vizsgaSzam++;
            
            atlag = osszJegy/vizsgaSzam;
            tantargyak.add(targy);
        }
    }
    
    /**
     * Kiszámolja a diák életkorát. 
     * 
     * @return a kiszámított életkor
     */
    public int eletKor(){
        return aktualisEv - szuletesiEv;                 
    }

    @Override
    public String toString() {
        return nev + " (" + kod + ")" ;
    }

    public List<Tantargy> getTantargyak() {
//        return Collections.unmodifiableList(tantargyak);
        return new ArrayList<>(tantargyak);
//        return tantargyak;
    }    

    public String getNev() {
        return nev;
    }

    public String getKod() {
        return kod;
    }

    public int getTeljesitettKredit() {
        return teljesitettKredit;
    }

    public int getVizsgaSzam() {
        return vizsgaSzam;
    }

    public double getAtlag() {
        return atlag;
    } 

    public int getSzuletesiEv() {
        return szuletesiEv;
    }

    public static int getAktualisEv() {
        return aktualisEv;
    }
    
    public static void setAktEv(int aktualisEv) {
        Diak.aktualisEv = aktualisEv;
    }    

    public static int getAlsoJegy() {
        return alsoJegy;
    }

    public static void setAlsoJegy(int alsoJegy) {
        Diak.alsoJegy = alsoJegy;
    }

    public static int getFelsoJegy() {
        return felsoJegy;
    }

    public static void setFelsoJegy(int felsoJegy) {
        Diak.felsoJegy = felsoJegy;
    }    

}

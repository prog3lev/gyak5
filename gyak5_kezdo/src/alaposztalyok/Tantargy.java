/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

public class Tantargy implements Comparable<Tantargy>{
    private String nev;
    private String kod;
    private int kredit;

    public Tantargy(String nev, String kod, int kredit) {
        this.nev = nev;
        this.kod = kod;
        this.kredit = kredit;
    }  

    public String getNev() {
        return nev;
    }

    public int getKredit() {
        return kredit;
    }    

    public String getKod() {
        return kod;
    }
    
    @Override
    public String toString() {
        return nev + " (" + kredit + ")";
    }    

    @Override
    public int compareTo(Tantargy t) {
        return this.nev.compareTo(t.nev);
    }
}

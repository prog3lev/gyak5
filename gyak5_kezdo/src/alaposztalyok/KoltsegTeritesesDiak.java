/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;


public class KoltsegTeritesesDiak extends Diak{
    private static int koltsegSzorzo;

    public KoltsegTeritesesDiak(String nev, String ehaKod, int szulEv) {
        super(nev, ehaKod, szulEv);
    }  
    
    /**
     * A költségtérítéses diák tandíja a teljesített kreditszám valahányszorosa.
     * @return 
     */
    public int tandij(){
        return super.getTeljesitettKredit()*koltsegSzorzo;
    }

    @Override
    public String toString() {
        return super.toString() + " (k)";
    }

    
    public static int getKoltsegSzorzo() {
        return koltsegSzorzo;
    }

    public static void setKoltsegSzorzo(int koltsegSzorzo) {
        KoltsegTeritesesDiak.koltsegSzorzo = koltsegSzorzo;
    }     
}

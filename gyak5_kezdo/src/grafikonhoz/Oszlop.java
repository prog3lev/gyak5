/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikonhoz;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author :)
 */
public class Oszlop {
    private static int alap;
    private static int szelesseg;
    
    private int felsoX, felsoY;
    private Color szin;

    public Oszlop(int felsoX, int felsoY, Color szin) {
        this.felsoX = felsoX;
        this.felsoY = felsoY;
        this.szin = szin;
    }
    
    public void rajzol(Graphics g){
        g.setColor(szin);
        g.fillRect(felsoX, felsoY, szelesseg, alap-felsoY);
    }

    public static int getAlap() {
        return alap;
    }

    public static void setAlap(int alap) {
        Oszlop.alap = alap;
    }

    public static int getSzelesseg() {
        return szelesseg;
    }

    public static void setSzelesseg(int szelesseg) {
        Oszlop.szelesseg = szelesseg;
    }

    public int getFelsoX() {
        return felsoX;
    }

    public void setFelsoX(int felsoX) {
        this.felsoX = felsoX;
    }

    public int getFelsoY() {
        return felsoY;
    }

    public void setFelsoY(int felsoY) {
        this.felsoY = felsoY;
    }

    public Color getSzin() {
        return szin;
    }

    public void setSzin(Color szin) {
        this.szin = szin;
    }    
}

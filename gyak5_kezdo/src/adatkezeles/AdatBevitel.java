/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Diak;
import alaposztalyok.Tantargy;
import java.util.List;

/**
 * Az interfész leírja, hogy valahogyan létre akarjuk hozni a 
 * diákok és a tantárgyak listáját - kötelező hibakezelést is előír.
 * 
 */
public interface AdatBevitel {
    
    public List<Diak> diakBevitel() throws Exception;
    public List<Tantargy> tantargyBevitel() throws Exception;
}

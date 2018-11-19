/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Antoine
 */
public enum eglise {
    chapelle ("chapelle"),
    cimetiere ("cimetiere"),
    clocher ("clocher"),
    cloitre ("cloitre"),
    tombe ("tombe"),
    salle_de_sacrifice ("salle_de_sacrifice");
    
    String lieu;
        
    private eglise(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return new String(lieu);
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}

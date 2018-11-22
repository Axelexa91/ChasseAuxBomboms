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
public enum maison_hantee {
    chambre ("chambre"),
    salon ("salon"),
    cuisine ("cuisine"),
    cave ("cave"),
    jardin ("jardin"),
    toit ("toit");
    
    String lieu;
        
    private maison_hantee(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return new String(lieu);
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}

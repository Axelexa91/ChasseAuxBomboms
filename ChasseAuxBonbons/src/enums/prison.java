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
public enum prison {
    cellule ("cellule"),
    sanitaire ("sanitaire"),
    cantine ("cantine"),
    isolement("isolement"),
    salle_de_torture ("salle_de_torture"),
    cour ("cour");
    
    String lieu;
        
    private prison(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return new String(lieu);
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}

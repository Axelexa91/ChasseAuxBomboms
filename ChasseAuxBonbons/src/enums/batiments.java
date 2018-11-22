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
public enum batiments {

    maison_hantee ("maison_hantee"),
    eglise ("eglise"),
    boucherie ("boucherie"),
    prison ("prison");
    
    String lieu;
    
    private batiments(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return new String(lieu);
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
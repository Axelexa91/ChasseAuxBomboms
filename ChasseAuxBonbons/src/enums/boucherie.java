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
public enum boucherie {
    comptoire ("comptoire"),
    chambre_froide ("chambre_froide"),
    abattoir ("abattoir"),
    bureau ("bureau"),
    porcherie ("porcherie"),
    local_poubelle ( "local_poubelle");
    
    String lieu;
        
    private boucherie(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return new String(lieu);
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}

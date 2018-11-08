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
public enum pieces {
    chambre ("chambre"),
    salon ("salon"),
    cuisine ("cuisine"),
    cave ("cave"),
    jardin ("jardin"),
    toit ("toit"),
    
    chapelle ("chapelle"),
    cimetiere ("cimetiere"),
    clocher ("clocher"),
    cloitre ("cloitre"),
    tombe ("tombe"),
    salle_de_sacrifice ("salle_de_sacrifice"),
    
    comptoire ("comptoire"),
    chambre_froide ("chambre_froide"),
    abattoir ("abattoir"),
    bureau ("bureau"),
    porcherie ("porcherie"),
    local_poubelle ( "local_poubelle"),
    
    cellule ("cellule"),
    sanitaire ("sanitaire"),
    cantine ("cantine"),
    isolement("isolement"),
    salle_de_torture ("salle_de_torture"),
    cours ("cours");
    
    String lieu;
        
    private pieces(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return new String(lieu);
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}

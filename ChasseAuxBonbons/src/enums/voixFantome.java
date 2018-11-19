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
public enum voixFantome {
    voixF1 ("Je vais traverser votre âme !"),
    voixF2 ("Je flotte parmi les morts."),
    voixF3 ("Soyez mon ami pour l'éternité...");
    
    String voix;
    
    private voixFantome(String voix) {
        this.voix = voix;
    }

    public String getvoix() {
        return new String(voix);
    }

    public void setvoix(String voix) {
        this.voix = voix;
    }
}

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
public enum voixZombie {
    voixZ1 ("Je vais vous dévorer la cervelle !"),
    voixZ2 ("J'ai perdu 4 orteils."),
    voixZ3 ("J'ai mangé Rick pour l'apéro...");
    
    String voix;
    
    private voixZombie(String voix) {
        this.voix = voix;
    }

    public String getvoix() {
        return new String(voix);
    }

    public void setvoix(String voix) {
        this.voix = voix;
    }
}

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
public enum voixSorcier {
    voixS1 ("Non Obélix tu n'auras pas de potion magique !"),
    voixS2 ("J'ai besoin d'un chaudron + grand pour vous..."),
    voixS3 ("J'ai une nouvelle verrue sur le nez.");
    
    String voix;
    
    private voixSorcier(String voix) {
        this.voix = voix;
    }

    public String getvoix() {
        return new String(voix);
    }

    public void setvoix(String voix) {
        this.voix = voix;
    }
}

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
public enum voixVampire {
    voixV1 ("J'ai soif de sang frais !"),
    voixV2 ("Je vais vous croquer le cou..."),
    voixV3 ("Je déteste aller à la plage.");
    
    String voix;
    
    private voixVampire(String voix) {
        this.voix = voix;
    }

    public String getvoix() {
        return new String(voix);
    }

    public void setvoix(String voix) {
        this.voix = voix;
    }
}

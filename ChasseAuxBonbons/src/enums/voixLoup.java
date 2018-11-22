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
public enum voixLoup {
    voixL1 ("Je vais vous mordre !"),
    voixL2 ("Au début j'étais un caniche..."),
    voixL3 ("J'adore hurler à la pleine lune.");
    
    String voix;
    
    private voixLoup(String voix) {
        this.voix = voix;
    }

    public String getvoix() {
        return new String(voix);
    }

    public void setvoix(String voix) {
        this.voix = voix;
    }
}

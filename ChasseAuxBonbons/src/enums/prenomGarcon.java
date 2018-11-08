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
public enum prenomGarcon {
    Adam ("Adam"),
    Alex ("Alex"),
    Alexandre ("Alexendre"),
    Alexis ("Alexis"),
    Anthony ("Anthony"),
    Antoine ("Antoine"),
    Benjamin ("Benjamin"),
    Cedric ("Cedric"),
    Charles ("Charles"),
    Christopher ("Christopher"), 
    David ("David"),
    Dylan ("Dylan"),
    Edouard ("Edouard"),
    Elliot ("Elliot"),
    Emile ("Emile"),
    Etienne ("Etienne"),
    Felix ("Felix"),
    Gabriel ("Gabriel"),
    Guillaume ("Guillaume"),
    Hugo ("Hugo"),
    Isaac ("Isaac"),
    Jacob ("Jacob"),
    Jeremy ("Jeremy"),
    Jonathan ("Jonathan"),
    Julien ("Justin"),
    Justin ("Justin"),
    Leo ("Leo"),
    Logan ("Logan"),
    Loic ("Loic"),
    Louis ("Louis"),
    Lucas ("Lucas"),
    Ludovic ("Ludovic"),
    Malik ("Malik"),
    Mathieu ("Mathieu"),
    Mathis ("Mathis"),
    Maxime ("Maxime"),
    Michael ("Michael"),
    Nathan ("Nathan"),
    Nicolas ("Nicolas"),
    Noah ("Noah"),
    Olivier ("Olivier"),
    Philippe ("Philippe"),
    Raphael ("Raphael"),
    Samuel ("Samuel"),
    Simon ("Simon"),
    Thomas ("Thomas"),
    Tommy ("Tommy"),
    Tristan ("Tristan"),
    Victor ("Victor"),
    Vincent ("Vincent");

        String prenom;

    private prenomGarcon(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return new String(prenom);
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type;

import Entité.Entité;
import Lieux.Lieu;
import Lieux.Piece.Piece;


/**
 *
 * @author axelz
 */
public abstract class Undead extends Entité {

    public Undead(String Nom) {
        super(Nom);
    }
    public void FairePeur(Lieu lieu){
        for(Entité personnage : lieu.getPersonnages()){
            if(personnage != this){
                personnage.setBonbons(personnage.getBonbons()-1);
                if(lieu instanceof Piece){
                    ((Piece) lieu).setBonbon(((Piece) lieu).getBonbon()+1);
                }
            }
        }
    }
      
}

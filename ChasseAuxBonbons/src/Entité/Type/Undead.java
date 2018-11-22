/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type;

import Entité.Entité;


/**
 *
 * @author axelz
 */
public abstract class Undead extends Entité{

    public Undead(String Nom) {
        super(Nom);
    }
    public void FairePeur(){
       System.err.println("faire perdre des bonbons à chaque personnage de la pièce");
    }
      
}

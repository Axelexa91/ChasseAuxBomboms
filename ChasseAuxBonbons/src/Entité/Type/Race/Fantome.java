/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type.Race;

import Entité.Type.Undead;

/**
 *
 * @author axelz
 */
public abstract class Fantome extends Undead {

    public Fantome(String Nom) {
        super(Nom);
    }
    @Override
    public void Crier() {
        System.out.println("Hoouuu !"); 
    }
    
    
    public String getRace(){
        return new String("Fantome");
    }
    
    
    @Override
    public void voirDeplacement(){
       System.err.println("voir les déplacements possibles à faire");
    }
}

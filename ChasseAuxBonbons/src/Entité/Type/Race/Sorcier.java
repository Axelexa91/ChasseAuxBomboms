/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type.Race;

import Entité.Type.Alive;

/**
 *
 * @author axelz
 */
public abstract class Sorcier extends Alive {

    public Sorcier(String Nom) {
        super(Nom);
    }
    @Override
    public void Crier() {
        System.out.println("Hihihi !"); 
    }
    
    
    public String getRace(){
        return new String("Sorcier");
    }
    
    
    @Override
    public void voirDeplacement(){
       System.err.println("voir les déplacements possibles à faire");
    }
}

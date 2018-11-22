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
public abstract class LoupGarou extends Alive {

    public LoupGarou(String Nom) {
        super(Nom);
    }
    @Override
    public void Crier() {
        System.out.println("Grrrrr !"); 
    }
    
    
    public String getRace(){
        return new String("Loup-Garou");
    }
    
    
    @Override
    public void voirDeplacement(){
       System.err.println("voir les déplacements possibles à faire");
    }
}

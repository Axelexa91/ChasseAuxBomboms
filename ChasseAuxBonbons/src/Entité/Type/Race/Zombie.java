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
public abstract class Zombie extends Undead{
    @Override
    public void Crier() {
        System.out.println("Arrrgh !"); 
    }
    
    @Override
    public void voirDeplacement(){
       System.err.println("voir les déplacements possibles à faire");
    }
}

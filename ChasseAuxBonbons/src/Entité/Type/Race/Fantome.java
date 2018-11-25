/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type.Race;

import Entité.Type.Undead;
import Lieux.Batiment.Batiment;
import Lieux.Dehors.Dehors;
import Lieux.Lieu;
import Lieux.Piece.Piece;

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
        System.out.println(this.getNom() + ": Hoouuu~ ! Je passe partouuut~"); 
    }
    
    
    public String getRace(){
        return new String("Fantome");
    }
    
    @Override
    public void seDeplacer(Lieu position, Lieu cible){
        //this.Crier();
        position.delPersonnages(this);
        cible.addPersonnages(this);
    }
    
    @Override
    public void fouiller(Piece position){
        if(position.getBonbon() != 0){
            bonbons+=position.getBonbon();
            System.out.println(this.getNom() + ": Houuu~ ! J'ai trouuuuu~vé " + position.getBonbon() + " bonboooooons~ !");
            position.setBonbon(0);
            System.out.println(this.getNom() + ": " +this.bonbons + " bonboooooons~");
        }
        else{
            System.out.println(this.getNom() +": Houuu~... Plus de bonbooons~");
        }

    }


    
}

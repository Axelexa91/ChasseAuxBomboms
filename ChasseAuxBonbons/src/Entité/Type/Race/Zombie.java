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
public abstract class Zombie extends Undead {

    public Zombie(String Nom) {
        super(Nom);
    }
    @Override
    public void Crier() {
        System.out.println(this.getNom() + ": Arrrgh ! J'ai déjà perdu assez de doigts comme cela dans un abatoir..."); 
    }
    
    
    public String getRace(){
        return new String("Zombie");
    }
    
    @Override
    public void fouiller(Piece position){
        if(position.getBonbon() != 0){
            if(position.getNom().compareTo(enums.eglise.cimetiere.getLieu()) == 0) position.setBonbon(position.getBonbon()*2); //application du bonus raciale
            bonbons+=position.getBonbon();
            System.out.println(this.getNom() + ": Aaarg... " + position.getBonbon() + " bonbons de plus...");
            position.setBonbon(0);
            System.out.println(this.getNom() + ": "+this.bonbons + " bonbons au total dans cette vie...");
        }
        else{
            System.out.println(this.getNom() +": Plus de bonbons ?");
        }

    }
    
    
    @Override
    public void seDeplacer(Lieu position, Lieu cible){
        if(cible.getNom().compareTo(enums.boucherie.abattoir.getLieu()) == 0){
            this.Crier();
        }
        else{
            position.delPersonnages(this);
            cible.addPersonnages(this);
        }
    }
}

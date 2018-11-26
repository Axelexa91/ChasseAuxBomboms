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
public abstract class Vampire extends Undead {

    public Vampire(String Nom) {
        super(Nom);
    }
    @Override
    public void Crier() {
        System.out.println(this.getNom() + ": Sshhhhh ! Ca empeste l'ail dans cette cantine !"); 
    }
    
    
    public String getRace(){
        return new String("Vampire");
    }
    
    @Override
    public void fouiller(Piece position){
        if(position.getBonbon() != 0){
            if(position.getNom().compareTo(enums.prison.salle_de_torture.getLieu()) == 0) position.setBonbon(position.getBonbon()*2); //application du bonus raciale
            bonbons+=position.getBonbon();
            System.out.println(this.getNom() +": Mouahah ! " + position.getBonbon() + " bonbons pour l'aristocrate que je suis !");
            position.setBonbon(0);
            System.out.println(this.getNom() + ": " +this.bonbons + " hein ? Ce n'est pas suffisant pour ma grandeur !");
        }
        else{
            System.out.println(this.getNom() +": Qui à oser ! Il n'y a pas un seul bonbon ici !");
        }

    }
    
    @Override
    public void seDeplacer(Lieu position, Lieu cible){
        if(cible.getNom().compareTo(enums.prison.cantine.getLieu()) == 0){
            this.Crier();
        }
        else{
            position.delPersonnages(this);
            cible.addPersonnages(this);
        }
    }
}

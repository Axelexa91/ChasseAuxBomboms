/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type.Race;

import Entité.Type.Alive;
import Lieux.Batiment.Batiment;
import Lieux.Dehors.Dehors;
import Lieux.Lieu;
import Lieux.Piece.Piece;

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
        System.out.println(this.getNom() +": Hihihi ! Je sens une force bienveillante à vomir dans cette chapelle!"); 
    }
    
    
    public String getRace(){
        return new String("Sorcier");
    }
    
    @Override
    public void fouiller(Piece position){
        if(position.getBonbon() != 0){
            if(position.getNom().compareTo(enums.maison_hantee.cave.getLieu()) == 0) position.setBonbon(position.getBonbon()*2); //application du bonus raciale
            bonbons+=position.getBonbon();
            System.out.println(this.getNom() +": Gnihihi~ voilà " + position.getBonbon() + " nouveaux bonbons pour ma potion !");
            position.setBonbon(0);
            System.out.println(this.getNom() +": " +this.bonbons + " au total pour cette année !");
        }
        else{
            System.out.println(this.getNom() +": Aaaah... Mes potions ont besoins de bonbons, dommage qu'il n'y en ai plus ici...");
        }

    }
    
    @Override
    public void seDeplacer(Lieu position, Lieu cible){
        if(cible.getNom().compareTo(enums.eglise.chapelle.getLieu()) == 0){
            this.Crier();
        }
        else{
            position.delPersonnages(this);
            cible.addPersonnages(this);
        }
    }
}

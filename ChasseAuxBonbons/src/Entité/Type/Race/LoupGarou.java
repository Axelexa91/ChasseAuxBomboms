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
public abstract class LoupGarou extends Alive {

    public LoupGarou(String Nom) {
        super(Nom);
    }
    @Override
    public void Crier() {
        System.out.println(this.getNom() + ": Grrrrr ! Je n'aime pas les services en argent de cette cuisine !"); 
    }
    
    
    public String getRace(){
        return new String("Loup-Garou");
    }
    
    @Override
    public void fouiller(Piece position){
        if(position.getBonbon() != 0){
            if(position.getNom().compareTo(enums.boucherie.abattoir.getLieu()) == 0) position.setBonbon(position.getBonbon()*2); //application du bonus raciale
            bonbons+=position.getBonbon();
            System.out.println(this.getNom() +": Ahouu~ ! J'ai trouvé " + position.getBonbon() + " bonbons !");
            position.setBonbon(0);
            System.out.println(this.getNom() +": Ca m'en fait " + this.bonbons);
        }
        else{
            System.out.println(this.getNom() +": Grrrr ! Qu'est-ce que je vais me mettre sous la dent s'il n'y a plus de bonbons ici ?");
        }

    }
    
    @Override
    public void seDeplacer(Lieu position, Lieu cible){
        if(cible.getNom().compareTo(enums.maison_hantee.cuisine.getLieu()) == 0){
            this.Crier();
        }
        else{
            position.delPersonnages(this);
            cible.addPersonnages(this);
        }
    }
}

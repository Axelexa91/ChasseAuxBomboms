/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieux.Dehors;

import Lieux.Batiment.Batiment;
import Lieux.Lieu;

/**
 *
 * @author axelz
 */
public class Dehors extends Lieu{

    public Dehors(String Nom) {
        super(Nom);
        Batiments = new Batiment[0];
    }

    Batiment[] Batiments;

    public Batiment[] getBatiments() {
        return Batiments.clone();
    }

    public void setBatiments(Batiment[] Batiments) {
        this.Batiments = Batiments;
    }
    
    public void addBatiment(Batiment Batiment){
        int Index = 0;
        Batiment[] newBatiments = new Batiment[this.Batiments.length+1];
        for(Batiment batimentActuel : this.Batiments){
            newBatiments[Index] = this.Batiments[Index];
            Index++;
        }
        newBatiments[Index+1] = Batiment;
        this.setBatiments(newBatiments);
        return;
    }
    
    
    
}

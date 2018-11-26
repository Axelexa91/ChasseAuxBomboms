/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type.Race.Genre;

import Entité.Entité;
import Entité.Type.Race.Vampire;
import Interfaces.Femelle;

/**
 *
 * @author axelz
 */
public class VampireFemelle extends Vampire implements Femelle {

    public VampireFemelle(String Nom) {
        super(Nom);
    }


    public void Voler(Entité monstre){
        if(!(monstre instanceof Vampire) ){
            this.bonbons += monstre.getBonbons();
            monstre.setBonbons(0);
            System.out.println(this.getNom() + " a volé tous les bonbons de " + monstre.getNom() +" ! ");
        }
        else{
            System.out.println("Ne volez pas vos amis !");
        }
    }

    @Override
    public String getNom() {
        return new String(this.getRace() +" "+ this.nom);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getBonbons() {
        return bonbons;
    }

    public void setBonbons(int bonbons) {
        this.bonbons = bonbons;
    }



    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type.Race.Genre;

import Entité.Entité;
import Entité.Type.Race.Zombie;
import Interfaces.Male;
import Lieux.Lieu;

/**
 *
 * @author axelz
 */
public class ZombieMale extends Zombie implements Male{

    public ZombieMale(String Nom) {
        super(Nom);
    }

    public void Attaquer(Entité Monstre, Lieu position){
        if(!(Monstre instanceof Zombie)){
            this.bonbons+= Monstre.getBonbons();
            Monstre.setBonbons(0);
            position.delPersonnages(Monstre);
            System.out.println(this.getNom() + " a machouillé " + Monstre.getNom() +" ! ");
        }
        else{
            System.out.println("Ne tuez pas vos amis !");
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

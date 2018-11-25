/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type.Race.Genre;

import Entité.Entité;
import Entité.Type.Race.Fantome;

/**
 *
 * @author axelz
 */
public class FantomeFemelle extends Fantome {

    public FantomeFemelle(String Nom) {
        super(Nom);
    }

 
    
    public void Voler(Entité monstre){
        if(!(monstre instanceof FantomeMale) ){
            this.bonbons += monstre.getBonbons();
            monstre.setBonbons(0);
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

    public Boolean getEstVivant() {
        return estVivant;
    }

    public void setEstVivant(Boolean estVivant) {
        this.estVivant = estVivant;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getBonbons() {
        return bonbons;
    }

    public void setBonbons(int bonbons) {
        this.bonbons = bonbons;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }



    @Override
    public void Parler(String paroles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}

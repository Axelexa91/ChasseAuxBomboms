/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type.Race.Genre;

import Entité.Entité;
import Entité.Type.Race.Vampire;
import Lieux.Lieu;

/**
 *
 * @author axelz
 */
public class VampireMale extends Vampire {

    public VampireMale(String Nom) {
        super(Nom);
    }

    void Attaquer(Entité Monstre, Lieu position){
        if(!(Monstre instanceof VampireFemelle)){
            this.bonbons+= Monstre.getBonbons();
            Monstre.setBonbons(0);
            position.delPersonnages(Monstre);
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

    public boolean isEstVivant() {
        return estVivant;
    }

    public void setEstVivant(boolean estVivant) {
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

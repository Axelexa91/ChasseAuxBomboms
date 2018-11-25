/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

import Lieux.Batiment.Batiment;
import Lieux.Dehors.Dehors;
import Lieux.Lieu;
import Lieux.Piece.Piece;

/**
 *
 * @author axelz
 */
public abstract class Entité {
    protected String nom;
    protected boolean estVivant;
    protected int defence;
    protected int bonbons;
    protected int pointsDeVie;
    public abstract void Parler(String paroles);
    public abstract void Crier();

    
    public abstract String getNom();
    
    public Entité(String Nom){
        this.nom = Nom;
        this.bonbons = 0;
    }
    
    public abstract void seDeplacer(Lieu position, Lieu cible);
    
    public void fouiller(Piece position){
        this.bonbons += position.getBonbon();
        position.setBonbon(0);
    }
    
    public Lieu[] voirDeplacement(Lieu position,Dehors Ville){
       if(position == Ville){
           return Ville.getBatiments();
       }
       else{
           if(position instanceof Batiment){
               return ((Batiment) position).getPieces();
           }
           else if(position instanceof Piece){
               System.err.println("Merci de donné le batiment actuel en parametre");
               return null;
           }
       }
       return null;
    }
    
    public void setBonbons(int nbBonbons){
        this.bonbons = nbBonbons;
    }
    
    public int getBonbons(){
        return this.bonbons;
    }

    
    @Override
    public String toString(){
        String str = "Je suis un objet de la " + this.getClass() + ", je m'appelle " + this.nom;
        return str;
  } 
}

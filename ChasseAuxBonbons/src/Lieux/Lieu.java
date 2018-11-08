/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieux;

import Entité.Entité;

/**
 *
 * @author axelz
 */
public class Lieu {
    
    public Lieu(String Nom){
        Nom = Nom;
        Personnages = new Entité[0];
    }
    
    
    
    String Nom;
    
    Entité[] Personnages;
    
    

    public String getNom() {
        return new String(Nom);
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public Entité[] getPersonnages() {
        return Personnages.clone();
    }

    public void setPersonnages(Entité[] Personnage) {
        this.Personnages = Personnage;
    }
    
    
    
    public void delPersonnages(Entité Personnage) {
        
        if(this.estPresent(Personnage)){
            int Index = 0;
            Entité[] newPersonnages = new Entité[this.Personnages.length-1];
            for (Entité personnagePresent : this.Personnages){
                if(personnagePresent != Personnage){
                    newPersonnages[Index] = this.Personnages[Index];
                }
            Index ++;
            }
            this.setPersonnages(newPersonnages);
            return;
        }
        else{
            System.err.println("Ce personnage n'est pas présent");
            return;
        }
        
    }
    
    public void addPersonnages(Entité Personnage){
        if(this.estPresent(Personnage)){
            System.err.println("Ce personnage est déjà présent");
            return;
        }
        else{
            int Index = 0;
            Entité[] newPersonnages = new Entité[this.Personnages.length+1];
            for (Entité personnageActuel : this.Personnages){
                newPersonnages[Index] = this.Personnages[Index];
                Index++;
            }
            newPersonnages[Index+1] = Personnage;
            this.setPersonnages(newPersonnages);
            return;
        }
    }
    
    public boolean estPresent(Entité Personnage){
        int Index = 0;
        for(Entité personnagePresent : this.Personnages){
            if(personnagePresent == Personnage){
                return true;
            }
            Index++;
        }
        return false;
    }
    
    
    
    
    
    
}

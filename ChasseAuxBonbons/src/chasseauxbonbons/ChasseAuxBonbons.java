/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chasseauxbonbons;

import Entité.Entité;
import Entité.Type.Race.Genre.*;

import Lieux.Batiment.*;
import Lieux.Piece.*;
import Lieux.Dehors.*;
import enums.batiments;

import java.util.Random;



/**
 *
 * @author axelz
 */
public class ChasseAuxBonbons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Dehors Ville = InitVille(5);
        System.out.println(Ville.getBatiments()[0].getPieces()[0].getBonbon() );
        printVille(Ville);
        
        
    }
    
    public static Dehors InitVille(int taille){
        enums.batiments ListeBatiments[] = enums.batiments.values();
        Dehors Ville = new Dehors("Ville");
        
        for(int i=0; i<taille;i++){
            Random rand = new Random();
            int randnumb = rand.nextInt(ListeBatiments.length); // nextint(max - min + 1)-min;
            Ville.addBatiment(InitBatiment(ListeBatiments[randnumb].getLieu()));
        }
        
        return Ville;
        
    }
    
    public static Batiment InitBatiment(String nom){
        
        //Enum ListePieces[];
        
        Batiment Batiment = new Batiment(nom);        
        Random rand = new Random();
        int nbPieces = rand.nextInt(5 - 2 +1)+ 2;
        
        if(enums.batiments.boucherie.getLieu().compareTo(nom) == 0){
            
            enums.boucherie ListePieces[] = enums.boucherie.values();
            
            for(int i =0;i<nbPieces;i++){
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length);        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        }
        else if(enums.batiments.eglise.getLieu().compareTo(nom) == 0){
            enums.eglise ListePieces[] = enums.eglise.values();
            
            for(int i =0;i<nbPieces;i++){
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length);        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        }
        else if(enums.batiments.maison_hantee.getLieu().compareTo(nom) == 0){
            enums.maison_hantee ListePieces[] = enums.maison_hantee.values();
            
            for(int i =0;i<nbPieces;i++){
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length);        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        } 
        else if(enums.batiments.prison.getLieu().compareTo(nom) == 0){
            enums.prison ListePieces[] = enums.prison.values();
            
            for(int i =0;i<nbPieces;i++){
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length);        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        }
        else{
            System.err.println("Pas de batiment de ce nom défini");
            return null;
        }
    }
    
    public static Piece InitPiece(String Nom){
        Random rand = new Random();
        int nbBonbons = rand.nextInt(5 - 1 +1)+ 1;
        
        Piece Piece = new Piece(Nom,nbBonbons);
        
        return Piece;
    }
    
    public static void printVille(Dehors Ville){
        System.out.println("La ville du nom de : " + Ville);
        for(Batiment batiment : Ville.getBatiments()){
            System.out.println("-" + batiment.getNom() +":");
            for(Piece piece : batiment.getPieces()){
                System.out.println("    -" + piece.getNom() +":" + piece.getBonbon() + " bonbons");
            }
        }
    }
    
    public static void InitHabitants(Dehors Ville){
        enums.prenomGarcon ListePrenomsGarcons[] = enums.prenomGarcon.values();
        enums.prenomFille ListePrenomsFilles[] = enums.prenomFille.values();
        int nbHabitant = Ville.getBatiments().length * 3;
        
        for(int i = 0; i<= nbHabitant; i++){
            Random rand = new Random();
            Entité habitant;
            int habitantType = rand.nextInt(10);
            switch(habitantType){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
            
            
            
        }
    }
}

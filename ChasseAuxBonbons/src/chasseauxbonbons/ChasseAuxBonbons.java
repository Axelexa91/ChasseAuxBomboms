/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chasseauxbonbons;

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
    public void main(String[] args) {

        Lieux.Dehors.Dehors Ville = InitVille(15);
        System.out.println(Ville.getBatiments()[0].getPieces());
               
        
    }
    
    public Dehors InitVille(int taille){
        enums.prenomGarcon ListePrenomsGarcons[] = enums.prenomGarcon.values();
        enums.prenomFille ListePrenomsFilles[] = enums.prenomFille.values();
        enums.batiments ListeBatiments[] = enums.batiments.values();
        Dehors Ville = new Dehors("Ville");
        
        for(int i=0; i<taille;i++){
            Random rand = new Random();
            int randnumb = rand.nextInt(ListeBatiments.length- 0 +1)+ 0; // nextint(max - min + 1)-min;
            Ville.addBatiment(InitBatiment(ListeBatiments[randnumb].getLieu()));
        }
        
        return Ville;
        
    }
    
    public Batiment InitBatiment(String nom){
        
        //Enum ListePieces[];
        
        Batiment Batiment = new Batiment(nom);        
        Random rand = new Random();
        int nbPieces = rand.nextInt(8 - 3 +1)+ 3;
        
        if(enums.batiments.boucherie.getLieu().compareTo(nom) == 0){
            
            enums.boucherie ListePieces[] = enums.boucherie.values();
            
            for(int i =0;i<nbPieces;i++){
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length+1)+0;        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        }
        else if(enums.batiments.eglise.getLieu().compareTo(nom) == 0){
            enums.eglise ListePieces[] = enums.eglise.values();
            
            for(int i =0;i<nbPieces;i++){
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length+1)+0;        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        }
        else if(enums.batiments.maison_hantee.getLieu().compareTo(nom) == 0){
            enums.maison_hantee ListePieces[] = enums.maison_hantee.values();
            
            for(int i =0;i<nbPieces;i++){
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length+1)+0;        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        } 
        else if(enums.batiments.prison.getLieu().compareTo(nom) == 0){
            enums.prison ListePieces[] = enums.prison.values();
            
            for(int i =0;i<nbPieces;i++){
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length+1)+0;        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        }
        else{
            System.err.println("Pas de batiment de ce nom défini");
            return null;
        }
    }
    
    public Piece InitPiece(String Nom){
        Random rand = new Random();
        int nbBonbons = rand.nextInt(5 - 1 +1)+ 1;
        
        Piece Piece = new Piece(Nom,nbBonbons);
        
        return Piece;
    }
    
}

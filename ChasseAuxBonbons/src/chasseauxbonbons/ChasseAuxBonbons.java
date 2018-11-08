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
        Lieux.Dehors.Dehors Ville = InitVille(15);
        System.out.println(Ville.getBatiments()[0].getPieces());
        
       
        
    }
    
    public static Dehors InitVille(int taille){
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
    
    public static Batiment InitBatiment(String Nom){
        enums.pieces ListePieces[] = enums.pieces.values();
        Batiment Batiment = new Batiment(Nom);
        
        Random rand = new Random();
        int nbPieces = rand.nextInt(8 - 3 +1)+ 3;
        
        for(int i =0;i<nbPieces;i++){
            Random rand1 = new Random();
            int nomPiece = rand.nextInt(ListePieces.length+1)+0;
            Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            
            
        }
        return Batiment;
    }
    
    public static Piece InitPiece(String Nom){
        Random rand = new Random();
        int nbBonbons = rand.nextInt(5 - 1 +1)+ 1;
        
        Piece Piece = new Piece(Nom,nbBonbons);
        
        
        
        
        
        return Piece;
    }
    
}


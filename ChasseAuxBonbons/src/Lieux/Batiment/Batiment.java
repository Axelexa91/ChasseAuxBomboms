/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieux.Batiment;

import Lieux.Lieu;
import Lieux.Piece.Piece;

/**
 *
 * @author axelz
 */
public class Batiment extends Lieu{

    public Batiment(String Nom) {
        super(Nom);
        this.Pieces = new Piece[0];
    }
    
    Piece[] Pieces;

    public Piece[] getPieces() {
        return Pieces.clone();
    }

    public void setPieces(Piece[] Pieces) {
        this.Pieces = Pieces;
    }
    
    public void addPiece(Piece Piece){
        int Index = 0;
        Piece[] newPieces = new Piece[this.Pieces.length+1];
        for(Piece pieceActuel : this.Pieces){
            newPieces[Index] = this.Pieces[Index];
            Index++;
        }
        newPieces[Index] = Piece;
        this.setPieces(newPieces);
        return;
    }
    
    
}

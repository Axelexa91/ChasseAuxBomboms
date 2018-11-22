/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieux.Piece;

import Lieux.Lieu;

/**
 *
 * @author axelz
 */
public class Piece extends Lieu{
    
    public Piece(String Nom,int bonbon) {
        super(Nom);
        this.bonbon = bonbon;
    }
    
    int bonbon;

    public int getBonbon() {
        return bonbon;
    }

    public void setBonbon(int bonbon) {
        this.bonbon = bonbon;
    }
    
    
}

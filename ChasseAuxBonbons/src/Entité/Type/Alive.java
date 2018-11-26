/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité.Type;

import Entité.Entité;


/**
 *
 * @author axelz
 */
public abstract class Alive extends Entité {

    public Alive(String Nom) {
        super(Nom);
    }
    public void chance(){
       this.bonbons++;
       System.out.println(this.getNom() + " a trouvé un bonbon par terre !");
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chasseauxbonbons;

import java.util.Scanner;


import Entité.Entité;
import Entité.Type.Alive;
import Entité.Type.Race.*;
import Entité.Type.Race.Genre.*;
import Entité.Type.Undead;
import Interfaces.Femelle;
import Interfaces.Male;

import Lieux.Batiment.*;
import Lieux.Piece.*;
import Lieux.Dehors.*;
import Lieux.Lieu;
import enums.batiments;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        
        Scanner saisieUtilisateur = new Scanner(System.in);
        
        System.out.println("Veuillez saisir un nom pour votre ville :"); 
        String nomVille = saisieUtilisateur.nextLine();
        
        System.out.println("Veuillez saisir le nombre de batiments dans " + nomVille); 
        int tailleVille = saisieUtilisateur.nextInt();
        
        Dehors Ville = InitVille(tailleVille, nomVille);
        
        printFichierTexte("..\\ville.txt");
        
        System.out.println("Bienvenue à " + Ville.getNom());
        
        //System.out.println(Ville.getBatiments()[0].getPieces()[0].getBonbon() );
        InitHabitants(Ville);
        
        System.out.println("Appuyer sur entrée..."); 
        saisieUtilisateur.nextLine();
        saisieUtilisateur.nextLine();
        
        printVille(Ville);
        int nbTours = 0;
        while(resteDesBonbons(Ville)){ //joue une partie jusqu'a epuisement des bonbons dans la ville
            //System.out.println("Appuyer sur entrée pour passer le tour " + (nbTours + 1)); 
            //saisieUtilisateur.nextLine(); //commenter cette ligne pour faire de grosses parties avec des tailles supérieur a 10
            nbTours++;
            //String test = keyboard.nextLine();
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            ActionsPNJ(Ville);//----------------------------------------------------------------------------------------------------------FONCTION PRINCIPALE QUI FAIT TOUT
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            System.out.println("Appuyer sur entrée pour passer le tour " + nbTours); 
            saisieUtilisateur.nextLine(); //commenter cette ligne pour faire de grosses parties avec des tailles supérieur a 10
            printVille(Ville);

        }
        System.out.println(nbTours + " tours de jeu avant la fin de la partie");
        classementFinal(Ville);
        printVille(Ville);
        
    }
    public static void printFichierTexte(String fichierTexte){
        try{
            InputStream flux=new FileInputStream(fichierTexte); 
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
            while ((ligne=buff.readLine())!=null){
                    System.out.println(ligne);
            }
            buff.close();
    }		
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public static Dehors InitVille(int taille, String nomVille){
        enums.batiments ListeBatiments[] = enums.batiments.values();
        Dehors Ville = new Dehors(nomVille);
        
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
        int nbBonbons = rand.nextInt(6 - 1 +1)+ 1;
        
        Piece Piece = new Piece(Nom,nbBonbons);
        
        return Piece;
    }
    
    public static void printVille(Dehors Ville){
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Dans la ville de " + Ville.getNom());
        
        System.out.print("  Personnages : ");
        for(Entité habitant : Ville.getPersonnages()){
            System.out.print(habitant.getNom() + "("+ habitant.getBonbons() +")" + ", ");
        }
        System.out.println();
        
        for(Batiment batiment : Ville.getBatiments()){
            System.out.println();
            System.out.println("    -" + batiment.getNom() +":");
                System.out.print("      Personnages : ");
                for(Entité habitant : batiment.getPersonnages()){
                    System.out.print(habitant.getNom() + "("+ habitant.getBonbons() +")" + ", ");
                }
                System.out.println();
                
            for(Piece piece : batiment.getPieces()){
                System.out.println("       -" + piece.getNom() +":" +"["+ piece.getBonbon() +"]"+ " bonbons");
                System.out.print("          Personnages : ");
                for(Entité habitant : piece.getPersonnages()){
                    System.out.print(habitant.getNom() + "("+ habitant.getBonbons() +")" + ", ");
                }
                System.out.println();
            }
        }
    }

    public static void InitHabitants(Dehors Ville){
        enums.prenomGarcon ListePrenomsGarcons[] = enums.prenomGarcon.values();
        enums.prenomFille ListePrenomsFilles[] = enums.prenomFille.values();
        int nbHabitant = Ville.getBatiments().length * 3;
        
        for(int i = 0; i< nbHabitant; i++){
            Random rand = new Random();
            Entité habitant;
            int habitantType = rand.nextInt(10);
            String NomFille = ListePrenomsFilles[rand.nextInt(ListePrenomsFilles.length)].getPrenom();
            String NomGarcon = ListePrenomsGarcons[rand.nextInt(ListePrenomsGarcons.length)].getPrenom();
            switch(habitantType){
                case 0:
                    habitant = new FantomeFemelle(NomFille);
                    break;
                case 1:
                    habitant = new FantomeMale(NomGarcon);
                    break;
                case 2:
                    habitant = new LoupGarouFemelle(NomFille);
                    break;
                case 3:
                    habitant = new LoupGarouMale(NomGarcon);
                    break;
                case 4:
                    habitant = new SorcierFemelle(NomFille);
                    break;
                case 5:
                    habitant = new SorcierMale(NomGarcon);
                    break;
                case 6:
                    habitant = new VampireFemelle(NomFille);
                    break;
                case 7:
                    habitant = new VampireMale(NomGarcon);
                    break;
                case 8:
                    habitant = new ZombieFemelle(NomFille);
                    break;
                case 9:
                    habitant = new ZombieMale(NomGarcon);
                    break;
                default:
                    System.err.println("Aucun habitant généré, switch case");
                    habitant = null;
            }
            Ville.addPersonnages(habitant);
            
            
        }
    }

    
    public static void ActionsPNJ(Dehors Ville){
        
        Random rand = new Random();
        int quantiteMouvement = 4; // represente le nombres aproximatif de PNJ bougeant chaque tour en 1/quantiteMouvment : 1 -> ilsbougent tous, 2 -> environ a moitié, 3 -> environ un tier etc...
        int index = 0;
        
        for(Batiment batimentActuel : Ville.getBatiments()){
            for(Piece pieceActuel : batimentActuel.getPieces()){
                for(Entité personnageActuel : pieceActuel.getPersonnages()){
                    if(rand.nextInt(quantiteMouvement)+1 == quantiteMouvement){
                        Lieu[] listeDeplacementPossible = new Lieu[personnageActuel.voirDeplacement(batimentActuel, Ville).length+1];
                        int i = 0;
                        for(Lieu deplacement : personnageActuel.voirDeplacement(batimentActuel, Ville)){
                            listeDeplacementPossible[i] = deplacement;
                            i++;
                        }
                        listeDeplacementPossible[listeDeplacementPossible.length-1] = Ville;
                        Lieu pieceCible = listeDeplacementPossible[rand.nextInt(listeDeplacementPossible.length)];
                        personnageActuel.seDeplacer(pieceActuel, pieceCible);
                        if(pieceActuel instanceof Piece){ //normalement tjr le cas
                            personnageActuel.fouiller((Piece)pieceActuel);
                        }
                        if((pieceActuel.getPersonnages().length > 1) && (rand.nextInt(quantiteMouvement) != 0)){ //si il n'est pas seul et que l'envie lui prend
                            if(personnageActuel instanceof Male){ //attaquee s'il en a la possibilité
                                Entité cibleAttaque = pieceActuel.getPersonnages()[rand.nextInt(pieceActuel.getPersonnages().length)];
                                if(cibleAttaque != personnageActuel) ((Male) personnageActuel).Attaquer(cibleAttaque, pieceActuel);
                            }
                            else if(personnageActuel instanceof Femelle){ //sinon vole au lieu d'attauqer
                                Entité cibleVole = pieceActuel.getPersonnages()[rand.nextInt(pieceActuel.getPersonnages().length)];
                                if(cibleVole != personnageActuel) ((Femelle) personnageActuel).Voler(cibleVole);
                            }
                            if(personnageActuel instanceof Alive){ //plus activation d'un passif de type
                                ((Alive) personnageActuel).chance();
                            }
                            else if(personnageActuel instanceof Undead){
                                ((Undead) personnageActuel).FairePeur(pieceActuel);
                            }
                        }
                        
                    }
                }
            }
            for(Entité personnageActuel : batimentActuel.getPersonnages()){
                    if(rand.nextInt(quantiteMouvement)+1 == quantiteMouvement){
                        Lieu[] listeDeplacementPossible = new Lieu[personnageActuel.voirDeplacement(batimentActuel, Ville).length+1];
                        int i = 0;
                        for(Lieu deplacement : personnageActuel.voirDeplacement(batimentActuel, Ville)){
                            listeDeplacementPossible[i] = deplacement;
                            i++;
                        }
                        listeDeplacementPossible[listeDeplacementPossible.length-1] = Ville;
                        Lieu pieceCible = listeDeplacementPossible[rand.nextInt(listeDeplacementPossible.length)];
                        personnageActuel.seDeplacer(batimentActuel, pieceCible);
                        if((batimentActuel.getPersonnages().length > 1) && (rand.nextInt(quantiteMouvement) != 0)){ //si il n'est pas seul et que l'envie lui prend
                            if(personnageActuel instanceof Male){ //attaquee s'il en a la possibilité
                                Entité cibleAttaque = batimentActuel.getPersonnages()[rand.nextInt(batimentActuel.getPersonnages().length)];
                                if(cibleAttaque != personnageActuel) ((Male) personnageActuel).Attaquer(cibleAttaque, batimentActuel);
                            }
                            else if(personnageActuel instanceof Femelle){ //sinon vole au lieu d'attauqer
                                Entité cibleVole = batimentActuel.getPersonnages()[rand.nextInt(batimentActuel.getPersonnages().length)];
                                if(cibleVole != personnageActuel) ((Femelle) personnageActuel).Voler(cibleVole);
                            }
                            if(personnageActuel instanceof Alive){ //plus activation d'un passif de type
                                ((Alive) personnageActuel).chance();
                            }
                            else if(personnageActuel instanceof Undead){
                                ((Undead) personnageActuel).FairePeur(batimentActuel);
                            }
                        }
                    }
                }
        }
        for(Entité personnageActuel : Ville.getPersonnages()){
                    if(rand.nextInt(quantiteMouvement)+1 == quantiteMouvement){
                        Lieu[] listeDeplacementPossible = new Lieu[personnageActuel.voirDeplacement(Ville, Ville).length];
                        int i = 0;
                        for(Lieu deplacement : personnageActuel.voirDeplacement(Ville, Ville)){
                            listeDeplacementPossible[i] = deplacement;
                            i++;
                        }
                        Lieu pieceCible = listeDeplacementPossible[rand.nextInt(listeDeplacementPossible.length)];
                        personnageActuel.seDeplacer(Ville, pieceCible);
                        if((Ville.getPersonnages().length > 1) && (rand.nextInt(quantiteMouvement) != 0)){ //si il n'est pas seul et que l'envie lui prend
                            if(personnageActuel instanceof Male){ //attaquee s'il en a la possibilité
                                Entité cibleAttaque = Ville.getPersonnages()[rand.nextInt(Ville.getPersonnages().length)];
                                if(cibleAttaque != personnageActuel) ((Male) personnageActuel).Attaquer(cibleAttaque, Ville);
                            }
                            else if(personnageActuel instanceof Femelle){ //sinon vole au lieu d'attauqer
                                Entité cibleVole = Ville.getPersonnages()[rand.nextInt(Ville.getPersonnages().length)];
                                if(cibleVole != personnageActuel) ((Femelle) personnageActuel).Voler(cibleVole);
                            }
                            if(personnageActuel instanceof Alive){ //plus activation d'un passif de type
                                ((Alive) personnageActuel).chance();
                            }
                            else if(personnageActuel instanceof Undead){
                                ((Undead) personnageActuel).FairePeur(Ville);
                            }
                        }
                    }
                }
        
        
        
    }

    public static boolean resteDesBonbons(Dehors Ville){
        for(Batiment batimentActuel : Ville.getBatiments()){
            for(Piece pieceActuel : batimentActuel.getPieces()){
                if (pieceActuel.getBonbon() != 0) return true;
            }
        }
        return false;
    }

    public static void classementFinal(Dehors Ville){
        for(Batiment batimentActuel : Ville.getBatiments()){
            for(Piece pieceActuel : batimentActuel.getPieces()){
                for(Entité personnageActuel : pieceActuel.getPersonnages()){
                    personnageActuel.seDeplacer(pieceActuel, Ville);
                }
            }
            for(Entité personnageActuel : batimentActuel.getPersonnages()){
                    personnageActuel.seDeplacer(batimentActuel, Ville);
                }
        }
        boolean trieEnCours = true;
        Entité[] classement = Ville.getPersonnages();
        while(trieEnCours){
            trieEnCours = false;
            
            for(int index = 0; index < classement.length-1; index++){
                if( classement[index].getBonbons() < classement[index+1].getBonbons()){
                    Entité tampon = classement[index];
                    classement[index] = classement[index+1];
                    classement[index+1] = tampon;
                    trieEnCours = true;
                }
            }
        }
        Ville.setPersonnages(classement);
    }

}

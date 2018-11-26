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
        
        System.out.println("Veuillez saisir le nombre de batiments dans " + nomVille +" (entre 2 et 5 pour une experience optimal mettre 3) "); 
        int tailleVille = saisieUtilisateur.nextInt();
        
        Dehors Ville = InitVille(tailleVille, nomVille); //initialisation de la ville
        
        printFichierTexte("..\\ville.txt");//affichage d'une image ascii
        
        System.out.println("Bienvenue à " + Ville.getNom());
        
        //System.out.println(Ville.getBatiments()[0].getPieces()[0].getBonbon() );
        InitHabitants(Ville);
        
        System.out.println("Appuyer sur entrée..."); 
        saisieUtilisateur.nextLine();
        saisieUtilisateur.nextLine();//unse seule semblait pas suffire...
        
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
        classementFinal(Ville);
        printVille(Ville);
        System.out.println("Le vainqueur de la chasse de cette année est : " + Ville.getPersonnages()[0].getNom() + " !");
        System.out.println("Il n'a fallu que " + nbTours + " tours de jeu avant la fin de la partie !");
        
    }
    
 
    /**
     * Fonction qui affiche le contenu d'un fichier texte
     * @param fichierTexte 
     * @return rien
     */
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
    
    /**
     * Créé une ville et ses batiments
     * @param taille
     * @param nomVille
     * @return Dehors Ville
     */
    public static Dehors InitVille(int taille, String nomVille){
        enums.batiments ListeBatiments[] = enums.batiments.values(); //liste des batiments disponible
        Dehors Ville = new Dehors(nomVille);
        
        for(int i=0; i<taille;i++){
            Random rand = new Random();
            int randnumb = rand.nextInt(ListeBatiments.length); // nextint(max - min + 1)-min;
            Ville.addBatiment(InitBatiment(ListeBatiments[randnumb].getLieu()));//ajoute un batiment de nom aleatoire parmis les disponible
        }
        
        return Ville;
        
    }
    
    /**
     * Créé un batiment et ses pièces
     * @param nom
     * @return Batiment batiment
     */
    public static Batiment InitBatiment(String nom){
        
        //Enum ListePieces[];
        
        Batiment Batiment = new Batiment(nom);        
        Random rand = new Random();
        int nbPieces = rand.nextInt(5 - 2 +1)+ 2;
        
        if(enums.batiments.boucherie.getLieu().compareTo(nom) == 0){ //si on doit créé une boucherie
            
            enums.boucherie ListePieces[] = enums.boucherie.values(); //recuperation des pieces disponible dans une boucherie
            
            for(int i =0;i<nbPieces;i++){ //ajout d'un nombre aleatoire de pieces
                Random rand1 = new Random();
                int nomPiece = rand.nextInt(ListePieces.length);        
                Batiment.addPiece(InitPiece(ListePieces[nomPiece].getLieu()));
            }
            
        return Batiment;
        
        }
        else if(enums.batiments.eglise.getLieu().compareTo(nom) == 0){ //ou une eglise etc...
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
        else{ //au cas ou
            System.err.println("Pas de batiment de ce nom défini");
            return null;
        }
    }
    
    /**
     * Créé une pièce avec sees bonbons
     * @param Nom
     * @return Piece pièce
     */
    public static Piece InitPiece(String Nom){
        Random rand = new Random();
        int nbBonbons = rand.nextInt(6 - 1 +1)+ 1;//genere entre 1 et 6 bonbons
        
        Piece Piece = new Piece(Nom,nbBonbons);
        
        return Piece;
    }
    
    /**
     * Affiche la ville complete avec ses batiments et leurs pieces ainsi que l'emplacement de chaque habitant
     * @param Ville 
     */
    public static void printVille(Dehors Ville){
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Dans la ville de " + Ville.getNom());
        
        System.out.print("  Personnages : ");
        for(Entité habitant : Ville.getPersonnages()){ //tous les habitant dehors
            System.out.print(habitant.getNom() + "("+ habitant.getBonbons() +")" + ", ");
        }
        System.out.println();
        
        for(Batiment batiment : Ville.getBatiments()){ //pour chaque batiment de la ville
            System.out.println();
            System.out.println("    -" + batiment.getNom() +":");
                System.out.print("      Personnages : ");
                for(Entité habitant : batiment.getPersonnages()){ //tous les personnages a l'interieur de ce batiment qui ne sont pas encore dans une piece
                    System.out.print(habitant.getNom() + "("+ habitant.getBonbons() +")" + ", ");
                }
                System.out.println();
                
            for(Piece piece : batiment.getPieces()){ //pour chaque piece de ce batiment
                System.out.println("       -" + piece.getNom() +":" +"["+ piece.getBonbon() +"]"+ " bonbons");
                System.out.print("          Personnages : ");
                for(Entité habitant : piece.getPersonnages()){//tous les personnages de cettte piece
                    System.out.print(habitant.getNom() + "("+ habitant.getBonbons() +")" + ", ");
                }
                System.out.println();
            }
        }
    }

    /**
     * Fonction qui genere une quantité 5 fois supérieur d'habitant par rapport a la taille, dans une ville donnée
     * @param Ville
     */
    public static void InitHabitants(Dehors Ville){
        enums.prenomGarcon ListePrenomsGarcons[] = enums.prenomGarcon.values(); //les listes des prenoms a donné aux habitants
        enums.prenomFille ListePrenomsFilles[] = enums.prenomFille.values();
        int nbHabitant = Ville.getBatiments().length * 5; //quantité d'habitants
        
        for(int i = 0; i< nbHabitant; i++){
            Random rand = new Random();
            Entité habitant;
            int habitantType = rand.nextInt(10);
            String NomFille = ListePrenomsFilles[rand.nextInt(ListePrenomsFilles.length)].getPrenom();//on choisit un nom au hasard de chaque liste
            String NomGarcon = ListePrenomsGarcons[rand.nextInt(ListePrenomsGarcons.length)].getPrenom();
            switch(habitantType){ //et selon l'habitant generer on lui donne l'un des noms
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
                    System.err.println("Aucun habitant généré, switch case"); //en cas d'erreur 
                    habitant = null;
            }
            Ville.addPersonnages(habitant);
            
            
        }
    }

    /**
     * La fonction qui permet a tous les PNJ de faire la moindre actions, se deplacer, interagir avec la pieces ou les autres PNJ.
     * @param Ville 
     */
    public static void ActionsPNJ(Dehors Ville){
        
        Random rand = new Random();
        int quantiteMouvement = 4; // represente le nombres aproximatif de PNJ bougeant chaque tour en 1/quantiteMouvment : 1 -> ilsbougent tous, 2 -> environ a moitié, 3 -> environ un tier etc...
        int index = 0;
        
        for(Batiment batimentActuel : Ville.getBatiments()){//pour chaque batiment
            for(Piece pieceActuel : batimentActuel.getPieces()){//pour chaque piece de ce batimen
                for(Entité personnageActuel : pieceActuel.getPersonnages()){//on test le hasard pour voir si ce PNJ souhaite effectué une action ce tour
                    if(rand.nextInt(quantiteMouvement)+1 == quantiteMouvement){
                        Lieu[] listeDeplacementPossible = new Lieu[personnageActuel.voirDeplacement(batimentActuel, Ville).length+1]; //deplacement possible au sein du batiment
                        int i = 0;
                        for(Lieu deplacement : personnageActuel.voirDeplacement(batimentActuel, Ville)){
                            listeDeplacementPossible[i] = deplacement;
                            i++;
                        }
                        listeDeplacementPossible[listeDeplacementPossible.length-1] = Ville;//on oublie pas le deplacement possible pour retourner a la ville
                        Lieu pieceCible = listeDeplacementPossible[rand.nextInt(listeDeplacementPossible.length)]; //choix du deplacement
                        personnageActuel.seDeplacer(pieceActuel, pieceCible);//deplacement
                        if(pieceActuel instanceof Piece){ //normalement tjr le cas puiisqu'on est dans la boucle des pieces
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
            for(Entité personnageActuel : batimentActuel.getPersonnages()){ //maintenant qu'on a vu tous les personnages de la pieces, faisons ceux du batiment qui ne sont pas encore dans une piece avec les memes actions et decisions...
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
        for(Entité personnageActuel : Ville.getPersonnages()){//et enfin tous les personnages qui ne sont pas encore dans un batiments ou qui en sont sorti...
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

    /**
     * Verifie s'il reste des bonbons a recuperer dans la ville
     * @param Ville
     * @return 
     */
    public static boolean resteDesBonbons(Dehors Ville){
        for(Batiment batimentActuel : Ville.getBatiments()){
            for(Piece pieceActuel : batimentActuel.getPieces()){
                if (pieceActuel.getBonbon() != 0) return true; //verifie chaque piece de chaque batiment de la ville pour voir s'il reste le moindre bonbon
            }
        }
        return false;
    }

    /**
     * Fonction final mettant tous les personnages restant dans les pieces ou batiments dehors pour se faire classer dans un ordre decroissant, du meilleur score au plus bas
     * @param Ville 
     */
    public static void classementFinal(Dehors Ville){
        for(Batiment batimentActuel : Ville.getBatiments()){//pour chaque batiment de la ville
            for(Piece pieceActuel : batimentActuel.getPieces()){//et chaque piece de ces derniers
                for(Entité personnageActuel : pieceActuel.getPersonnages()){
                    personnageActuel.seDeplacer(pieceActuel, Ville);//ramener le personnage dehors
                }
            }
            for(Entité personnageActuel : batimentActuel.getPersonnages()){//ramener ceux des batiments
                    personnageActuel.seDeplacer(batimentActuel, Ville);
                }
        }
        boolean trieEnCours = true;
        Entité[] classement = Ville.getPersonnages(); //recuperation de la liste des personnages dehors
        while(trieEnCours){ //trie de cette liste
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
        Ville.setPersonnages(classement);//mise a jour de la liste des personnages dehors avec la liste des personnages triée
    }

}

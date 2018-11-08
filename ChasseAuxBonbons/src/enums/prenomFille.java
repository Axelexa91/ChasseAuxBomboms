/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Antoine
 */
public enum prenomFille {
    Alexia ("Alexia"),
    Alice ("Alice"),
    Alicia ("Alicia"),
    Amelie ("Amelie"),
    Anais ("Anais"),
    Annabelle ("Annabelle"),
    Arianne ("Arianne"),
    Audrey ("Audrey"),
    Aurelie("Aurelie"),
    Camille("Camille"),
    Catherine ("Catherine"),
    Charlotte ("Charlotte"),
    Chloe ("Chloe"),
    Clara ("Clara"),
    Coralie ("Coralie"),
    Daphnee ("Daphnee"),
    Delphine ("Delphine"),
    Elizabeth ("Elizabeth"),
    Elodie ("Elodie"),
    Emilie ("Emilie"),
    Emma ("Emma"),
    Emy ("Emy"),
    Eve ("Eve"),
    Florence ("Florence"),
    Gabrielle ("Gabrielle"),
    Jade ("Jade"),
    Juliette ("Juliette"),
    Justine ("Justine"),
    Laurence ("Laurence"),
    Laurie ("Laurie"),
    Lea ("Lea"),
    Leanne ("Leanne"),
    Maelie ("Maelie"),
    Maeva ("Maeva"),
    Maika ("Maika"),
    Marianne ("Marianne"),
    Marilou ("Marilou"),
    Maude ("Maude"),
    Maya ("Maya"),
    Megan ("Megan"),
    Melodie ("Melodie"),
    Mia ("Mia"),
    Noemie ("Noemie"),
    Oceane ("Oceane"),
    Olivia ("Olivia"),
    Rosalie ("Rosalie"),
    Rose ("Rose"),
    Sarah ("Sarah"),
    Sofia ("Sofia"),
    Victoria ("Victoria");
    
        String prenom;
        
    private prenomFille(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return new String(prenom);
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}

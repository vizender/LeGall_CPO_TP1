/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_legall;

/**
 *
 * @author victorlegall
 */
public class Joueur {
    String Nom;
    String Couleur;
    Jeton [] ListeJetons = new Jeton[21];
    int nombreJetonsRestants;
    int nombreDesintegrateurs;
    
    public Joueur(String newNom){
        Nom = newNom;
    }
    
    void affecterCouleur(String newColor) {
        Couleur = newColor;
    }
    
    boolean recevoirJeton() {
        if (nombreJetonsRestants>length(Jeton)){
            return false;
        }
    }
    
    void obtenirDesintegrateur() {
        
    }
    
    boolean utiliserDesintegrateur() {
        
    }
}

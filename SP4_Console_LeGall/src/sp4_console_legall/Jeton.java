/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_legall;

/**
 *
 * @author victorlegall
 */
public class Jeton {
    String Couleur;
    
    public Jeton(String newColor){
        Couleur = newColor;
    }
    String lireCouleur() {
        if (Couleur == "Rouge") {
            return "Rouge";
        }
        else if(Couleur == "Jaune") {
            return "Jaune";
        }
        else {
            return "ERREUR COULEUR";
        }
    }
}

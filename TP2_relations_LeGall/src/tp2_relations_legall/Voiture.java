/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_relations_legall;

/**
 *
 * @author victorlegall
 */
public class Voiture {
    String modele;
    String marque;
    int PuissanceCV;
    Personne proprietaire ;
    
    public Voiture(String newModele, String newMarque, int newPuissance) {
        modele=newModele;
        marque=newMarque;
        PuissanceCV=newPuissance;
        proprietaire=null;
    } 
    
    @Override
    public String toString() {
            return modele + " " + marque + " puissance : " + PuissanceCV + " cheveaux moteurs";
        }
}

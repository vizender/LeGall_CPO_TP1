/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_bieres_legall;

/**
 *
 * @author victorlegall
 */
public class TP2_Bieres_LeGall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BouteilleBiere uneBiere = new BouteilleBiere();
        uneBiere.nom="Cuvée des Trolls";
        uneBiere.degreAlcool=7.0;
        uneBiere.brasserie="Dubuisson";
        uneBiere.ouverte=false;
        uneBiere.lireEtiquette();
        BouteilleBiere Leffe = new BouteilleBiere();
        Leffe.nom="Leffe";
        Leffe.degreAlcool=6.6;
        Leffe.brasserie="Abaye de Leffe";
        Leffe.ouverte=true;
        Leffe.lireEtiquette();
        
        
    }
    
}

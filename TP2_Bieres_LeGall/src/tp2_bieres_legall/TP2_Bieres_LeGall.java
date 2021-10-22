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
     
    
    public static void main(String[] args) {
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls", 7.0 ,"Dubuisson") ;
        BouteilleBiere Leffe = new BouteilleBiere("Leffe", 6.6 ,"Abaye de Leffe") ;
        BouteilleBiere Heineken = new BouteilleBiere("Heineken", 6.0 ,"Cuvée Irlandaise") ;
        BouteilleBiere autreBiere = new BouteilleBiere("Cuvée BZH", 7.3 ,"BZH indépendante") ;
        uneBiere.decapsuler();
        uneBiere.decapsuler();
        System.out.println(uneBiere) ;
        System.out.println(Leffe) ;
        autreBiere.decapsuler();
        System.out.println(autreBiere) ;
        Heineken.lireEtiquette();
          
       

    }
}

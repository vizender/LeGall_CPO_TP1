/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_legall;

/**
 *
 * @author victorlegall
 */
public class SP4_Console_LeGall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Joueur Victor=new Joueur("Victor");
        Joueur Patrick=new Joueur("Patrick");
        Partie Jeu=new Partie(Victor, Patrick);
        Jeu.initialiserPartie();
        Jeu.debuterPartie();
    }
    
}

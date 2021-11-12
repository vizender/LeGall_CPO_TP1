/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_legall;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author victorlegall
 */
public class Partie {
    Random generateurAleat = new Random();
    Scanner sc = new Scanner(System.in);
    
    Joueur ListeJoueurs [] = new Joueur[2];
    Joueur joueurCourant;
    Grille grilleJeu;
    
    public Partie (Joueur J1, Joueur J2){
        ListeJoueurs[0]=J1;
        ListeJoueurs[1]=J2;
    }
    
    void attribuerCouleurAuxJoueurs(){
        // on fait un pile ou face pour la couleur des joueurs (aleatoire entre 0 et 1)
        Random r = new Random();
        int R = r.nextInt(2)%2;
        if (R==0){
            joueurCourant=ListeJoueurs[0];
            ListeJoueurs[0].Couleur="Rouge";
            ListeJoueurs[1].Couleur="Jaune";
            System.out.println(ListeJoueurs[0].Nom + " commence");
            joueurCourant=ListeJoueurs[0];
        }
        else {
            joueurCourant=ListeJoueurs[1];
            ListeJoueurs[0].Couleur="Jaune";
            ListeJoueurs[1].Couleur="Rouge";
            System.out.println(ListeJoueurs[1].Nom + " commence");
            joueurCourant=ListeJoueurs[1];
        }
    }
    
    void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        grilleJeu = new Grille();
        for (int i=0; i<ListeJoueurs[0].ListeJetons.length;i++){
            if (ListeJoueurs[0].Couleur=="Rouge"){
                ListeJoueurs[0].ListeJetons[i]=new Jeton("Rouge");
                ListeJoueurs[1].ListeJetons[i]=new Jeton("Jaune");
            }
            else {
                ListeJoueurs[1].ListeJetons[i]=new Jeton("Rouge");
                ListeJoueurs[0].ListeJetons[i]=new Jeton("Jaune");
            }
            ListeJoueurs[0].nombreJetonsRestants=ListeJoueurs[0].ListeJetons.length;
            ListeJoueurs[1].nombreJetonsRestants=ListeJoueurs[0].ListeJetons.length;
        }
    }
    
    void debuterPartie(){
        int i;
        boolean fin=false;
        while(fin==false){
            
            System.out.println("Tour de " + joueurCourant.Nom + ", "  + joueurCourant.nombreJetonsRestants + " jetons restants");
            
            do {
            i=sc.nextInt();
            } while(i<0 || i>6);
            
            if (grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], i)==true){
                joueurCourant.nombreJetonsRestants-=1;
                }
            
            grilleJeu.afficherGrilleSurConsole();
            if (grilleJeu.etreGagantPourJoueur(joueurCourant)==true || grilleJeu.etreRemplie()==true){ 
               fin=true; 
            }
            
            if (joueurCourant==ListeJoueurs[0]){
                joueurCourant=ListeJoueurs[1];
            }
            else {
                joueurCourant=ListeJoueurs[0];
            }
        }
        grilleJeu.afficherGrilleSurConsole();
    }           
}

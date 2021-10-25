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
        int i=generateurAleat.nextInt(1);
        if (i==0){
            ListeJoueurs[0].Couleur="Rouge";
            ListeJoueurs[1].Couleur="Jaune";
        }
        else {
            ListeJoueurs[1].Couleur="Rouge";
            ListeJoueurs[0].Couleur="Jaune";
        }
    }
    
    void initialiserPartie(){
        grilleJeu = new Grille();
        attribuerCouleurAuxJoueurs();
        for (int i=0; i<ListeJoueurs[0].ListeJetons.length;i++){
            if (ListeJoueurs[0].Couleur=="Rouge"){
                ListeJoueurs[0].ListeJetons[i]=new Jeton("Rouge");
                ListeJoueurs[1].ListeJetons[i]=new Jeton("Jaune");
            }
            else{
                ListeJoueurs[1].ListeJetons[i]=new Jeton("Rouge");
                ListeJoueurs[0].ListeJetons[i]=new Jeton("Jaune");
            }
            ListeJoueurs[0].nombreJetonsRestants=ListeJoueurs[0].ListeJetons.length;
            ListeJoueurs[1].nombreJetonsRestants=ListeJoueurs[0].ListeJetons.length;
        }
    }
    
    void debuterPartie(){
        while(grilleJeu.etreGagantPourJoueur(ListeJoueurs[0])==false && grilleJeu.etreGagantPourJoueur(ListeJoueurs[1])==false && grilleJeu.etreRemplie()==false){
            
            grilleJeu.afficherGrilleSurConsole();
            
            if (ListeJoueurs[0].Couleur=="Rouge"){
                System.out.println("Tour de " + ListeJoueurs[0].Nom);
                grilleJeu.ajouterJetonDansColonne(ListeJoueurs[0].ListeJetons[ListeJoueurs[0].nombreJetonsRestants-1], sc.nextInt());
                ListeJoueurs[0].nombreJetonsRestants-=1;
                
                grilleJeu.afficherGrilleSurConsole();
                
                System.out.println("Tour de " + ListeJoueurs[1].Nom);
                grilleJeu.ajouterJetonDansColonne(ListeJoueurs[1].ListeJetons[ListeJoueurs[1].nombreJetonsRestants-1], sc.nextInt());
                ListeJoueurs[1].nombreJetonsRestants-=1;
            }
            else {
                System.out.println("Tour de " + ListeJoueurs[1].Nom);
                grilleJeu.ajouterJetonDansColonne(ListeJoueurs[1].ListeJetons[ListeJoueurs[1].nombreJetonsRestants-1], sc.nextInt());
                ListeJoueurs[1].nombreJetonsRestants-=1;
                
                grilleJeu.afficherGrilleSurConsole();
                
                System.out.println("Tour de " + ListeJoueurs[0].Nom);
                grilleJeu.ajouterJetonDansColonne(ListeJoueurs[0].ListeJetons[ListeJoueurs[0].nombreJetonsRestants-1], sc.nextInt());
                ListeJoueurs[0].nombreJetonsRestants-=1;
            }
        }
        grilleJeu.afficherGrilleSurConsole();
    }
}

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
        
        //On place 5 trous noirs sur des coordonnées différentes aléatoires. Le while se fait tant 5 trous noirs de coordonnées différentes ne sont pas présents
        int k=0;
       // while (k<=5){
            Random r = new Random();
            int li = r.nextInt(5);
            int col = r.nextInt(6);
            grilleJeu.CellulesJeu[li][col].placerTrouNoir();
           // if (grilleJeu.CellulesJeu[li][col].trouNoir=false){
              //  grilleJeu.CellulesJeu[li][col].placerTrouNoir();
              //  k+=1;
           // }
        //}
        
        grilleJeu.afficherGrilleSurConsole();
        
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
        int ch;
        boolean fin=false;
        while(fin==false){
            
            System.out.println("Tour de " + joueurCourant.Nom + ", "  + joueurCourant.nombreJetonsRestants + " jetons restants; Voulez vous:\n1) Poser un jeton\n2) Recuperer un jeton");
            do{
                ch=sc.nextInt();
            }while(ch<1 || ch>2); // On attends que le joueur choisisse 1 oui 2
            
            
            if (ch==1){ // si il choisit 1, on pose un jeton normalement
                System.out.println("Selectionner la colonne :");
                do {
                    do {
                        i=sc.nextInt();
                    }while(grilleJeu.CellulesJeu[grilleJeu.CellulesJeu.length-1][i].jetonCourant!=null);
                } while(i<0 || i>6);

                if (grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], i)==true){
                    joueurCourant.nombreJetonsRestants-=1;
                    }

                grilleJeu.afficherGrilleSurConsole();
                if (grilleJeu.etreGagantPourJoueur(joueurCourant)==true || grilleJeu.etreRemplie()==true){ 
                   fin=true; 
                }
            }
            else if (ch==2){ // Si il veut recuperer le jeton
                int li;
                int co;
                do{
                    System.out.println("A quel ligne récuperer le jeton ? ");
                    li=sc.nextInt();
                    System.out.println("Quelle colonne ? ");
                    co=sc.nextInt();
                }while(grilleJeu.recupererJeton(li, co)==false && grilleJeu.CellulesJeu[li][co].recupererJeton().Couleur!=joueurCourant.Couleur);
                
                if(joueurCourant.ajouterJeton()==true);{
                joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants+1]=new Jeton(joueurCourant.Couleur);
            }
                grilleJeu.afficherGrilleSurConsole();
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

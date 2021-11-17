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
    Grille grilleJeu = new Grille();
    
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
        //Création des joueurs
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez le nom du joueur 1 : ");
        Joueur J1 = new Joueur(sc.nextLine());
        System.out.println("Donnez le nom de joueur 2 : ");
        Joueur J2 = new Joueur(sc.nextLine());
        ListeJoueurs[0] = J1;
        ListeJoueurs[1] = J2;
        
        attribuerCouleurAuxJoueurs();

        grilleJeu.viderGrille();
        
        //On place 3 trous noirs et 3 desintegrateurs sur des coord differentes
        for (int k= 0; k<3; k++){
            Random r = new Random();
            int i1 = r.nextInt(6);
            int j1 = r.nextInt(7);
            if (grilleJeu.CellulesJeu[i1][j1].trouNoir==true){ // On verifie que 2 trous noirs ne sont pas l'un sur l'autre
                k--; // Si oui, on relance un aleatoire
            }
            else {
                grilleJeu.CellulesJeu[i1][j1].placerTrouNoir(); 
            }
            
        }
        for (int k= 0; k<3; k++){
            Random r = new Random();
            int i1 = r.nextInt(6);
            int j1 = r.nextInt(7);
            if (grilleJeu.CellulesJeu[i1][j1].desintegrateur==true || grilleJeu.CellulesJeu[i1][j1].trouNoir==true){ // On verifie qu'il n'y a ni trou noir ni desintegrateur
                k--; // Si oui, on relance un aleatoire
            }
            else {
                grilleJeu.CellulesJeu[i1][j1].placerDesintegrateur();
            }
        }
        
        //On place ensuite les 2trous noirs/desintegrateurs
        for (int k= 0; k<2; k++){
            Random r = new Random();
            int i1 = r.nextInt(6);
            int j1 = r.nextInt(7);
            if (grilleJeu.CellulesJeu[i1][j1].desintegrateur==true || grilleJeu.CellulesJeu[i1][j1].trouNoir==true){ // On verifie qu'il n'y a ni trou noir ni desintegrateur
                k--; // Si oui, on relance un aleatoire
            }
            else {
                grilleJeu.CellulesJeu[i1][j1].placerTrouNoir();
                grilleJeu.CellulesJeu[i1][j1].placerDesintegrateur();
            }
        }
        
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
            System.out.println("Tour de " + joueurCourant.Nom + ", "  + joueurCourant.nombreJetonsRestants + " jetons restants, "+ joueurCourant.nombreDesintegrateurs + " desintegrateurs restants; Voulez vous:\n1) Poser un jeton\n2) Recuperer un de vos jeton");
            if (joueurCourant.nombreDesintegrateurs>=1){
                System.out.println("3) Utiliser un desintegrateur"); // le message s'affice seulement si on a un desintegrateur
            }
            do{
                ch=sc.nextInt();
            }while(ch<1 || ch>3); // On attends que le joueur choisisse 1 ou 2 voir 3 (mais si choisi 3 sans desintegrateur passe le tour)
            
            if (ch==1){ // si il choisit 1, on pose un jeton normalement
                System.out.println("Selectionner la colonne :");
                do {
                    do {
                        i=sc.nextInt();
                    } while(i<1 || i>7); // Tant que la colonne n'est pas valable
                }while(grilleJeu.CellulesJeu[grilleJeu.CellulesJeu.length-1][i].jetonCourant!=null); // tant que la colonne selectionnée est pleine
                
                if (grilleJeu.verifierDesintegrateur(i-1)==true){
                    joueurCourant.nombreDesintegrateurs+=1;
                }
                if (grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], i-1)==true ){
                    joueurCourant.nombreJetonsRestants-=1;
                    }
            }
            else if (ch==2){ // Si le joueur veut recuperer le jeton
                int li;
                int co;
                int act=0; // Variable act=action qui stop la boucle act=1 quand l'action est valable
                while (act==0){ // Le while(act) attends que le joueur recupere un des jetons de sa couleur
                    do{ // Le do{}while attends qu'on recupere un jeton, quelque soit la couleur (donc dans la grille)
                        System.out.println("A quel ligne récuperer le jeton ? ");
                        li=sc.nextInt();
                        System.out.println("Quelle colonne ? ");
                        co=sc.nextInt();
                        if(grilleJeu.CellulesJeu[li-1][co-1].lireCouleurDuJeton()!=joueurCourant.Couleur){
                            break; // On sort du do{}while;, on recommence la boucle while(act) tant que l'action (act) n'est pas valable
                        }
                        else{
                            act=1;
                        }
                    }while(grilleJeu.recupererJeton(li-1, co-1)==false);
                }
                if(joueurCourant.ajouterJeton()==true);{ // Si le joueur recupere un jeton, on le remets dans sa liste de jetons; On considere que pour recuperer un jeton sa liste doit avoir au moins 1 jeton en moins
                    joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants+1]=new Jeton(joueurCourant.Couleur);
                }  
            }
            if(joueurCourant.nombreDesintegrateurs>=1){
                if (ch==3){
                    int li;
                    int co;
                    do { //idem, condition etant que le jeton doit etre adverse
                            System.out.println("A quel ligne placer le desintegrateur? ");
                            li=sc.nextInt();
                            System.out.println("Quelle colonne ? ");
                            co=sc.nextInt();
                    } while (grilleJeu.CellulesJeu[li-1][co-1].lireCouleurDuJeton()==joueurCourant.Couleur || grilleJeu.CellulesJeu[li-1][co-1].jetonCourant==null);
                    grilleJeu.CellulesJeu[li-1][co-1].supprimerJeton();
                    grilleJeu.tasserGrille(li-1);
                    joueurCourant.utiliserDesintegrateur();
                }
            }
            
            grilleJeu.afficherGrilleSurConsole(); // On affiche la grille
            
            //Conditions de Victoire :
            if (grilleJeu.etreGagantPourJoueur(ListeJoueurs[0])==true && grilleJeu.etreGagantPourJoueur(ListeJoueurs[1])==true){ // Si les 2 gagnent en meme temps, le joueurCourant perds par faute de jeu
                if (joueurCourant==ListeJoueurs[0]){
                    System.out.println(ListeJoueurs[1].Nom + " gagne car " + ListeJoueurs[0].Nom + " a fait une faute");
                }
                else {
                    System.out.println(ListeJoueurs[0].Nom + " gagne car " + ListeJoueurs[1].Nom + " a fait une faute");
                }
                fin=true;
            }
            if (grilleJeu.etreGagantPourJoueur(ListeJoueurs[0])==true && grilleJeu.etreGagantPourJoueur(ListeJoueurs[1])==false){  //On verifie une victoire du J1
                System.out.println(ListeJoueurs[0].Nom + " gagne");
                fin=true;
            }
            if (grilleJeu.etreGagantPourJoueur(ListeJoueurs[1])==true && grilleJeu.etreGagantPourJoueur(ListeJoueurs[0])==false){  //On verifie une victoire du J2
                System.out.println(ListeJoueurs[1].Nom + " gagne");
                fin=true;
            }
            if (grilleJeu.etreRemplie()==true){ //On verifie une egalité
                System.out.println("Egalité, grille remplie");
            }
            
            //Changement de joueur
            if (joueurCourant==ListeJoueurs[0]){
                    joueurCourant=ListeJoueurs[1];
            }
            else {
                joueurCourant=ListeJoueurs[0];
            }
        }
    }           
}

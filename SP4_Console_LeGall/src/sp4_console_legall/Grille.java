/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_legall;

/**
 *
 * @author victorlegall
 */
public class Grille {
    // la grille un tableau a double entree
    Cellule [][] CellulesJeu = new Cellule[6][7];  //6 lignes, 7 colonnes, donc CelluleJeu[1]= premiere ligne, 
    
    //on initalise une grille vide
    public Grille(){
        for (int i =0; i<CellulesJeu.length; i++){
            for (int j =0; j<CellulesJeu[0].length; j++){
                CellulesJeu[i][j]=new Cellule();
            }
            
        }
    }
    
    //Ajouter un nouveau jeton
    boolean ajouterJetonDansColonne(Jeton newJeton, int colonne){
        for (int i = 0; i<CellulesJeu.length; i++){ // on parcours la colonne en partant du bas
            if (CellulesJeu[i][colonne].jetonCourant==null){
                CellulesJeu[i][colonne].jetonCourant=newJeton; //si la colonne n'a pas de jeton, on le rajoute
                return true;
            }
        }
        return false;
    }
    
    boolean etreRemplie() {
        for (int i =0; i<CellulesJeu.length; i++){
            for (int j =0; j<CellulesJeu[0].length; j++){
                if (CellulesJeu[i][j].jetonCourant==null){
                    return false;
                }
            }
            
        }
        return true;
    }
    
    boolean viderGrille(){
        for (int i =0; i<CellulesJeu.length; i++){ //On vide chaque colonne et ligne des jetons, trous noirs et desintegrateurs
            for (int j =0; j<CellulesJeu[0].length; j++){
                CellulesJeu[i][j].jetonCourant=null;
                CellulesJeu[i][j].trouNoir=false;
                CellulesJeu[i][j].desintegrateur=false;
            }
        }
        for (int i =0; i<CellulesJeu.length; i++){
            for (int j =0; j<CellulesJeu[0].length; j++){
                if (CellulesJeu[i][j].jetonCourant!=null || CellulesJeu[i][j].trouNoir==true || CellulesJeu[i][j].desintegrateur==true){ // on verifie la presence de quoique ce soit
                    return false; // si quelque chose, return false
                }
            }
            
        }
        return true; // si rien nest detecté, return true
    }
    
    void afficherGrilleSurConsole(){
        for (int i =0; i<CellulesJeu.length; i++){ //On vide chaque colonne et ligne des jetons, trous noirs et desintegrateurs
            for (int j =0; j<CellulesJeu[0].length; j++){
                if (CellulesJeu[i][j].jetonCourant==null){
                    System.out.print("  ");
                }
                else{
                    if (CellulesJeu[i][j].jetonCourant.Couleur=="Rouge"){
                        System.out.print("R ");
                    }
                    else if (CellulesJeu[i][j].jetonCourant.Couleur=="Jaune"){
                        System.out.print("J ");
                    }
                    else if (CellulesJeu[i][j].trouNoir==true){
                        System.out.print("N ");
                    }
                    else if (CellulesJeu[i][j].desintegrateur=true){
                        System.out.print("D ");
                    }
                }
            }
            System.out.println();
        }
    }
   
    //Verif de l'occupation par un jeton de la cellule
    boolean celluleOccupee(int colonne, int ligne){
        if (CellulesJeu[ligne][colonne].jetonCourant!=null){
            return false;
        }
        else {
            return true;
        }
    }
    
    String lireCouleurDuJeton(int colonne, int ligne){
        return CellulesJeu[ligne][colonne].lireCouleurDuJeton();
    }
    
    
    boolean etreGagnantPourJoueurLignes(Joueur player){
        for (int i =0; i<CellulesJeu.length; i++){
            for (int j =0; j<3; j++){
                if (CellulesJeu[i][j].jetonCourant!=null){ // on verifie le puissance 4 uniquement pour les cellules avec un jeton
                    if (CellulesJeu[i][j].jetonCourant==CellulesJeu[i][j+1].jetonCourant && CellulesJeu[i][j+1].jetonCourant==CellulesJeu[i][j+2].jetonCourant && CellulesJeu[i][j+2].jetonCourant==CellulesJeu[i][j+3].jetonCourant){
                        return true; // Si 4 jetons consecutifs sont egaux alors victore
                    }
                }
            }
        }
        return false; // si aucune victoire trouvée, on return false
    }
    
    boolean etreGagnantPourJoueurColonnes(Joueur player){ // fonction symetrique a avant, mais avec verif des colonnes
        for (int i =0; i<2; i++){ 
            for (int j =0; j<6; j++){
                if (CellulesJeu[i][j].jetonCourant!=null){
                    if (CellulesJeu[i][j].jetonCourant==CellulesJeu[i+1][j].jetonCourant && CellulesJeu[i+1][j].jetonCourant==CellulesJeu[i+2][j].jetonCourant && CellulesJeu[i+2][j].jetonCourant==CellulesJeu[i+3][j].jetonCourant){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    boolean etreGagnantPourJoueurDiagMontante(Joueur player){ //Verif des diagonales montantes (lecture de gauche a droite)
        for (int i =0; i<2; i++){ 
            for (int j =0; j<3; j++){
                if (CellulesJeu[i][j].jetonCourant!=null){
                    if (CellulesJeu[i][j].jetonCourant==CellulesJeu[i+1][j+1].jetonCourant && CellulesJeu[i+1][j+1].jetonCourant==CellulesJeu[i+2][j+2].jetonCourant && CellulesJeu[i+2][j+2].jetonCourant==CellulesJeu[i+3][j+3].jetonCourant){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    boolean etreGagnantPourJoueurDiagDescendante(Joueur player){ //Verif des diagonales montantes (lecture de gauche a droite)
        for (int i =3; i<5; i++){ 
            for (int j =0; j<3; j++){
                if (CellulesJeu[i][j].jetonCourant!=null){
                    if (CellulesJeu[i][j].jetonCourant==CellulesJeu[i-1][j+1].jetonCourant && CellulesJeu[i-1][j+1].jetonCourant==CellulesJeu[i-2][j+2].jetonCourant && CellulesJeu[i-2][j+2].jetonCourant==CellulesJeu[i-3][j+3].jetonCourant){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //On regroupe toutes les verifs en une seule
    boolean etreGagantPourJoueur(Joueur player){
        if (etreGagnantPourJoueurLignes(player)==true){
            return true;
        }
        else if (etreGagnantPourJoueurColonnes(player)==true){
            return true;
            }
        else if (etreGagnantPourJoueurDiagMontante(player)==true){
            return true;
        }
        else if (etreGagnantPourJoueurDiagDescendante(player)==true){
            return true;
        }
        else {
            return false;
        }
    }
    
    
}

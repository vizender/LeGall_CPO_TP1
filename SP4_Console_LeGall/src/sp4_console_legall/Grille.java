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
        int sc=0; 
        for (int i = 0; i<CellulesJeu[0].length; i++){ // on parcours la colonne en partant du bas
            if (CellulesJeu[colonne][i].jetonCourant!=null){
                sc+=1; // sc augmente uniquement si la colonne est pleine
            }
            else {
                CellulesJeu[colonne][i].jetonCourant=newJeton; //si la colonne n'a pas de jeton, on le rajoute
            }
        }
        if (sc==CellulesJeu[0].length){
            return false; // Si sc a augmenté le nombre de lignes, alors la colonne est pleine
        }  
        else {
            return true; // sinon, la colonne n'etait pas vide
        }
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
    
}

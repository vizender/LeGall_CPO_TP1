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
    Cellule [][] CellulesJeu = new Cellule[6][7];
    
    public Grille(){
        for (int i =0; i<CellulesJeu.length; i++){
            for (int j =0; j<CellulesJeu[0].length; j++){
                CellulesJeu[i][j]=new Cellule();
            }
            
        }
    }
    
    boolean ajouterJetonDansColonne(Jeton newJeton, int colonne){
        int sc=0;
        for (int i = 0; i<CellulesJeu[0].length; i++){
            if (CellulesJeu[colonne][i])
        }
    }
}

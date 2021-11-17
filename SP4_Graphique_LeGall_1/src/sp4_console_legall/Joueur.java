/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_legall;

/**
 *
 * @author victorlegall
 */
public class Joueur {
    //initialisation des attributs
    String Nom;
    String Couleur;
    Jeton [] ListeJetons = new Jeton[21];
    int nombreJetonsRestants;
    int nombreDesintegrateurs;
    
    //on nouveau joueur aura seleument son nom attribué
    public Joueur(String newNom){
        Nom = newNom;
    }
    
    //On affecte la couleur au joueur
    void affecterCouleur(String newColor) {
        Couleur = newColor;
    }
    
    //Le joueur peut recevoir des jetons jusqu'a une limite max (ici la taille de liste jeton, 21)
    boolean ajouterJeton() {
        if (nombreJetonsRestants>ListeJetons.length){
            return false;
        }
        else {
            nombreJetonsRestants+=1;
            return true;
        }
    }
    
    //obtenir un desintegrateur, pas de limite max
    void obtenirDesintegrateur() {
        nombreDesintegrateurs+=1;
    }
    
    //utiliser un desintegrateur uniquement si il y en a encore dispo
    boolean utiliserDesintegrateur() {
        if (nombreDesintegrateurs==0) {
            return false;
        }
        else {
            nombreDesintegrateurs-=1;
            return true;
        }
    }
}

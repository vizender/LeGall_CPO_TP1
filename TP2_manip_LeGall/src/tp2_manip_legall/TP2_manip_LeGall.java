/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_manip_legall;

/**
 *
 * @author victorlegall
 */
public class TP2_manip_LeGall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tartiflette assiette1 = new Tartiflette(500) ;
        Tartiflette assiette2 = new Tartiflette(600) ;
        Tartiflette assiett3 = assiette2; // correspond au meme objet car pas de "new"
        System.out.println(assiette1+ " " + assiette2);
        assiette2=assiette1;
        assiette1=assiett3;
        System.out.println(assiette1+ " " + assiette2);
        // Moussaka assiette666 = assiette1 ;
        // Moussaka assiette667 = new Tartiflette() ; ne marchent pas
        Moussaka assiette4 = new Moussaka(400);
        Moussaka assiette5 = new Moussaka(420);
        Moussaka assiette6 = new Moussaka(430);
        Moussaka assiette7 = new Moussaka(450);
        Moussaka assiette8 = new Moussaka(460);
        Moussaka assiette9 = new Moussaka(480);
        Moussaka assiette10 = new Moussaka(500);
        Moussaka assiette11 = new Moussaka(530);
        Moussaka assiette12 = new Moussaka(540);
        Moussaka assiette13 = new Moussaka(600);
        // on pourrait en effet relier des objets differents, avec un "lien de parenté", par exemple un menu qui appelle plusieurs plats : menu1.assiette500(300) donnerait le nombre de calories de l'assiette 500 du menu 1
        // La condition pour faire des relations est d'inclure l'enfant dans la classe du parent. On peut les lies dans les 2 sens.
        
    }
    
}

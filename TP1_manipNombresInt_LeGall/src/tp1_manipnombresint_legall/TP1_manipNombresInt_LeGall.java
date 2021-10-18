/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_manipnombresint_legall;

import java.util.Scanner;

/**
 *
 * @author victorlegall
 */
public class TP1_manipNombresInt_LeGall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //On initialise et scan les 2 entiers
        int n1=0; int n2=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Entrer le nombre n1 :");
        n1=sc.nextInt(); 
        System.out.println("\n Entrer le nombre n2 :");
        n2=sc.nextInt(); 
        
        //On affcihe somme, diff, produit :
        System.out.print("somme : "+(n1+n2) + "\ndifference : " + (n1-n2) + "\nproduit : " +(n1*n2) + "\n");
        //On affiche div euclidienne :
        System.out.print("Quotient : "+ (n1/n2) + "\nReste : " +(n1%n2) + "\n");
    }
    
}

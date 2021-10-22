/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_guessmynumber_legall;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author victorlegall
 */
public class TP1_guessMyNumber_LeGall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random generateurAleat = new Random();
        Scanner sc = new Scanner(System.in);
        
        //1
        int n1 = generateurAleat.nextInt(100);
        int n2 = generateurAleat.nextInt(100);
        int n3 = generateurAleat.nextInt(100);
        int n4 = generateurAleat.nextInt(100);
        int n5 = generateurAleat.nextInt(100);
        System.out.println(n1 + " " + n2 + " " +n3+ " " +n4+ " " +n5+ "\n");
        
        //2
        System.out.println("Choisir difficulté : \n1) Facile \n2) Normal \n3) Difficile");
        int nc=sc.nextInt();
        String mode="";
        switch (nc){
            case 1:
                nc=100;
                mode="Facile";
                break;
            case 2:
                nc=50;
                break;
            case 3:
                nc=10;
                break;
        }
        int ncherche = generateurAleat.nextInt(100);
        int nbj = 101;
        int nessais=0;
        while (nc>0 && nbj!=ncherche){
            nessais+=1;
            System.out.println(nc + " essais restant, donnez votre guess");
            nbj=sc.nextInt();
            if (nbj<ncherche){
                if (mode=="Facile" && nbj<ncherche-20){
                    System.out.println("Vraiment trop petit");
                }
                System.out.println("trop petit");
            }
            else if (nbj>ncherche){
                if (mode=="Facile" && nbj>ncherche+20){
                    System.out.println("Vraiment trop grand");
                }
                System.out.println("Trop Grand");
            }
            nc-=1;
        }
        System.out.println("Trouvé en " + nessais + " essais");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_stats_legall;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author victorlegall
 */
public class TP1_stats_LeGall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generateurAleat = new Random();
        
        int tab [] = new int[6];
        float tab1 [] = new float[6];
        System.out.println("rentrez un nombre entre 0 et 5");
        int m =sc.nextInt();
        for (int i=0;i<=m;i++){
            tab[i]+=generateurAleat.nextInt(5);
        }
        for (int i=0;i<=5;i++){
            for (int j=0;j<=5;j++){
                tab1[i]=0;
                if (j==tab1[i]){
                    tab1[i]+=1;
                }
                tab1[i]=tab1[i]/6*100;
        }
        }
        System.out.println("tab :" + tab[0] + " "+ tab[1] + " "+ tab[2] + " "+ tab[3] + " "+ tab[4]);
        System.out.println("tab1 en % :" + tab1[0] + " "+ tab1[1] + " "+ tab1[2] + " "+ tab1[3] + " "+ tab1[4]);
    }
    
}

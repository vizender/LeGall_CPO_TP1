/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_guessmynumber_legall;

import java.util.Random;

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
        
        //1
        int n1 = generateurAleat.nextInt(100);
        int n2 = generateurAleat.nextInt(100);
        int n3 = generateurAleat.nextInt(100);
        int n4 = generateurAleat.nextInt(100);
        int n5 = generateurAleat.nextInt(100);
        System.out.println((n1) + (n2) + (n3) + (n4) + (n5) "\n");     
    }
    
}

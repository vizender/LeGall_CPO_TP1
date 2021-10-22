/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_convertisseurobjet_legall;

import java.util.Scanner;

/**
 *
 * @author victorlegall
 */
public class TP2_convertisseurObjet_LeGall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Convertisseur convertisseur = new Convertisseur();
        Convertisseur conversion = new Convertisseur();
        convertisseur.CelciusVersFahrenheit(-20);
        convertisseur.KelvinVersCelcius(0);
        System.out.println(convertisseur);
        System.out.println("Bonjour, saisissez une valeur : ");
        double Temp=sc.nextDouble();
        System.out.println("Saisissez la conversion que vous souhaitez : \n1) Celcius vers Kelvin \n2) Kelvin vers Celcius \n3) Celcius vers Farhenheit \n4) Farenheit vers Celcius \n5) Kelvin vers Farheneit \n6) Farheneit vers Kelvin");
        int choix=sc.nextInt();
        
        switch(choix){
   
            case 1:
                conversion.CelciusVersKelvin(Temp);
            break;
            case 2:
                conversion.KelvinVersCelcius(Temp);
            break;
            case 3:
                conversion.CelciusVersFahrenheit(Temp);
            break;
            case 4:
                conversion.FahrenheitVersCelcius(Temp);
            break;
            case 5:
                conversion.KelvinVersFahrenheit(Temp);
            break;
            case 6:
                conversion.FahrenheitVersKelvin(Temp);
            break;
            default:
            break;
               
        }
    
}

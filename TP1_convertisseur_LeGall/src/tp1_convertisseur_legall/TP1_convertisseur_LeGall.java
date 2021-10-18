/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_convertisseur_legall;

import java.util.Scanner;

/**
 *
 * @author victorlegall
 */
public class TP1_convertisseur_LeGall {
    // On definit toutes les conversions :
    public static void CelciusVersKelvin (double tCelcius) { 
        System.out.print(tCelcius + "degrés Celcius font"+ (tCelcius+273) + " Kelvins");

    }
    public static void KelvinVersCelcius (double tKelvin) { 
        System.out.print(tKelvin + "degrés Kelvins font "+ (tKelvin-273) + " Celcius");
    }
    public static void FahrenheitVersCelcius (double tfar) { 
        System.out.print(tfar + "degrés Farhenheit font "+ ((tfar-32)*5/9) + " Celcius");
    }
    public static void FahrenheitVersKelvin (double tfar) { 
        System.out.print(tfar + "degrés Farhenheit font "+ (((tfar-32)*5/9)-273) + " Kelvin");
    }
    public static void CelciusVersFahrenheit (double tCelcius) { 
        System.out.print(tCelcius + "degrés Farhenheit font "+ ((tCelcius*9/5)+32) + " Celcius");
    }
    public static void KelvinVersFahrenheit (double tKelvin) { 
        System.out.print(tKelvin + "degrés Farhenheit font "+ (((tKelvin-273)*9/5)+32) + " Kelvin");
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //part 1
        double Temp;
        System.out.println("\n Entrer la temperature en Celcius :");
        Temp=sc.nextDouble();
        System.out.print("Temperature en : \nCelcius : " + Temp + "\nKelvin : " + (Temp+273) +"\n");
        
        //part 2
        int choix=0; //on demande le choix pour la conversion ensuite (entre 1 et 6)
        System.out.println("Bonjour, saisissez une valeur : ");
        Temp=sc.nextDouble();
        System.out.println("Saisissez la conversion que vous souhaitez : \n1) Celcius vers Kelvin \n2) Kelvin vers Celcius \n3) Celcius vers Farhenheit \n4) Farenheit vers Celcius \n5) Kelvin vers Farheneit \n6) Farheneit vers Kelvin");
        choix=sc.nextInt();
        
        switch(choix){
   
            case 1:
                CelciusVersKelvin(Temp);
            break;
            case 2:
                KelvinVersCelcius(Temp);
            break;
            case 3:
                CelciusVersFahrenheit(Temp);
            break;
            case 4:
                FahrenheitVersCelcius(Temp);
            break;
            case 5:
                KelvinVersFahrenheit(Temp);
            break;
            case 6:
                FahrenheitVersKelvin(Temp);
            break;
          
   }
    }
    
}

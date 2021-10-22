/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_convertisseurobjet_legall;

/**
 *
 * @author victorlegall
 */
public class Convertisseur {
    int nbConversions;
    public Convertisseur () {
        int nbConversions = 0 ;
    }
    public void CelciusVersKelvin (double tCelcius) { 
        nbConversions+=1;
        System.out.print(tCelcius + "degrés Celcius font"+ (tCelcius+273) + " Kelvins");
    }
    public void KelvinVersCelcius (double tKelvin) { 
        nbConversions+=1;
        System.out.print(tKelvin + "degrés Kelvins font "+ (tKelvin-273) + " Celcius");
    }
    public void FahrenheitVersCelcius (double tfar) { 
        nbConversions+=1;
        System.out.print(tfar + "degrés Farhenheit font "+ ((tfar-32)*5/9) + " Celcius");
    }
    public void FahrenheitVersKelvin (double tfar) { 
        nbConversions+=1;
        System.out.print(tfar + "degrés Farhenheit font "+ (((tfar-32)*5/9)-273) + " Kelvin");
    }
    public void CelciusVersFahrenheit (double tCelcius) { 
        nbConversions+=1;
        System.out.print(tCelcius + "degrés Farhenheit font "+ ((tCelcius*9/5)+32) + " Celcius");
    }
    public void KelvinVersFahrenheit (double tKelvin) { 
        nbConversions+=1;
        System.out.print(tKelvin + "degrés Farhenheit font "+ (((tKelvin-273)*9/5)+32) + " Kelvin");
    }
    
    @Override
        public String toString() {
            return "\nnb de conversions : "+ nbConversions;
        }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_manip_legall;

/**
 *
 * @author victorlegall
 */
public class Tartiflette {
    int nbCalories;
    public Tartiflette (int Cal) {
       nbCalories=Cal;
    }
    
    @Override
     public String toString() {
            return "\nnb de calories : "+ nbCalories;
        }
}

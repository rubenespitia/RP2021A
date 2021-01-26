/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author ruben
 */

public class PerceptronMultiCapa {

    public static void main(String[] args) {
     
        System.out.println("Entrada 1:");
        Scanner leerX1 = new Scanner(System.in);
        double x1 = Double.parseDouble(leerX1.next());
        
        System.out.println("Entrada 2:");
        Scanner leerX2 = new Scanner(System.in);
        double x2 = Double.parseDouble(leerX2.next());
      
        double w1 = new Random().nextDouble();
        double w2 = new Random().nextDouble();
        double w3 = new Random().nextDouble();
        double w4 = new Random().nextDouble();
        double w5 = new Random().nextDouble();
        double w6 = new Random().nextDouble();
    
        double θ1 = new Random().nextDouble();
        double θ2 = new Random().nextDouble();
        double θ3 = new Random().nextDouble();
  
        double y1 = Math.tanh((x1 * w1) + (x2 * w3) - θ1);
        double y2 = Math.tanh((x1 * w2) + (x2 * w4) - θ2);
        double y3 = Math.tanh((y1 * w5) + (y2 * w6) - θ3);
  
        System.out.println("Salida (y3) = " + y3);
    }
   
}

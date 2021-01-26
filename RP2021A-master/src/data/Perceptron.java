/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ruben
 */
import java.util.Random;

public class Perceptron {

    public static void main(String[] args) {
        double x1 = 1.3;
        double x2 = -0.54;
        double w1 = new Random().nextDouble();
        double w2 = new Random().nextDouble();

        Neurona n = new Neurona(x1, x2, w1, w2);

        System.out.println("Entrada 1: " + x1);
        System.out.println("Entrada 2: " + x2);
        System.out.println("Salida = " + n.getY1());
       
    }

}
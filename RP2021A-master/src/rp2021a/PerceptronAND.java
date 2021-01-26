/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

/**
 *
 * @author ruben
 */
import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class PerceptronAND {

    public static void main(String[] args) {
        int[][] tv = {{1, 1, 1}, {1, -1, -1}, {-1, 1, -1}, {-1, -1, -1}};//Tabla de verdad
        double w1 = new Random().nextDouble();
        double w2 = new Random().nextDouble();
        double θ = -0.4;
        double y = 0;
        final double E = 0.6;//Aprendizaje
        System.out.println("Aprendizaje de compuerta logica AND");
        int i = 0;
        int cont = 1;
        while (i < tv.length && cont < 10000) {
            y = Math.tanh((tv[i][0] * w1) + (tv[i][1] * w2) + (-1 * θ));
            y = (y >= θ) ? 1 : -1;           
            if (y == tv[i][2]) {
                i++;
            } else {
                w1 = w1 + 2 * E * tv[i][2] * tv[i][0];
                w2 = w2 + 2 * E * tv[i][2] * tv[i][1];
                θ = θ + 2 * E * tv[i][2] * (-1);
                cont++;
                i = 0;
            }
        }

        if (cont <= 9999) {
            System.out.println("Fase de aprendizaje terminada ");
           
            System.out.println("\nEntrada 1: ");
            Scanner leerX1 = new Scanner(System.in);
            double x1 = Double.parseDouble(leerX1.next());

            System.out.println("Entrada 2: ");
            Scanner leerX2 = new Scanner(System.in);
            double x2 = Double.parseDouble(leerX2.next());

            y = Math.tanh((x1 * w1) + (x2 * w2) + (-1 * θ));
            y = (y >= θ) ? 1 : -1;

            System.out.println("\nSalida: " + y);
        } else {
            System.out.println("\nFase de aprendizaje fallida\n");
        }

    }
}

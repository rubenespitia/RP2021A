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
import java.util.Scanner;

public class PerceptronXOR{

    public static void main(String[] args) {
        //Introducción manual de las entradas x1, x2.
        System.out.println("Introduce Entrada X1 (1,-1)): ");
        Scanner leerX1 = new Scanner(System.in);
        double x1 = Double.parseDouble(leerX1.next());
        System.out.println("Introduce Entrada X2 (1,-1): ");
        Scanner leerX2 = new Scanner(System.in);
        double x2 = Double.parseDouble(leerX2.next());
        //Pesos ya calibrados para la resolución de puertas XOR.
        double w11 = -1.942779536696304;//Pesos neurona 1
        double w12 = -2.4033439922084954;
        double θ1 = -2.2690966258542424;
        double w21 = 1.476484576128277;//Pesos neurona 2
        double w22 = 1.5285706752204653;
        double θ2 = -1.2654579142409594;
        double w31 = -2.7857541174718032;//Pesos neurona 3
        double w32 = -2.81730152144229;
        double θ3 = -2.52832962325685;
        //Calculo de las salidas de las neuronas
        double y1 = Math.tanh((x1 * w11) + (x2 * w12) + (1 * θ1));
        double y2 = Math.tanh((x1 * w21) + (x2 * w22) + (1 * θ2));
        double y3 = Math.tanh((y1 * w31) + (y2 * w32) + (1 * θ3));
        y3 = (y3 >= 0) ? 1 : -1;
        //Mostrar resultado
        System.out.println("Salida (y3) = " + (int) y3);
    }

}


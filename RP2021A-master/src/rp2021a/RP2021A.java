package rp2021a;

import clasificadores.CAP;
import clasificadores.KNNDistancia;
import clasificadores.NaiveBayes;
import data.Distancias;
import data.LeerDatos;
import data.Patron;
import java.util.ArrayList;
import lernmatrix.Clasificacion;
import ordenamientos.Burbuja;

/**
 *
 * @author Cri
 */
public class RP2021A {

    public static void main(String[] args) {
        
        
        //Codigo funcional para demostracion de Lernmatrix
        /*
        int noClases = 3;
        int dimensionVectores = 5;
        int x = 3, y = dimensionVectores;
        
        int[] vector1 = {1, 0, 1, 0, 1};      
        int[] vector2 = {1, 1, 0, 0, 1};
        int[] vector3 = {1, 0, 1, 1, 0};
        int[] vector4 = {0, 1, 0, 1, 1};
        int[] vector5 = {0, 0, 1, 0, 1};
        
        ArrayList vectores = new ArrayList();
        vectores.add(vector1);
        vectores.add(vector2);
        vectores.add(vector3);
        vectores.add(vector4);
        vectores.add(vector5);
        
        ArrayList clasificacion = new ArrayList();
        Clasificacion c = new Clasificacion(x, y);
        clasificacion = c.clasificacionLearnmatrix(vectores);
        
        for (int i = 0; i < clasificacion.size(); i++) {
            System.out.println("El vector "+i+" pertenece a la clase "+clasificacion.get(i));
        }
        */
        
        
        //Codigo funcional para demostracion de CAP
        
        int noClases = 3;
        int dimensionVectores = 4;
        int x = 4, y = dimensionVectores;
           
        double[] vector1_1 = {5.1,3.5,1.4,0.2};
        double[] vector1_2 = {4.9,3.0,1.4,0.2};
        double[] vector1_3 = {4.7,3.2,1.3,0.2};
        double[] vector1_4 = {4.6,3.1,1.5,0.2};
        double[] vector1_5 = {5.0,3.6,1.4,0.2};    
        
        double[] vector2_1 = {7.0,3.2,4.7,1.4};
        double[] vector2_2 = {6.4,3.2,4.5,1.5};
        double[] vector2_3 = {6.9,3.1,4.9,1.5};
        double[] vector2_4 = {5.5,2.3,4.0,1.3};
        double[] vector2_5 = {6.5,2.8,4.6,1.5};
        
        double[] vector3_1 = {7.1,3.0,5.9,2.1};
        double[] vector3_2 = {6.3,2.9,5.6,1.8};
        double[] vector3_3 = {6.5,3.0,5.8,2.2};
        double[] vector3_4 = {7.6,3.0,6.6,2.1};
        double[] vector3_5 = {4.9,2.5,4.5,1.7};
        
        double[] vectorClase1 = {5.1,3.5,1.4,0.2};
        double[] vectorClase2 = {7.0,3.2,4.7,1.4};
        double[] vectorClase3 = {6.3,3.3,6.0,2.5};
        
        ArrayList vectores = new ArrayList();
        vectores.add(vector1_1);
        vectores.add(vector1_2);
        vectores.add(vector1_3);
        vectores.add(vector1_4);
        vectores.add(vector1_5);
        
        vectores.add(vector2_1);
        vectores.add(vector2_2);
        vectores.add(vector2_3);
        vectores.add(vector2_4);
        vectores.add(vector2_5);
        
        vectores.add(vector3_1);
        vectores.add(vector3_2);
        vectores.add(vector3_3);
        vectores.add(vector3_4);
        vectores.add(vector3_5);
        
        ArrayList vectoresClase = new ArrayList();
        vectoresClase.add(vectorClase1);
        vectoresClase.add(vectorClase2);
        vectoresClase.add(vectorClase3);
        
        ArrayList vectoresClasificados = new ArrayList();
        
        CAP c = new CAP(x, y, noClases);
        vectoresClasificados = c.clasificacionAsociativaDePatrones(vectores, vectoresClase);
        
        for (int i = 0; i < vectoresClasificados.size(); i++) {
            System.out.println("El vector "+i+" pertenece a la clase "+vectoresClasificados.get(i)+".");
        }   
        
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lernmatrix;

import java.util.ArrayList;

/**
 *
 * @author Cri
 */
public class Clasificacion {
    int x;
    int y;
    
    public Clasificacion(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int[][] generarMatriz(){
        int[][] matriz = new int[x][y];
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matriz[i][j] = 0;
            }
        }
        
        return matriz;
    }   
    
    public ArrayList clasificacionLearnmatrix(ArrayList<int[]> vectores){
        int[][] matrizM = new int[x][y];
        ArrayList vectorR = new ArrayList();
        
        matrizM = faseAprendizaje(vectores);
        vectorR = faseRecuperacion(matrizM, vectores);

        int[] arregloAux;
        int aux = 0, aux2 = 0;
        int posicionMayor = 0;
        
        ArrayList clasifiaciones = new ArrayList();
        
        for (int i = 0; i < vectorR.size(); i++) {
            aux2 = 0;
            for (int j = 0; j < x; j++) {
                arregloAux = (int[]) vectorR.get(i);
                aux = arregloAux[j]; 
                if (aux > aux2){ 
                    posicionMayor = j; 
                }
                aux2 = aux; 
            }
            clasifiaciones.add(posicionMayor);
        }
        return clasifiaciones;
    }
    
    public int[][] faseAprendizaje(ArrayList<int[]> vectores){
        int[][] matriz = generarMatriz();
        
        if (vectores.size() == x){
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (vectores.get(i)[j] == 1){
                        matriz[i][j] = 1;
                    }else{
                        matriz[i][j] = -1;
                    }
                }    
            }
        }else{
            int aux = vectores.size() - x;
            
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (vectores.get(i)[j] == 1){
                        matriz[i][j] = 1;
                    }else{
                        matriz[i][j] = -1;
                    }
                }    
            }
            
            for (int i = x; i < vectores.size(); i++) {
                for (int j = 0; j < y; j++) {
                    if (vectores.get(i)[j] == 1){
                        matriz[i-x][j] += 1;
                    }else{
                        matriz[i-x][j] += -1;
                    } 
                }
            }      
        }
        return matriz;
    }
    
    public ArrayList faseRecuperacion(int[][] matriz, ArrayList<int[]> vectores){   
        ArrayList auxiliarMatriz = new ArrayList();
        ArrayList auxiliarVector = new ArrayList();         
        
        for (int c = 0; c < vectores.size(); c ++){
            int[][] matrizAux = generarMatriz();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {               
                    System.out.println();
                    matrizAux[i][j] = vectores.get(c)[j] * matriz[i][j];
                } 
            }
            auxiliarMatriz.add(matrizAux);           
        }
        int aux = 0;
        int[][] matrizAux2 = generarMatriz();
        
        for (int c = 0; c < auxiliarMatriz.size(); c++) {
            int[] vectorAux = new int[x];
            for (int i = 0; i < x; i++) {
                aux = 0;
                for (int j = 0; j < y; j++) {
                    matrizAux2 = (int[][]) auxiliarMatriz.get(c);
                    aux = aux + matrizAux2[i][j];
                }
                vectorAux[i] = aux;
            }
            
            auxiliarVector.add(vectorAux);
            
        }
        return auxiliarVector;
    }
}
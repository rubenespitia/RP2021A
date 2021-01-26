/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import data.Distancias;
import java.util.ArrayList;

/**
 *
 * @author Cri
 */
public class KNNDistancia {
    int k;
    String clase;
    
    public KNNDistancia(){
        
    }
    
    public KNNDistancia(int k){
        this.k = k;
    }

    public String getClase() {
        return clase;
    }
    
    public void clasificadorKNN(ArrayList<Distancias> distancias, String[] clases, int tamano){
        int[] contadores = new int[tamano];
        String aux1;
        String aux2;
        
        for (int i = 0; i < distancias.size()-1; i++) {
            aux2 = clases[0];
            aux1 = distancias.get(i).getClase();
            for (int j = 0; j < tamano; j++) {
                aux2 = clases[j];
                if (aux1.equals(aux2)){ 
                    contadores[j]++;
                    if (contadores[j] == k){
                        clase = clases[j];
                        
                        return;
                    }
                }
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientos;

import data.Distancias;
import java.util.ArrayList;

/**
 *
 * @author Cri
 */
public class Burbuja {
    public Burbuja() {
    }

   
    
    public void ordenarDatos(ArrayList<Distancias> datos) { 
        for (int i = 1; i < datos.size()-1; i++) {
            boolean is_sorted = true;
            
            for (int j= 0; j < datos.size()-1; j++){
                if (datos.get(j).getDistancia() > datos.get(j+1).getDistancia()){
                    double tempD = datos.get(j).getDistancia();
                    String tempS = datos.get(j).getClase();
                    
                    double auxD = datos.get(j+1).getDistancia();
                    String auxS = datos.get(j+1).getClase();
                     
                    datos.get(j).setDistancia(auxD);
                    datos.get(j).setClase(auxS);
                                       
                    datos.get(j+1).setDistancia(tempD);
                    datos.get(j+1).setClase(tempS);
               
                    is_sorted = false;
                }
            }
            if (is_sorted){
                return;
            }
        }
    }
    
    
    public int contadorClases(ArrayList<Distancias> distancias){
        int cont = 1;
        String claseAux = distancias.get(0).getClase();
        String claseAux2;
        
        for (int i = 0; i < distancias.size()-1; i++) {
            claseAux2 = distancias.get(i).getClase();
            if(!claseAux.equals(claseAux2)) {
                cont++;
                claseAux = distancias.get(i).getClase();
            }
        }
        
        return cont;
    }
    
    
    public String[] almacenadorClases(ArrayList<Distancias> distancias, int tamano){
        String[] clases = new String[tamano];
        int cont = 1;
        String claseAux = distancias.get(0).getClase();
        String claseAux2 = distancias.get(0).getClase();
        clases[0] = distancias.get(0).getClase();
        
        for (int i = 0; i < distancias.size()-1; i++) {
            claseAux2 = distancias.get(i).getClase();
            if(!claseAux.equals(claseAux2)) {
                clases[cont] = claseAux2;
                claseAux = distancias.get(i).getClase();
                cont++;
            }
        }
        return clases;
    }
}

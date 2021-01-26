/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Cri
 */
public class Distancias {
    private String clase;
    private double distancia;
    
    public Distancias(){        
    }

    public Distancias(String clase, double distancia) {
        this.clase = clase;
        this.distancia = distancia;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getClase() {
        return clase;
    }

    public double getDistancia() {
        return distancia;
    }
}

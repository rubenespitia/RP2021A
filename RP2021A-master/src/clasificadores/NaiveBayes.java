/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import data.ClaseBayes;
import data.Patron;
import interfaces.ClasificadorSupervisado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Cri
 */
public class NaiveBayes implements ClasificadorSupervisado {

    private ArrayList<Patron> instancias;
    private double[][] matrizMedias;
    private double[][] matrizVarianzas;
    private double[][] matrizDistribuciones;
    private double[] probPriori;
    private double[] probPosteriori;
    private Map<String,ClaseBayes> clases;
    

    public NaiveBayes() {
        this.clases = new HashMap<String,ClaseBayes>();
    }
    
    public void entrena(ArrayList<Patron> instancias) {
        this.instancias = instancias;
        // calcular la probabildiad a priori por cada clase
        this.clases.put(this.instancias.get(0).getClase(),new ClaseBayes(this.instancias.get(0).getClase()));
        
        // recorrer las instancias 
        for(Patron patron: instancias){
            // verifiar si existe una ClaseBayes con el nombre de la clase del patron
            if(!this.clases.containsKey(patron.getClase())){
               // si lo contiene lo acumula 
               this.clases.put(patron.getClase(),new ClaseBayes(patron.getClase()));
                          }
             this.clases.get(patron.getClase()).acumularAMedia(patron.getVectorC());
        }
       
        for(Entry<String,ClaseBayes> aux: this.clases.entrySet()){
            aux.getValue().calcularMedia();
            // aprovechando el ciclo for calculamos el apriori
            aux.getValue().calcularApriori(instancias.size());
        }
        // calculamos las varianzas
        for(Patron patron: instancias){
            // verifiar si existe una ClaseBayes con el nombre de la clase del patron
            String clase = patron.getClase();
            this.clases.get(clase).calcularVarianza(patron.getVectorC());
            
        }
               
    }

    public void clasifica(Patron patron) {
       // recibir el patron a clasificar 
       double[][] distribucion = 
          new double[this.clases.size()][patron.getVectorC().length];
       // calcular una matriz de distribuciones normales parametrizadas
       int r = 0;
       double evidencia=0;
       for(Entry<String,ClaseBayes> aux: this.clases.entrySet()){
           Patron media = aux.getValue().getMedia();
           Patron varianza = aux.getValue().getVarianza();
           double producto=aux.getValue().getApriori();
           for(int c=0;c<patron.getVectorC().length;c++){
           distribucion[r][c]= calcularDN(patron.getVectorC()[c],media.getVectorC()[c],varianza.getVectorC()[c]);
           producto*=distribucion[r][c];
           }
           evidencia+=producto;
           r++;
       }
       double psMayor = -1;
       r = 0;
       String clase ="";
       for(Entry<String,ClaseBayes> aux: this.clases.entrySet()){
           double producto=aux.getValue().getApriori();
           for(int c=0;c<patron.getVectorC().length;c++){
           producto*=distribucion[r][c];
           }
            r++;
           producto/=evidencia;
           // verficamos si es el mayor
           if(producto>psMayor){
           psMayor = producto;    
           clase = aux.getKey();
           }
       }
       patron.setClaseResultante(clase);
       System.out.println();
             
    }

    private double calcularDN(double c, double m, double v) {
        
        double div = 1/(Math.sqrt(2*Math.PI*v));
        double exp = Math.exp(-1*((Math.pow(c-m, 2))/(2*v)));
        double res = (div)*(exp); 
        return res;
     
    }

    @Override
    public void entranar(ArrayList<Patron> instancias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clasificar(ArrayList<Patron> instancias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

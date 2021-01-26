package clasificadores;

import java.util.ArrayList;

/**
 *
 * @author Cri
 */
public class CAP {
    int x;
    int y;
    int noClases;

    public CAP(int x, int y, int noClases) {
        this.x = x;
        this.y = y;
        this.noClases = noClases;
    }
    
    public double[][] generarMatriz(){
        double[][] matriz = new double[x][y];
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matriz[i][j] = 0;
            }
        }     
        return matriz;
    }
    
    public ArrayList clasificacionAsociativaDePatrones(ArrayList<double[]> vectores, ArrayList<double[]> vectoresClase){
        double[][] matrizC = new double[noClases][y];
        double[] vectorMedio = new double[x];
        ArrayList vectoresRecalculados = new ArrayList();
        ArrayList vectorR = new ArrayList();
        
        //Entrenamiento
        vectorMedio = calcularVectorMedio(vectoresClase); 
        vectoresRecalculados = recalcularVectores(vectoresClase, vectorMedio); 
        matrizC = faseAprendizaje(vectoresRecalculados); 
        
        //Clasificacion
        vectoresRecalculados = recalcularVectores(vectores, vectorMedio); 
        
        vectorR = faseRecuperacion(vectoresRecalculados, matrizC); 
        double[] arregloAux;
        double aux = 0, aux2 = 0;
        
        ArrayList clasifiaciones = new ArrayList();
        
        for (int i = 0; i < vectorR.size(); i++) {
            aux2 = 0;
            int posicionMayor = 0;
            for (int j = 0; j < noClases; j++) {
                arregloAux = (double[]) vectorR.get(i);
                aux = arregloAux[j];               
                if (aux > aux2){
                    posicionMayor = j; 
                    aux2 = aux; 
                }
            }
            clasifiaciones.add(posicionMayor);
            posicionMayor = 0;
        }
        System.out.println();
        return clasifiaciones;
    }
    
    public double[] calcularVectorMedio(ArrayList<double[]> vectores){
        double[] vector = new double[x];
        double p = noClases;
        
        p = 1/p;
        
        for (int i = 0; i < vectores.size(); i++) {
            for (int j = 0; j < x; j++) {
                vector[j] = (vector[j] + vectores.get(i)[j]);
            }
        }
        
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * (p);
        }
        return vector;
    }
    
    public ArrayList<double[]> recalcularVectores(ArrayList<double[]> vectores, double[] vectorMedio){
        ArrayList vectoresModificados = new ArrayList();
        
        for (int i = 0; i < vectores.size(); i++) {
            double[] vectorAux = new double[x];
            for (int j = 0; j < x; j++) {
                vectorAux[j] = vectores.get(i)[j] - vectorMedio[j];
            }
            vectoresModificados.add(vectorAux);
        }    
        return vectoresModificados;
    }
    
    public double[][] faseAprendizaje(ArrayList<double[]> vectores){
        double[][] matrizC = new double[vectores.size()][y];

        for (int i = 0; i < vectores.size(); i++) {
            double[] vectorAux  = new double[x];
            for (int j = 0; j < y; j++) {
                vectorAux[j] = vectores.get(i)[j];
                matrizC[i][j] = vectorAux[j];
            }
        }          
        return matrizC;
    }
    
    public ArrayList faseRecuperacion(ArrayList<double[]> vectores, double[][] matrizC){
        ArrayList auxiliarMatriz = new ArrayList();
        ArrayList auxiliarVector = new ArrayList();         
        
        for (int c = 0; c < vectores.size(); c ++){
            double[][] matrizAux = new double[noClases][y];
            for (int i = 0; i < noClases; i++) {
                for (int j = 0; j < y; j++) {                    
                    matrizAux[i][j] = vectores.get(c)[j] * matrizC[i][j];
                } 
            }
            auxiliarMatriz.add(matrizAux);           
        }
        double aux = 0;
        double[][] matrizAux2 = generarMatriz();
        
        for (int c = 0; c < auxiliarMatriz.size(); c++) {
            double[] vectorAux = new double[noClases];
            for (int i = 0; i < noClases; i++) {
                aux = 0;
                for (int j = 0; j < y; j++) {
                    matrizAux2 = (double[][]) auxiliarMatriz.get(c);
                    aux = aux + matrizAux2[i][j];
                }
                vectorAux[i] = aux;
            }
            auxiliarVector.add(vectorAux);     
        }
        return auxiliarVector;
    }
}
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
public class ClaseBayes {
    private String nombre;
    private Patron media;
    private Patron varianza;
    private int numInstancias;
    private double apriori;

    public ClaseBayes(String nombre) {
        this.nombre = nombre;
        this.numInstancias = 0;
        this.media = null;
        this.apriori = 0;
        this.varianza = null;
    }
    
    public void acumularAMedia(double[] patron){
       if(this.media==null){
           this.media = new Patron(patron.length);
           this.media.setClase(nombre);
       }
       this.numInstancias++;
       // se acumula 
       for(int x=0; x<patron.length;x++){
           this.media.getVectorC()[x]+=patron[x];
       }
      
    }
    
    public void calcularMedia(){
    // se recalcula la media 
       for(int x=0; x<media.getVectorC().length;x++){
           this.media.getVectorC()[x]/=numInstancias;
       }
    }
    public void calcularApriori(double aux){
        this.apriori = this.numInstancias/aux;
    }
    public void calcularVarianza(double[] patron){
    
      if(this.varianza==null){
           this.varianza = new Patron(patron.length);
           this.varianza.setClase(nombre);
       }
      // se acumula 
       for(int x=0; x<patron.length;x++){
           double resta = patron[x]-this.media.getVectorC()[x];
           double v = Math.pow(resta,2);
           this.varianza.getVectorC()[x]+=v/(numInstancias-1);
       }
         
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the media
     */
    public Patron getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Patron media) {
        this.media = media;
    }

    /**
     * @return the varianza
     */
    public Patron getVarianza() {
        return varianza;
    }

    /**
     * @param varianza the varianza to set
     */
    public void setVarianza(Patron varianza) {
        this.varianza = varianza;
    }

    /**
     * @return the numInstancias
     */
    public int getNumInstancias() {
        return numInstancias;
    }

    /**
     * @param numInstancias the numInstancias to set
     */
    public void setNumInstancias(int numInstancias) {
        this.numInstancias = numInstancias;
    }

    /**
     * @return the apriori
     */
    public double getApriori() {
        return apriori;
    }

    /**
     * @param apriori the apriori to set
     */
    public void setApriori(double apriori) {
        this.apriori = apriori;
    }

    @Override
    public boolean equals(Object obj) {
        String nombre = (String)obj;
        if(this.nombre==nombre)return true;
        
        return false; //To change body of generated methods, choose Tools | Templates.
    }
}

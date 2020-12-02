package onlinestore;

/**
 * Envelope. Classe filla de Package, encarregada de representar el paquet del 
 * tipus sobre.
 * 
 * Un paquet del tipus sobre vindrà definit pel seu nom. Estarà caracteritzat 
 * també pels atributs llargada i amplada de la classe pare donada la relació 
 * d'herència amb ella. Ara, pel lab 4 hem implementat un mètode que ens 
 * permetrà calcular el preu de cada sobre.
 */
public class Envelope extends Package {
    
    private String name;
    
    /**
     * Envelope(w, h, n). Constructor de Package. 
     * @param w atribut de Package, informa sobre l'amplada del paquet.
     * @param h atribut de Package, informa sobre la llargada del paquet.
     * @param n atribut d'Envelope, informa sobre el nom del sobre.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */ 
    public Envelope(int w, int h, String n){
        
        super(w ,h);
        name = n;
    }
    /**
     * getName(). Getter
     * @return String Retorna l'atribut name
     * (el nom del sobre).
     */    
    public String getName(){
        return name;
    }
    /**
     * setName(). Setter
     * @param n String representant el nom del sobre
     * (estableix el nom nom del sobre).
     */      
    public void setName(String n){
        name = n;
    }
    /**
     * isSuitable(). 
     * @param size representant les dimensions d'un producte Item
     * @return boolean
     * (Estudia si la instància actual de sobre pot ser usada per enviar un 
     * producte amb les dimensions indicades per size. Estudiarà com es comporta
     * el paquet segons com s'introdueix el producte; si hi cap dins retorna
     * cert, fals altrament).
     */      
    public boolean isSuitable(double[] size){
        double item_w = size[0];
        double item_h = size[1];
        if(this.getWidth() - item_w >= 0 && this.getHeight() - item_h >= 0){
            return true;
        }
        else if(this.getWidth() - item_h >= 0 && this.getHeight() - item_w >= 0){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * getPrice(). 
     * @return double
     * (implementem la funció definida a la classe pare: estableix el preu del 
     * sobre segons l'àrea d'aquest)
     */          
    @Override
    public double getPrice(){
        return (this.getHeight() * this.getWidth()) * 2/1189;
    }
}

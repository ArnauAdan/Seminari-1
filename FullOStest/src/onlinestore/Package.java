package onlinestore;
import fullonlinestore.Taxable;

/**
 *
 * @author Pau
 */

/**
 * Package. Classe encarregada de representar un paquet de la OnlineStore.
 * Un paquet estarà format per les seves dimensions amplada i llargada. Els 
 * productes o Items hauràn de ser enviats en paquets.
 * 
 * Tenim dos tipus de paquets: sobres i capses. Representarem les 
 * característiques especials de cadascun implementant-los com a classes 
 * filles de Package (Envelope i Box respectivament).
 */
public abstract class Package implements Taxable {
    
    private int width;
    private int height;
    private double cost;
    private double packsTax;
    
    /**
     * Package(w, h). Constructor de Package. 
     * @param w atribut de Package, informa sobre l'amplada del paquet.
     * @param h atribut de Package, informa sobre la llargada del paquet.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */    
    public Package(int w, int h){
        
        width = w;
        height = h;
    }
    /**
     * getWidth(). Getter
     * @return int Retorna l'atribut width
     * (l'amplada del paquet).
     */    
    public int getWidth(){
        return width;
    }
    /**
     * getHeight(). Getter
     * @return int Retorna l'atribut height
     * (la llargada del paquet).
     */        
    public int getHeight(){
        return height;
    }
    
    public double getCost(){
        return cost;
    }    
    /**
     * setWidth(). Setter
     * @param w int amplada
     * (estableix l'amplada del paquet).
     */    
    public void setWidth(int w){
        width = w;
    }
    /**
     * setHeight(). Setter
     * @param h int llargada
     * (estableix la llargada del paquet).
     */       
    public void setHeight(int h){
        height = h;
    }
    
    @Override
    public abstract double getPrice();
    
    @Override
    public double getPriceOnlyTax(){
        return this.getCost() * iva;
    }
    
    @Override
    public double getPricePlusTax(){
        return this.getCost() * (1 + iva);
    }
    
    @Override
    public double sumTotalTax(Taxable t){
        return packsTax += t.getPriceOnlyTax();
    } 
}

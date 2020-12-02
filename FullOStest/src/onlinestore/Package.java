package onlinestore;
import fullonlinestore.Taxable;

/**
 * Package. Classe encarregada de representar un paquet de la OnlineStore.
 * Un paquet estarà format per les seves dimensions amplada i llargada. Els 
 * productes o Items hauràn de ser enviats en paquets. 
 * 
 * Tenim dos tipus de paquets: sobres i capses. Representarem les 
 * característiques especials de cadascun implementant-los com a classes 
 * filles de Package (Envelope i Box respectivament). Ara, pel lab 4 implementem
 * la interfície Taxable, que ens permetrà dotar els paquets d'iva i de certes
 * funcions relacionades amb lìmpost. Declarem un atribut que ens ajudarà a 
 * mantenir en tot moment l'impost total en euros pels paquets.
 * 
 * Per tant, ara els paques tindràn un preu també.
 */
public abstract class Package implements Taxable {
    
    private int width;
    private int height;
    private double packsTax = 0;
    
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
    /**
     * getPrice(). double
     * (estableix el preu del paquet. Cada classe filla l'implementa de manera
     * diferent)
     */    
    @Override
    public abstract double getPrice();
    /**
     * getPriceOnlyTax(). double
     * @return double
     * (implementem el mètode de la interfície Taxable on obtenim l'import en 
     * euros del iva aplicat al paquet actual)
     */    
    @Override
    public double getPriceOnlyTax(){
        return this.getPrice() * iva;
    }
    /**
     * getPricePlusTax(). double
     * @return double
     * (implementem el mètode de la interfície Taxable on obtenim l'import total
     * en euros del preu del paquet juntament amb l'import d'iva)
     */    
    @Override
    public double getPricePlusTax(){
        return (this.getPrice() + (this.getPrice() *iva));
    }
    /**
     * sumTotalTax(). double
     * @return double
     * @param t objecte que implementi Taxable
     * (implementem el mètode de la interfície Taxable on obtenim la suma en 
     * euros de l'iva per cada paquet)
     */        
    @Override
    public double sumTotalTax(Taxable t){
        return packsTax += t.getPriceOnlyTax();
    }       
    /**
     * calculateProfit(). double
     * @return double
     * (aquest mètode calcula el benefici per la tenda per cada paquet. La tenda
     * ven els paquets la meitat més cars que el preu pel que els va comprar)
     */           
    public double calculateProfit(){
        return this.getPrice() * 0.5;
    }
}

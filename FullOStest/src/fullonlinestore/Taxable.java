package fullonlinestore;

/**
 * Taxable. Interfície encarregada de representar els comportaments que ha de
 * seguir qualsevol objecte imposable i definir el tant per cent que carrega 
 * aquest impost. Per aquest laboratori 4 voldrem establir l'impost d'iva pels 
 * items i paquets.
 */
public interface Taxable {
    public static final double iva = 0.21;
    /**
     * getPrice(). 
     * @return double
     * (ha de definir el benefici en euros pel paquet o producte a considerar)
     */     
    public double getPrice();
    /**
     * getPriceOnlyTax(). 
     * @return double
     * (ha de definir la quantitat en euros que carrega l'iva sobre el paquet
     * o producte a considerar)
     */        
    public double getPriceOnlyTax();
    /**
     * getPricePlusTax(). 
     * @return double
     * (ha de definir el benefici en euros pel paquet o producte a considerar
     * junt amb l'import carregat sobre aquest per l'iva)
     */         
    public double getPricePlusTax();
    /**
     * sumTotalTax(). 
     * @return double
     * @param t objecte imposable
     * (ha de definir la quantitat de benefici que s'emporta l'iva per cada 
     * classe imposable, o sigui, pels paquets i productes)
     */       
    public double sumTotalTax(Taxable t);
}

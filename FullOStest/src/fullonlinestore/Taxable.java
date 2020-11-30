package fullonlinestore;

/**
 *
 * @author Pau
 */
public interface Taxable {
    public static final double iva = 0.21;
    
    public double getPrice();
    
    public double getPriceOnlyTax();
    
    public double getPricePlusTax();
    
    public double sumTotalTax(Taxable t);
}

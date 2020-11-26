package onlinestore;

/**
 *
 * @author Pau
 */

/**
 * UnitItem. Classe filla d'Item, encarregada de representar el tipus de 
 * producte que es ven per unitats de la OnlineStore.
 * 
 * Un producte d'unitats estarà format pel seu preu per unitat, la seva 
 * quantitat i quantitat disponible. Estarà caracteritzat també pels atributs
 * nom, tipus, mida cost i tipus de la classe pare donada la relació d'herència
 * amb ella.
 */
public class UnitItem extends Item{
    
    private double unitPrice;
    private int quantity;
    private int quantityRemaining;
    
    /**
     * UnitItem(n, t, s, c, uprice, q). Constructor d'UnitItem. 
     * @param n atribut d'Item, informa sobre el nom del producte.
     * @param t atribut d'Item, informa sobre el tipus del producte.
     * @param s atribut d'Item, informa sobre les dimensions del producte.
     * @param c atribut d'Item, informa sobre el cost del producte.
     * @param uprice atribut d'UnitItem, informa sobre el preu de la unitat.
     * @param q atribut d'UnitItem, informa sobre la quantitat d'unitats del 
     * producte.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */
    public UnitItem(String n, String t, double[] s, double c, double uprice, int q){
        
        super(n, t, s, c);
        unitPrice = uprice;
        quantity = q;
        quantityRemaining = q;

    }
    /**
     * getPrice(). Override 
     * @return double preu del producte del tipus unitat.
     * (retornarà el preu pel producte uitat actual. El preu depèn del nombre
     * d'unitats que vulgui comprar l'usuari).
     */ 
    @Override
    public double getPrice(){
        return unitPrice * quantity;
    }
    /**
     * calculateProfit(). Override
     * @return double benefici en euros del producte tipus unitat.
     * (retornarà el benefici pel producte unitat actual. La tenda compra la 
     * unitat a un preu més baix llavors el benefici resulta en la diferència 
     * respecte el preu anunciat a l'usuari).
     */ 
    @Override
    public double calculateProfit(){
        return (unitPrice - super.getCost()) * quantity;
    }
    /**
     * sell().
     * @param q quantitat restant
     * @return double preu a pagar per totes les unitats existents.
     * (Per aquest laboratori, aquest mètode retorna el preu a pagar per totes
     * les unitats del producte i estableix la seva quantitat restant al nombre
     * q, que li donarem el valor 0. O sigui, per cada compra, la quantitat 
     * d'unitats comprades serà tota la restant).
     */ 
    public double sell(int q){
        quantityRemaining = q;
        if(quantityRemaining <= 0){
            System.out.println("All items left of " + this.getName() + " have been sold");
        }
        return quantity * unitPrice;
    }
}

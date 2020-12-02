package onlinestore;

/**
 * WeightedItem. Classe filla d'Item, encarregada de representar el tipus de 
 * producte que es ven per pes de la OnlineStore.
 * 
 * Un producte de pes estarà format pel seu preu per pes, la seva 
 * quantitat en pes i quantitat en pes disponible. Estarà caracteritzat també 
 * pels atributs nom, tipus, mida cost i tipus de la classe pare donada la 
 * relació d'herència amb ella.
 */
public class WeightedItem extends Item{
    
    private double pricePerWeight;
    private double weight;
    private double weightRemaining;
    
    /**
     * WeightedItem(n, t, s, c, wprice, w). Constructor de WeghtedItem. 
     * @param n atribut d'Item, informa sobre el nom del producte.
     * @param t atribut d'Item, informa sobre el tipus del producte.
     * @param s atribut d'Item, informa sobre les dimensions del producte.
     * @param c atribut d'Item, informa sobre el cost del producte.
     * @param wprice atribut de WeightedItem, informa sobre el preu del pes.
     * @param w atribut d'UnitItem, informa sobre la quantitat de pes del 
     * producte.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */
    public WeightedItem(String n, String t, double[] s, double c, double wprice, double w){
        
        super(n, t, s, c);
        pricePerWeight = wprice;
        weight = w;   
        weightRemaining = w;
    }
    /**
     * getPrice(). Override 
     * @return double preu del producte del tipus pes.
     * (retornarà el preu pel producte del tipus pes actual. El producte té un
     * preu/pes, per tant depèn de la quantitat de pes del producte que vulgui 
     * comprar l'usuari).
     */ 
    @Override
    public double getPrice(){
        return pricePerWeight * weight;
    }
    /**
     * calculateProfit(). Override
     * @return double benefici en euros del producte tipus pes.
     * (retornarà el benefici pel producte tipus pes actual. La tenda compra el 
     * pes a un preu més baix llavors el benefici resulta en la diferència 
     * respecte el preu/pes anunciat a l'usuari).
     */ 
    @Override
    public double calculateProfit(){
        return (pricePerWeight - this.getCost()) * weight;
    }
    /**
     * sell().
     * @param q quantitat restant
     * @return double preu a pagar per tot el pes existent.
     * (Per aquest laboratori, aquest mètode retorna el preu a pagar per tot
     * el pes del producte i estableix el seu pes restant al nombre q, que li 
     * donarem el valor 0. O sigui, per cada compra, la quantitat en 
     * pes comprada serà tota la restant).
     */ 
    public double sell(double q){
        weightRemaining = q;
        if(weightRemaining <= 0){
            System.out.println("All weight of " + this.getName() + " has been sold");
        }
        return weight * pricePerWeight;
    }
}

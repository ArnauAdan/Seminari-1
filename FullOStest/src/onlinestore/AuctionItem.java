package onlinestore;
import java.util.Calendar;

/**
 * AuctionItem. Classe filla d'Item, encarregada de representar el tipus de 
 * producte que es ven per subhasta de la OnlineStore.
 * 
 * Un producte de subhasta estarà format pel seu preu i licitador actuals, la 
 * data límit, una quota i un càrrec. Estarà caracteritzat també pels atributs
 * nom, tipus, mida cost i tipus de la classe pare donada la relació d'herència
 * amb ella. Per aquest lab implementem pels objectes de subhasta la classe
 * Calendar, que ens ajudarà a manegar de manera més còmode les dates d'aquests
 * objectes.
 */
public class AuctionItem extends Item {
    
    private double currentPrice;
    private Buyer bidder;
    private Calendar deadline;
    private static final double fee = 5;
    private static final double charge = 0.05;
    
    /**
     * AuctionItem(n, t, s, c, startingPrice, d). Constructor de AuctionItem. 
     * @param n atribut d'Item, informa sobre el nom del producte.
     * @param t atribut d'Item, informa sobre el tipus del producte.
     * @param s atribut d'Item, informa sobre les dimensions del producte.
     * @param c atribut d'Item, informa sobre el cost del producte.
     * @param startingPrice atribut de AuctionItem, informa sobre el preu 
     * inical del producte a subhastar.
     * @param d atribut de AuctionItem, informa sobre la data límit del producte
     * a subhastar.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */
    public AuctionItem(String n, String t, double[] s, double c, double startingPrice, Calendar d){
        
        super(n, t, s, c);
        currentPrice = startingPrice;
        deadline = d;
    }
    /**
     * getPrice(). Override 
     * @return double preu actual del producte del tipus subhasta.
     * (retornarà el preu pel producte del tipus subhasta actual. Aquest vindrà
     * definit per la puja més alta actual entre els licitadors interessats).
     */ 
    @Override
    public double getPrice(){
        return currentPrice;
    }
    /**
     * calculateProfit(). Override
     * @return double benefici en euros del producte tipus subhasta.
     * (retornarà el benefici pel producte tipus subhasta actual. El benefici
     * de la tenda serà la quota (5 euros) imposada al suhastar un producte 
     * sumat a l'interés (5%) aplicat al preu final).
     */ 
    @Override
    public double calculateProfit(){
        return fee + (currentPrice * charge);
    }
    /**
     * makeBid(). 
     * @param b licitador (repressentat per la classe Buyer) interessat en pujar
     * pel producte subhastat.
     * @param p puja en euros pel producte subhastat.
     * (realitza una puja provinent del licitador interessat amb un cert preu).
     */ 
    public void makeBid(Buyer b, double p){
        if(p > currentPrice){
            bidder = b;
            currentPrice = p;
            System.out.println(bidder.getName() + " makes a bid for the item " + this.getName() + " of " + p + " euros.");
        }
    }
    /**
     * frozen(). 
     * @return boolean 
     * @param d data actual en el format d'String
     * (comprova si la data actual figura abans de la data límit de la subhasta,
     * en cas afirmatiu retorna cert, fals altrament (quan qualsevol puja es
     * doni després de la seva data límit).
     */ 
    public boolean frozen(Calendar d){
        return d.compareTo(deadline) > 0;
    }
    /**
     * getBuyer(). Getter
     * @return Buyer Retorna l'atribut bidder
     * (el licitador actual del producte subhastat).
     */    
    public Buyer getBuyer(){
        return bidder;
    }
    /**
     * getDeadline(). Getter
     * @return String Retorna l'atribut deadline
     * (la data límit del producte subhastat).
     */ 
    public Calendar getDeadline(){
        return deadline;
    }
}

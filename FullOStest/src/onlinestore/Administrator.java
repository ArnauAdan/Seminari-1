package onlinestore;

import java.util.LinkedList;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.LONG;
import java.util.Locale;

/**
 *
 * @author Pau
 */

/**
 * Administrator. Classe filla d'User, encarregada de representar el tipus 
 * d'usuari administrador. El seu objectiu és administrar la OnlineStore 
 * expulsant usuaris, manegant subhastes i fent inventaris de l'stock.
 * 
 * Un usuari administrador  estarà format pels atributs nom, identificador i 
 * contrassenya de la classe pare donada la relació d'herència amb ella.
 */
public class Administrator extends User {
    
    /**
     * Administrator(n, id, p). Constructor de Seller. 
     * @param n atribut d'User, informa sobre el nom de l'usuari.
     * @param id atribut d'User, informa sobre l'identificador de l'usuari.
     * @param p atribut d'User, informa sobre la contrassenya de l'usuari.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */ 
    public Administrator(String n, String id, String p){
        
        super(n, id, p);
    }
    /**
     * expel(). 
     * @param u usuari, instància de la classe User
     * @return boolean
     * (S'encarrega d'informar sobre l'expulsió per part de l'adminisrador 
     * actual de l'usuari u indicat per l'argument del mètode. Retorna cert al
     * fer-ho).
     */    
    public boolean expel(User u){
        System.out.println(this.getName() + " expelled the user " + u.getName());
        return true;
    }
    /**
     * manageAuction(). 
     * @param a producte del tipus subhasta, instància de la classe AuctionItem.
     * @param date data en forma d'string.
     * @return boolean
     * (S'encarrega de gestionar la subhasta del producte AuctionItem a en una 
     * data date concreta).
     */     
    public boolean manageAuction(AuctionItem a, Calendar date){
        if(a.frozen(date)){
            System.out.println("Auction of " + a.getName() + " is frozen. No more bids can be made.");
            System.out.println(this.getName() + " managed the item " + a.getName() + ", Buyer: " + a.getBuyer().getName()); 
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * printStock(). 
     * @param items llista enllaçada d'items del tipus AuctionItem.
     * (Printa informació sobre els elements de subhasta introduits pel 
     * paràmetre items. L'administrador usa el mètode per informar sobre els 
     * elements actuals en subhasta).
     */         
    public void printStock(LinkedList< AuctionItem > items){
        System.out.println("Administrator " + this.getName() + " is printing the current stock:");
        for(int i = 0; i < items.size(); i++){
            AuctionItem item = items.get(i);
            System.out.println( item.getName() + " has current price " + item.getPrice() + " with auction deadline on day: " + item.getDeadline().get(Calendar.DATE) + " of " + item.getDeadline().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
        }    
    }
}

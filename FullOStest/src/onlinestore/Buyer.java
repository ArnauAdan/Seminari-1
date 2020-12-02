package onlinestore;

import java.util.LinkedList;

/**
 * Buyer. Classe filla d'User, encarregada de representar el tipus d'usuari
 * comprador. El seu objectiu és comprar productes de la OnlineStore, cada
 * compra implicará una reducció al capital del seu compte bancari.
 *
 * Un usuari comprador estarà format pel seu número de compe i els ítems 
 * comprats. Estarà caracteritzat també pels atributs nom, identificador i 
 * contrassenya de la classe pare donada la relació d'herència amb ella.
 */
public class Buyer extends User {
    
    private String accountNumber;
    private LinkedList< Item > boughtItems = new LinkedList<>();
    
    /**
     * Buyer(n, id, p, a). Constructor de Buyer. 
     * @param n atribut d'User, informa sobre el nom de l'usuari.
     * @param id atribut d'User, informa sobre l'identificador de l'usuari.
     * @param p atribut d'User, informa sobre la contrassenya de l'usuari.
     * @param a atribut de Buyer, informa sobre el número de compte.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */ 
    public Buyer(String n, String id, String p, String a){
        
        super(n, id, p);
        accountNumber = a;
    }
    /**
     * sell(). 
     * @param i instància producte de la classe Item a comprar.
     * (s'encarrega d'indicar per pantalla l'acció de compra del producte Item i 
     * per part de l'usuari Buyer actual, també afegeix aquest a la llista 
     * boughtItems, indicant un nou producte a la seva llista de compres).
     */    
    public void buy(Item i){
        boughtItems.add(i);       
        System.out.println(this.getName() + " is buying item " + i.getName() + " for " + i.getPrice() + " euros ");
        this.pay(i.getPrice());
    }
    /**
     * pay(). 
     * @param price preu a pagar
     * @return boolean
     * (s'encarrega d'indicar per pantalla l'acció de pagar per part de l'usuari
     * comprador un producte amb preu price).
     */    
    public boolean pay(double price){
        System.out.println("Price " + price + " is getting charged into account " + accountNumber + " from user " + this.getName());
        return true;
    }
}

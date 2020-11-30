package onlinestore;

import java.util.LinkedList;

/**
 *
 * @author Pau
 */

/**
 * Seller. Classe filla d'User, encarregada de representar el tipus d'usuari
 * venedor. El seu objectiu és publicar un producte a subhasta i rebre al seu
 * compte bancari el benefici obtingut. Poden tenir diversos items 
 * subhastant-se alhora
 * 
 * Un usuari venedor estarà format pel seu número de compe, els ítems venuts i 
 * disponibles. Estarà caracteritzat també pels atributs
 * nom, identificador i contrassenya de la classe pare donada la relació 
 * d'herència amb ella.
 */
public class Seller extends User {
    
    private String accountNumber;
    private LinkedList< Item > soldItems = new LinkedList<>(); 
    private LinkedList< Item > availableItems = new LinkedList<>();
    
    /**
     * Seller(n, id, p, a). Constructor de Seller. 
     * @param n atribut d'User, informa sobre el nom de l'usuari.
     * @param id atribut d'User, informa sobre l'identificador de l'usuari.
     * @param p atribut d'User, informa sobre la contrassenya de l'usuari.
     * @param a atribut de Seller, informa sobre el número de compte.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */    
    public Seller(String n, String id, String p, String a){
        
        super(n, id, p);
        accountNumber = a;
    }
    /**
     * sell(). 
     * @param i instància producte de la classe Item a vendre.
     * (s'encarrega d'indicar per pantalla l'acció de venta del producte Item i 
     * per part de l'usuari Seller actual).
     */    
    public void sell(Item i){
        System.out.println(this.getName() + " sold " + i.getName() + " and " + i.calculateProfit() + " euros are deposited to account " + accountNumber);
        availableItems.remove(i);//NEWLAB4
    }
    /**
     * addAvailableItem(). 
     * @param i instància producte de la classe Item.
     * (s'encarrega d'incloure a la llista de productes disponibles de l'usuari
     * Seller actual el producte Item i).
     */     
    public void addAvailableItem(Item i){
        availableItems.add(i);
    }
    /**
     * deposit(). 
     * @return boolean
     * @param price quantitat en euros del preu d'una venta.
     * (determina si l'usuari venedor desitja dipositar els diners d'una 
     * venta directament al compte bancari).
     */      
    private boolean deposit(double price){
        System.out.println("User " + this.getName() + " wishes to deposit " + price + " directly to the banck account " + accountNumber);
        return true;
    }
}

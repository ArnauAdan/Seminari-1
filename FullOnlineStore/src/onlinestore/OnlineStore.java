package onlinestore;
import fullonlinestore.Sale;

import java.util.LinkedList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;
/**
 *
 * @author Pau
 */

/**
 * OnlineStore. Classe encarregada de representar la OnlineStore.
 * La tenda estarà formada pels seus productes venuts i disponibles 
 * (classe Item), els paquets disponibles (classe Package) i els usuaris 
 * d'aquesta classe (User). També mantindrem en tot moment la inforació sobre
 * el preu i benefici actuals de la tenda. 
 * Ara, pel lab 4 afegim a la tenda informació sobre les ventes 
 * (de la classe Sales) produïdes i un comptador enter que ens ajudarà a 
 * determinar el dia actual per la OnlineStore.
 * 
 * El seu objectiu és manegar tots els usuaris, paquets i items ara amb les
 * millores proposades pel lab 4: ordenar ventes per preu i data i aplicar
 * l'impost d'iva als items i paquets.
 */
public class OnlineStore {
    
    public static LinkedList< Item > itemsSold;
    public static LinkedList< Item > itemsAvailable;
    public static LinkedList< Package > packages;
    public static LinkedList< User > users;
    public static double totalPrice;
    public static double totalProfit;
    public static LinkedList< Sale > sales;
    public static int dateCounter;
    
    public static void init(){
        itemsSold = new LinkedList<>();
        itemsAvailable = new LinkedList<>();
        packages = new LinkedList<>();
        users = new LinkedList<>();
        sales = new LinkedList<>();
        totalPrice = 0.0;
        totalProfit = 0.0;
        dateCounter = 0;
    }
    /**
     * sell(). 
     * @param i Item producte a vendre
     * @param u User usuari comprador del producte
     * @param s User usuari venedor del producte
     * (Aquest mètode s'encarrega de gestionar una venta qualsevol donat un 
     * item, el seu comprador i venedor. Necessitarem: actualitzar el preu i 
     * benefici actuals de la tenda, permetre als usuaris comprar o vendre,
     * definir la venta produïda i informar-ne a la tenda i modificar la llista
     * d'items disponibles de la tenda)
     */       
    public static void sell(Item i, Buyer u, Seller s){
        //1. Actualitza el preu i benefici totals de la tenda
        totalPrice += i.getPricePlusTax() + i.getPricePlusTax();
        totalProfit += (i.calculateProfit() + (i.getPackage().calculateProfit())); 
        //2. Permet als usuaris comprador i venedor comprar i vendre respectivament
        if(u instanceof Buyer){
           ((Buyer)u).buy(i);
        }      
        if(s instanceof Seller){
           ((Seller)s).sell(i);
        }      
        System.out.println("Item profit for the online store: " + i.calculateProfit());  
        Calendar saleDate = Calendar.getInstance();
        saleDate = (Calendar)saleDate.clone();
        saleDate.add(Calendar.DATE, dateCounter);
        Calendar shippingDate = (Calendar)saleDate.clone();
        shippingDate.add(Calendar.DATE, dateCounter + 3);
        //3. Crea una instància de la classe Sale per a que la tenda recolleixi 
        //la informació sobre aquesta
        Sale currentSale = new Sale(i, u, i.getPackage(), saleDate, shippingDate);
        sales.add(currentSale);
        itemsSold.add(i);
        //4. Esborra l'item venut de la llista d'items disponibles de la tenda
        itemsAvailable.remove(i);   
    }
     /**
     * currentDate(). 
     * @param admin User usuari administrador
     * (Aquest mètode usa l'usuari administrador passat pel paràmetre per 
     * incrementar la data actual de la tenda i observar si per aquest dia ha 
     * finalitzat cap subhasta. En cas afirmatiu informa a la tenda sobre la 
     * nova venta)
     */    
    public static void currentDate(Administrator admin){
        dateCounter++;
        Calendar currDate = Calendar.getInstance();
        currDate.add(Calendar.DATE, dateCounter);          
        System.out.println("day: " + currDate.get(Calendar.DATE) + " of " + currDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US)+"\n");
        
        for(int i = 0; i < itemsAvailable.size(); i++){
            Item currItem = itemsAvailable.get(i);
            if(currItem instanceof AuctionItem){
                if(admin.manageAuction((AuctionItem)currItem, currDate)){
                    Buyer b = ((AuctionItem) currItem).getBuyer();
                    sell(currItem, b, null);                 
                }
            }
        }
    }
    /**
     * sortItems(). 
     * (Usa la classe Collections per ordenar tots els Items de la tenda segons
     * com indica la funció compareTo implementada a Item (els ordenarà per 
     * preu). Un cop els tingui ordenats informarà per pantalla sobre el 
     * resultat)
     */     
    public static void sortItems(){
        Collections.sort(itemsAvailable);
        System.out.println("SORTED AVAILABLE ITEMS LIST:");
        for(int i = 0; i < itemsAvailable.size(); i++){
            Item currItem = itemsAvailable.get(i);
            System.out.println(currItem.getName() + " " + currItem.getPrice());
        }
    }
    /**
     * sortSales(). 
     * (Usa la classe Collections per ordenar totes les ventes de la tenda 
     * segons com indica la funció sort implementada a Sales (les ordenarà per 
     * data). Un cop les tingui ordenades informarà per pantalla sobre el 
     * resultat)
     */       
    public static void sortSales(){
        Collections.sort(sales);
        System.out.println("SORTED SALES LIST:");
        for(int i = 0; i < sales.size(); i++){
            Sale currSale = sales.get(i);
            System.out.println(currSale.getSaleDate().get(Calendar.DATE) + " of " + currSale.getSaleDate().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + ": " + currSale.getSaleItem().getName() + " bought by " + currSale.getSaleUser().getName());
        }
    }    
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
        Calendar day = Calendar.getInstance();
        System.out.println("day: " + day.get(Calendar.DATE) + " of " + day.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US)+"\n");
        // Afegim items
        itemsAvailable.add( new UnitItem("Sofa", "Furniture", new double[]{280.0, 120.0, 100.0}, 300, 500, 2));
        itemsAvailable.add( new WeightedItem( "Rice", "Food", new double[]{12.0, 22.0, 2.0}, 1.5, 2.5, 50));
        itemsAvailable.add( new UnitItem( "TV", "Appliance", new double[]{100.0, 60.0, 10.0}, 600, 1000, 4));

        // Afegim users
        users.add( new Buyer( "Pau Cobacho", "Pau", "passpass", "12345678"));
        users.add( new Buyer( "Toni García", "Toni", "contra", "87654321"));
        users.add( new Buyer( "Arnau Adan", "Arnau", "pass", "453627"));
        users.add( new Seller( "Jose Rodrigo", "Jose", "algo", "1111"));
        users.add( new Administrator( "Joel Peterson", "Jefe", "passs"));
        
        // Afegim paquets       
       packages.add( new Envelope(11, 21, "A5"));
       packages.add( new Envelope(21, 29, "A4"));
       packages.add( new Envelope(29, 41, "A3"));
       packages.add( new Box(10, 10, 10));
       packages.add( new Box(10, 10, 100));
       packages.add( new Box(10, 100, 100));
       packages.add( new Box(100, 100, 100));
       packages.add( new Box(100, 150, 300));
       packages.add( new Box(200, 300, 500));
       
       // Login users
       System.out.println("USERS LOGGING IN:");
       users.get(0).login("passpass");
       users.get(1).login("contra");
       users.get(2).login("pass");
       users.get(3).login("algo");
       users.get(4).login("pass");
       users.get(4).login("passs");
       
       // Assignem paquets
       System.out.println("ASSIGNING PACKAGES:");
       for(int i = 0; i < itemsAvailable.size(); i++){
           itemsAvailable.get(i).assignBestPackage(packages);
       }
       
       // Afegim items als venedors      
       Seller s = (Seller)users.get(3);
       for(int i = 0; i < itemsAvailable.size(); i++){
           s.addAvailableItem( itemsAvailable.get(i));
       }
       
       // Test items
       Item item_1 = itemsAvailable.get(0);
       Item item_2 = itemsAvailable.get(1);
       Item item_3 = itemsAvailable.get(2);
       sortItems();
       Buyer b_1 = (Buyer)users.get(0);
       Buyer b_2 = (Buyer)users.get(1);
       Buyer b_3 = (Buyer)users.get(2);
       System.out.println("SALES: ");
       sell(item_1, b_1, s);
       sell(item_2, b_2, s);
       sell(item_3, b_3, s);
       
       // Test Auction
       LinkedList< AuctionItem > lai = new LinkedList<>();
       Administrator admin = (Administrator)users.get(4);
       Calendar au_date5 = Calendar.getInstance();
       au_date5.add(Calendar.DATE, +4);
       
        
       System.out.println("AUCTION SALE:");
       AuctionItem auctionItem = new AuctionItem("Volvo", "Car", new double[]{250, 160, 450}, 10000.0, 10000.0, au_date5);
       lai.add(auctionItem);
       auctionItem.assignBestPackage(packages);
       s.addAvailableItem(auctionItem);
       itemsAvailable.add(auctionItem);
       admin.printStock(lai);   
       currentDate(admin);
       auctionItem.makeBid( (Buyer)users.get(1), 11000.0);
       currentDate(admin);
       auctionItem.makeBid( (Buyer)users.get(0), 11500.0);
       currentDate(admin);
       auctionItem.makeBid( (Buyer)users.get(2), 13000.0);
       currentDate(admin);      
       currentDate(admin);
       auctionItem.makeBid( (Buyer)users.get(1), 13500.0);

       admin.expel(users.get(1));
       users.remove(users.get(1));
       lai.remove(auctionItem);
       
       sortSales();
       System.out.println("STORE ANALYTICS: ");
       System.out.println("Total items and packets price (+iva): " + totalPrice + " euros.");
       System.out.println("Total items and packets profit: " + totalProfit + " euros.");
       
    }    
}

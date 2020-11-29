package onlinestore;
import fullonlinestore.Sale;

import java.util.LinkedList;
import java.util.Calendar;
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
 * 
 * El seu objectiu és manegar tots els usuaris, paquets i items.
 */
public class OnlineStore {
    
    public static LinkedList< Item > itemsSold;
    public static LinkedList< Item > itemsAvailable;
    public static LinkedList< Package > packages;
    public static LinkedList< User > users;
    public static double totalPrice;
    public static double totalProfit;
    public static LinkedList< Sale > sales;
    public static int saleCounter;
    
    public static void init(){
        itemsSold = new LinkedList<>();
        itemsAvailable = new LinkedList<>();
        packages = new LinkedList<>();
        users = new LinkedList<>();
        sales = new LinkedList<>();
        totalPrice = 0.0;
        totalProfit = 0.0;
        //saleCounter = 0;
    }
    
    public static void sell(Item i, User u){
        //1. Update the total price and benefit of past sales.
       //Item currentItem = sales.get(saleCounter).getSaleItem();
       //totalPrice += currentItem.getPrice();
       //totalProfit += currentItem.calculateProfit();
       //1. Update the total price and benefit of past sales.
       totalPrice += i.getPrice();
       totalProfit += i.calculateProfit();
       //2. Call the method buy of Buyer (and possibly sell of Seller).
       if(u instanceof Buyer){
           ((Buyer)u).buy(i);
       }      
       else if(u instanceof Seller){
           ((Seller)u).sell(i);
       }
       //3. Create an instance of Sale and store this instance in the register of sales.
       Calendar saleDate = Calendar.getInstance();
       Calendar shippingDate = (Calendar)saleDate.clone();
       shippingDate.add(Calendar.DATE, 3);
       Sale currentSale = new Sale(i, u, i.getPackage(), saleDate, shippingDate);
       sales.add(currentSale);
       //4. Remove the item sold from the list of items
       itemsAvailable.remove(i);
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
        
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
       for(int i = 0; i < itemsAvailable.size(); i++){
           Item item = itemsAvailable.get(i);
           Buyer b = (Buyer)users.get(i);           
           b.buy(item);
           totalPrice += item.getPrice();
           if(item instanceof UnitItem){
               ((UnitItem)item).sell(0);
           }
           else if(item instanceof WeightedItem){
               ((WeightedItem)item).sell(0.0);
           }
           s.sell( item );
           totalProfit += item.calculateProfit();
           itemsSold.add(item);
           System.out.println("Item profit for the online store: " + item.calculateProfit());
       }
       
        // Delete sold items
        for(int i = 0; i < itemsSold.size(); i++){
           itemsAvailable.remove(itemsSold.get(i));
       }
       
       // Test Auction
       LinkedList< AuctionItem > lai = new LinkedList<>();
       Administrator admin = (Administrator)users.get(4);
       Calendar au_date1 = Calendar.getInstance();
       Calendar au_date2 = Calendar.getInstance();
       Calendar au_date3 = Calendar.getInstance();
       Calendar au_date4 = Calendar.getInstance(); 
       Calendar au_date5 = Calendar.getInstance();       
       au_date1.set(2010, 2, 15); // Sun Mar 2010
       au_date2.set(2010, 2, 5); // Sun Mar 2010
       au_date3.set(2010, 2, 6); // Sun Mar 2010
       au_date4.set(2010, 2, 12); // Sun Mar 2010   
       au_date5.set(2010, 2, 16); // Sun Mar 2010
       AuctionItem auctionItem = new AuctionItem("Volvo", "Car", new double[]{250, 160, 450}, 10000.0, 10000.0, au_date1);
       lai.add(auctionItem);
       auctionItem.assignBestPackage(packages);
       s.addAvailableItem(auctionItem);
       itemsAvailable.add(auctionItem);
       
       if(!auctionItem.frozen(au_date2)){
           auctionItem.makeBid( (Buyer)users.get(1), 11000.0);
       }
       admin.printStock(lai);
       if(!auctionItem.frozen(au_date3)){
           auctionItem.makeBid( (Buyer)users.get(0), 10500.0);
       }
       if(!auctionItem.frozen(au_date4)){
           auctionItem.makeBid( (Buyer)users.get(2), 13000.0);
       }
       admin.manageAuction(auctionItem, au_date1);
       if(!auctionItem.frozen(au_date5)){
           auctionItem.makeBid( (Buyer)users.get(1), 13500.0);
       }
       admin.expel(users.get(1));
       users.remove(users.get(1));
       Buyer b = auctionItem.getBuyer();
       b.buy(auctionItem);
       s.sell(auctionItem);
       
       totalPrice += auctionItem.getPrice();
       totalProfit += auctionItem.calculateProfit();
       
       itemsSold.add(auctionItem);
       lai.remove(auctionItem);
       itemsAvailable.remove(auctionItem);
       
       System.out.println("Total price: " + totalPrice);
       System.out.println("Total profit: " + totalProfit);
    }    
}

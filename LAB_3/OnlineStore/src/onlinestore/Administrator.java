/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import java.util.LinkedList;

/**
 *
 * @author Pau
 */
public class Administrator extends User {
    
    public Administrator(String n, String id, String p){
        
        super(n, id, p);
    }
    
    //La meva proposta és possar-ho tot null
    public boolean expel(User u){
        System.out.println(this.getName() + "expelled the user" + u.getName());
        u.name=null;
        u.identifier=null;
        u.password=null;
        return true;
    }
    
    //Amb aquesta estic igual, no sé ni per on començar
    public boolean manageAuction(AuctionItem a, String date){
        System.out.println(this.getName() + "managed the item" + a.getName());
        return true;//IMPLEMENT
    }
    
    //Aquesta jo l'havia simplificat a: System.out.println(items); però em sembla bé posar la resta
    public void printStock(LinkedList< AuctionItem > items){
        System.out.println("Administrator" + this.getName() + "is printing the current stock");
        for(int i = 0; i < items.size(); i++){
            AuctionItem item = items.get(i);
            System.out.println( item.getName() + "has current price" + item.getPrice() + "with deadline" + item.getDeadline());
        }
     
    }
}

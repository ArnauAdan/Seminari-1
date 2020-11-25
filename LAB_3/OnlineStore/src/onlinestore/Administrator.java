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
    
    public boolean expel(User u){
        System.out.println(this.getName() + " expelled the user " + u.getName());
        return true;
    }
    
    public boolean manageAuction(AuctionItem a, String date){
        if(a.frozen(date)){
           System.out.println(this.getName() + " managed the item " + a.getName()); 
           return true;
        }
        else{
            return false;
        }
    }
    
    public void printStock(LinkedList< AuctionItem > items){
        System.out.println("Administrator " + this.getName() + " is printing the current stock");
        for(int i = 0; i < items.size(); i++){
            AuctionItem item = items.get(i);
            System.out.println( item.getName() + " has current price " + item.getPrice() + " with auction deadline " + item.getDeadline());
        }
     
    }
}

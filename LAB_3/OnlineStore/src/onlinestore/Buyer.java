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
public class Buyer extends User {
    
    private String accountNumber;
    private LinkedList< Item > boughtItems = new LinkedList<>();
    
    public Buyer(String n, String id, String p, String a){
        
        super(n, id, p);
        accountNumber = a;
    }
    
    public void buy(Item i){
        boughtItems.add(i);       
        System.out.println(this.getName() + " is buying item " + i.getName() + " for " + i.getPrice() + " euros ");
        this.pay(i.getPrice());
    }
    
    public boolean pay(double price){
        System.out.println("Price " + price + " is getting charged into account " + accountNumber + " from user " + this.getName());
        return true;
    }
}

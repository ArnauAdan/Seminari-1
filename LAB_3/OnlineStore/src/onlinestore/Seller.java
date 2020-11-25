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
public class Seller extends User {
    
    private String accountNumber;
    private LinkedList< Item > soldItems = new LinkedList<>(); 
    private LinkedList< Item > availableItems = new LinkedList<>();
    
    public Seller(String n, String id, String p, String a){
        
        super(n, id, p);
        accountNumber = a;
    }
    
    public void sell(Item i){
        System.out.println(this.getName() + " sold " + i.getName() + " and " + i.calculateProfit() + " euros are deposited to account " + accountNumber);
    }
    
    public void addAvailableItem(Item i){
        availableItems.add(i);
    }
    
    private boolean deposit(double price){
        System.out.println("User " + this.getName() + " wishes to deposit " + price + " directly to the banck account " + accountNumber);
        return true;
    }
}

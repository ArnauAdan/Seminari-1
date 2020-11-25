/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

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
        System.out.println(this.getName() + "is buying item" + i.getName() + "for" + i.getPrice() + "euros");
    }
    
    //No hauria d'estar connectat amb sell (mètode de seller)?
    public boolean pay(double price){
        System.out.println("Connectant amb el banc...");
        System.out.println("...");
        System.out.println("Operació acceptada");
        System.out.println(price + "$ deduïts del compte" + accountNumber);
        return true;
    }
}

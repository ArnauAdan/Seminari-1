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
    
    //HE afegit treure i posar a les llistes, res més
    public void sell(Item i){
        soldItem.add(i);
        availableItems.remove(i);
        System.out.println(this.getName() + "sold" + i.getName() + "and" + i.calculateProfit() + "euros are deposited to account" + accountNumber);
    }
    
    public void addAvailableItem(Item i){
        availableItems.add(i);
    }
    
    //El que entenia d'aquest mètode és que et deia si era correcta el preu i he posat
    //Tot i que veient el teu també imprimiria missatge no sé que en penses
    
    /* public boolean deposit(double price){
            return soldItem.getLast().getPrice() == price;
       }*/
   
    private boolean deposit(double price){
        System.out.println("User" + this.getName() + "wishes to deposit" + price + "directly to the banck account" + accountNumber);
        return true;
    }
}

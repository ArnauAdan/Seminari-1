/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

/**
 *
 * @author Pau
 */
public class AuctionItem extends Item{
    
    private double currentPrice;
    // private Buyer bidder;
    private String deadline;
    private static final double fee = 5;
    private static final double charge = 0.05;
    
    public AuctionItem(String n, String t, double[] s, double c, double startingPrice, String d){
        
        super(n, t, s, c);
        currentPrice = startingPrice;
        deadline = d;
    }
    
    @Override
    public double getPrice(){
        return currentPrice;// highest bid
    }
    
    @Override
    public double calculateProfit(){
        return 0;// implement calculus
    }
    
    //public void makeBid()
    
    public boolean frozen(String d){
        return true;// implement
    }
    
    //public Buyer getBuyer()
    
    public String getDeadline(){
        return deadline;
    }
}

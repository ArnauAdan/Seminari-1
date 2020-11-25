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
    private Buyer bidder;
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
        return currentPrice;
    }
    
    @Override
    public double calculateProfit(){
        return fee + (currentPrice * charge);
    }
    
    public void makeBid(Buyer b, double p){
        if(p > currentPrice){
            bidder = b;
            currentPrice = p;
            System.out.println(bidder.getName() + " is the actual highest bidder of the item " + this.getName());
        }
    }
    
    public boolean frozen(String d){
        int int_input = Integer.parseInt(d);
        int int_deadline = Integer.parseInt(deadline);
        if(int_input >= int_deadline){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Buyer getBuyer(){
        return bidder;
    }
    
    public String getDeadline(){
        return deadline;
    }
}

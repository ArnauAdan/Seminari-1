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
public class WeightedItem extends Item{
    
    private double pricePerWeight;
    private double weight;
    private double weightRemaining;
    
    public WeightedItem(String n, String t, double[] s, double c, double wprice, double w){
        
        super(n, t, s, c);
        pricePerWeight = wprice;
        weight = w;   
        weightRemaining = w;
    }
    
    @Override
    public double getPrice(){
        return pricePerWeight * weight;
    }
    
    @Override
    public double calculateProfit(){
        return (pricePerWeight - this.getCost()) * weight;
    }
    
    public double sell(double q){
        weightRemaining = q;
        if(weightRemaining <= 0){
            System.out.println("All weight of " + this.getName() + " has been sold");
        }
        return weight * pricePerWeight;
    }
}

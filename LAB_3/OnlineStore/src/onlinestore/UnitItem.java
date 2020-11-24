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
public class UnitItem extends Item{
    
    private double unitPrice;
    private int quantity;
    private int quantityRemaining;
    
    public UnitItem(String n, String t, double[] s, double c, double uprice, int q){
        
        super(n, t, s, c);
        unitPrice = uprice;
        quantityRemaining = q;

    }
    
    @Override
    public double getPrice(){
        return unitPrice * quantity;
    }
    
    @Override
    public double calculateProfit(){
        return (unitPrice - super.getCost()) * quantity;
    }
    
    public double sell(int q){
        return 0;//implement whatever sell is 
    }
}

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

public abstract class Item {
    
    
    private String name;
    private String type;
    private double[] size = new double[3];
    private double cost;
    private Package pack;//COMPOSITION RELATION WITH PACKAGE CLASS
    
    public Item(String n, String t, double[] s, double c){    
        name = n;
        type = t;
        size = s;
        cost = c;   
    }
    
    public String getName(){
        return name;
    }
    
    public String getType(){
        return type;
    }
    
    public double[] getSize(){
        return size;
    }
    
    public double getCost(){
        return cost;
    }
    
    public Package getPackage(){
        return pack;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public void setType(String t){
        type = t;
    }
    
    public void setSize(double[] s){
        size = s;
    }
    
    public void setCost(double c){
        cost = c;
    }
    
    public void assignBestPackage(LinkedList< Package > lp){
        if(size[2] <= 3){
            //use envelope
            double item_area = size[0] * size[1];
            if(0 < item_area && item_area <= 609){
                if(0 < item_area && item_area <= 231){
                    pack = lp.get(2);
                }
                else{
                    pack =lp.get(1);
                }                
            }
            else{
                pack = lp.get(0);
            }
        }
        else{
            //use box
            double item_vol = size[0] * size[1] * size[2];
            double[] check = new double[4];
            check[0] = Math.abs(item_vol - 36000);
            check[1] = Math.abs(item_vol - 61250);
            check[2] = Math.abs(item_vol - 96000);
            check[3] = Math.abs(item_vol - 264000);
            double minValue = check[0];
            int index = 0;
            for(int i = 0; i < check.length; i++){
                if(check[i] < minValue){
                    minValue = check[i];
                    index = i;
                }
            }
            pack = lp.get(index + 3);    
        }
        System.out.println(pack.getHeight());//TESTTESTTESTTEST   
        System.out.println(pack.getWidth());// TESTTESTTESTTEST    
    }//OPTIMIZE CODE
    
    public abstract double getPrice();
    
    public abstract double calculateProfit();
}

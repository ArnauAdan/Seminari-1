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
    
    public Item(){
        name = null;
        type = null;
        size = null;
        cost = 0;
        pack = null;
        
    }
    
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
        if(size[2] < 3){
            //use envelope
            double item_area = size[0] * size[1];
            for(int i = 0; i < 2; i++){
                Package envelope = lp.get(i);
                double envelope_area = envelope.getHeight() * envelope.getWidth();                
                if(envelope_area >= item_area){
                    pack = lp.get(i); 
                    break;
                }
            }
            String envelope_name = ((Envelope)pack).getName();
            System.out.println("Envelope" + envelope_name + "Assigned to item" + name);
        }
        else{
            //use box   
            double item_volume = size[0] * size[1] * size[3];
            for(int i = 3; i < lp.size(); i++){
                Package box = lp.get(i);
                double box_volume = box.getHeight() * box.getWidth() * ((Box)box).getDepth();
                if(box_volume >= item_volume){
                    pack = lp.get(i);
                    break;
                }
            }
            double box_h = ((Box)pack).getHeight();
            double box_w = ((Box)pack).getWidth();
            double box_d = ((Box)pack).getDepth();
            System.out.println("Box with size" + box_w + "," + box_h + "," + box_d + "Assigned to item" + name);
        }        
    }
    
    public abstract double getPrice();
    
    public abstract double calculateProfit();
}

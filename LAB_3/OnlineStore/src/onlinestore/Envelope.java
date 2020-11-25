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
public class Envelope extends Package {
    
    private String name;
    
    public Envelope(int w, int h, String n){
        
        super(w ,h);
        name = n;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public boolean isSuitable(double[] size){
        double item_w = size[0];
        double item_h = size[1];
        if(this.getWidth() - item_w >= 0 && this.getHeight() - item_h >= 0){
            return true;
        }
        else if(this.getWidth() - item_h >= 0 && this.getHeight() - item_w >= 0){
            return true;
        }
        else{
            return false;
        }
    }
}

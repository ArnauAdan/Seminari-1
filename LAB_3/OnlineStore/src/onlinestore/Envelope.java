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
    
    public boolean isSuitable(int[] size){
       return false;// implement issuitable
    }
    
}

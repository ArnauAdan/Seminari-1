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
public class Box extends Package {
    
    private int depth;
    
    public Box(int w, int h, int d){
        
        super(w, h);
        depth = d;
    }
    
    public int getDepth(){
        return depth;
    }
    
    public void setDepth(int d){
        depth = d;
    }
    
    public boolean isSuitable(int[] size){
        return false;//implementissuitable
    }
}

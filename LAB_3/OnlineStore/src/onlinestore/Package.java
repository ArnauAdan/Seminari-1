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
public class Package {
    
    private int width;
    private int height;
    
    public Package(int w, int h){
        
        width = w;
        height = h;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void setWidth(int w){
        width = w;
    }
    
    public void setHeight(int h){
        height = h;
    }
}

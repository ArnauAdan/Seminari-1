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
    
    public boolean isSuitable(double[] size){
        boolean check = false;
        for(int combinations = 0, i = 0, q = 1, j = 2; combinations < 3; combinations++, i++, q++, j++){
            if(((this.getWidth() - size[i]) > -1) && ((this.getHeight() - size[q]) > -1) && ((this.getDepth() - size[j]) > -1)){
                check = true;
                break;
            }
            if(((this.getDepth() - size[i]) > -1) && ((this.getHeight() - size[q]) > -1) && ((this.getWidth() - size[j]) > -1)){
                check = true;
                break;
            }
            if(i == 2){
                i = -1;
            }
            if(q == 2){
                q = -1;
            }
            if(j == 2){
                j = -1;
            }
        }return check;
    }
}

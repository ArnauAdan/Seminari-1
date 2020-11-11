/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logoapp;
import java.awt.Graphics;
import java.util.Arrays;
/**
 *
 * @author eleison
 */
public class Turtle {
    private Integer x, y;
    private double dirX, dirY;
    private boolean pen;  
    
    public Turtle(int x, int y, double dx, double dy) {
        this.x = x;
        this.y = y;
        dirX = dx;
        dirY = dy;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public double getDirX() {
        return dirX;
    }
    
    public double getDirY() {
        return dirY;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setDirX(double dx) {
        dirX = dx;
    }
    
    public void setDirY(double dy) {
        dirY = dy;
    }
    
    public void setDir(double dx, double dy) {
        dirX = dx;
        dirY = dy;
    }    
    
    public void forward(double distance, Graphics g) {
        int oldx = x;
        int oldy = y;
        x += (int)(dirX * distance);
        y += (int)(dirY * distance);
           
    }
    
    public void turn(double a) {
        double radians = (Math.PI * a) / 180;
        double new_dx;
        double new_dy;
        
        new_dx = Math.cos(radians) * dirX - Math.sin(radians) * dirY;
        new_dy = Math.sin(radians) * dirX + Math.cos(radians) * dirY;
        dirX = new_dx;
        dirY = new_dy;
    }    
    
    public void setPen(boolean on) {
        pen = on;
    }
    
    public boolean isPenOn() {
        return pen == true;
    }
    
    public void draw(Graphics g) {
        //declare and initialize all the necessary variables
        // we set the x and y coordinates in a triangular shape
        int nPoints = 3;
        int[] xc = new int[nPoints];
        int[] yc = new int[nPoints];
        
        xc[0] = (int)(x + 8 * dirY); 
        yc[0] = (int)(y - 8 * dirX);
        xc[1] = (int)(x - 8 * dirY); 
        yc[1] = (int)(y + 8 * dirX);
        xc[2] = (int)(x + 16 * dirX); 
        yc[2] = (int)(y + 16 * dirY);         
        // Graphics method to draw a Polygon where the
        // attributes require the x and y coordinates
        g.drawPolygon(xc ,yc, nPoints);
    }
}

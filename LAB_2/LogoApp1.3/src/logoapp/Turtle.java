package logoapp;
import java.awt.Graphics;
/**
 *
 * @author eleison
 */

/**
 * Turtle. La classe s'encarrega de gestionar l'agent capaç de dibuixar 
 * a la pantalla.
 * 
 * L'agent tortuga ve definit per la seva posició, direcció (en forma de vector
 * unitari) i l'estat del seu llapis. 
 */

public class Turtle {
    // Attributes declaration
    private Integer x, y;
    private double dirX, dirY;
    private boolean pen;  
    
    /**
     * Turtle(). Constructor, crea instàncies de la classe
     * assignant-ne els seus paràmetres.
     * @param x coordenada x en pantalla de l'agent.
     * @param y coordenada y en pantalla de l'agent.
     * @param dx component x del vector unitari de l'agent.
     * @param dy component y del vector unitari de l'agent.
     */
    public Turtle(int x, int y, double dx, double dy) {
        
        this.x = x;
        this.y = y;
        dirX = dx;
        dirY = dy;
    }
    /**
     * getX(). Getter
     * @return Int Retorna la coordenada x de la tortuga.
     */
    public int getX() {
        
        return x;
    }
    /**
     * getY(). Getter
     * @return Int Retorna la coordenada y de la tortuga
     */
    public int getY() {
        
        return y;
    }
    /**
     * getDirX(). Getter
     * @return double Retorna el component x del vector unitari.
     */    
    public double getDirX() {
        
        return dirX;
    }
    /**
     * getDirX(). Getter
     * @return double Retorna el component y del vector unitari.
     */        
    public double getDirY() {
        
        return dirY;
    }
    /**
     * setX(). Setter
     * Estableix la coordenada x de la tortuga.
     */      
    public void setX(int x) {
        
        this.x = x;
    }
    /**
     * setY(). Setter
     * Estableix la coordenada y de la tortuga.
     */      
    public void setY(int y) {
        
        this.y = y;
    }
    /**
     * setCoord(). Setter
     * Estableix les coordenades x i y de la tortuga.
     */    
    public void setCoord(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
    /**
     * setDirX(). Setter
     * Estableix el component x del vector unitari.
     */      
    public void setDirX(double dx) {
        
        dirX = dx;
    }
    /**
     * setDirY(). Setter
     * Estableix el component y del vector unitari.
     */    
    public void setDirY(double dy) {
        
        dirY = dy;
    }
    /**
     * setDir(). Setter
     * Estableix els components x i y del vector unitari.
     */        
    public void setDir(double dx, double dy) {
        
        dirX = dx;
        dirY = dy;
    }    
    /**
     * forward(). Actualitza les coordenades x i y tenint en compte la 
     * distància a avançar i pinta el recorregut usant la classe Graphics.
     * @param distance (distància a avançar)
     * @param g (Classe on habita el mètode necessari per dibuixar la línia)
     */
    public void forward(double distance, Graphics g) {
        
        int oldx = x;
        int oldy = y;
        x += (int)(dirX * distance);
        y += (int)(dirY * distance);
        if(isPenOn()) {
            g.drawLine(oldx, oldy, x, y); 
        }
           
    }
    /**
     * turn(). Actualitza els components x i y del vector unitari tenint en 
     * compte l'angle de gir desitjat.
     * @param a (Valor de l'angle determinant la rotació)
     */
    public void turn(double a) {
        
        double radians = (Math.PI * a) / 180;// conversió d'angles a rads
        double new_dx;
        double new_dy;
        
        new_dx = Math.cos(radians) * dirX - Math.sin(radians) * dirY;
        new_dy = Math.sin(radians) * dirX + Math.cos(radians) * dirY;
        dirX = new_dx;
        dirY = new_dy;
    }    
    /**
     * getDirX(). Setter
     * @param on (llapis actiu quan el paràmetre és cert, inactiu 
     * contrariament).
     */   
    public void setPen(boolean on) {
        
        pen = on;
    }
    /**
     * isPenOn(). 
     * @return boolean Retorna cert si el llapis es troba actiu i fals 
     * altrament.
     */  
    public boolean isPenOn() {
        
        return pen == true;
    }
    /**
     * draw(). Representa la figura de la tortuga mitjançant un triangle que apunta a 
     * la direcció actual del vector unitari.
     * @param g (Classe on habita el mètode necessari per dibuixar el polígon)
     */  
    public void draw(Graphics g) {
        
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

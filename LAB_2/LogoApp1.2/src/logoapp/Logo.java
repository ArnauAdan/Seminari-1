/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logoapp;
import java.awt.Graphics;
/**
 *
 * @author eleison
 */
public class Logo {
    private int width;
    private int height;
    private Turtle t;
    
    public Logo(int w, int h) {
        width = w;
        height = h;
        this.t = new Turtle(400, 300, 90, 0);
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }    
    // en medio de la pantalla (0,0)
    public void reset() {
        t.setCoord(0, 0);
        t.setDir(0, 0);
        t.setPen(false);
    }
    // manda llamar a la tortuga del draw (triangulo) 
    public void execute(Program p, Graphics g) {
        t.draw(g);
        if(p.isCorrect()) {
            p.restart();
            while(!p.hasFinished()) {
                p.getNextInstruction();

                if(p.getCurrentInstruction().getCode().equals("ROT")) {
                    t.turn(p.getCurrentInstruction().getParam());
                }
                if(p.getCurrentInstruction().getCode().equals("FWD")) {
                    int oldx = t.getX();
                    int oldy = t.getY();
                    System.out.println(oldx);
                    System.out.println(oldy);
                    t.forward(p.getCurrentInstruction().getParam(), g);
                    g.drawLine(oldx, oldy, t.getX(), t.getY());
                    t.draw(g);
 
                }                
                
                    
            }
        }
        else {
            p.printErrors();
        }
    }
}

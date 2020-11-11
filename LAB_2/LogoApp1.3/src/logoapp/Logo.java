package logoapp;
import java.awt.Graphics;
/**
 *
 * @author eleison
 */

/**
 * Logo. L'objecte conté l'ambient on opera la tortuga amb els el·lements 
 * necessaris per executar un programa i dibuixar l'output per pantalla 
 * usant-la.
 * 
 * L'ambient ve definit per l'amplada i llargada de la pantalla i la
 * instància de Turtle que hi habita.
 */

public class Logo {
    // Attributes declaration
    private int width;
    private int height;
    private Turtle t;
    
    /**
     * Logo(). Constructor, crea instàncies de la classe
     * assignant-ne els seus paràmetres.
     * @param w és el primer atribut de Logo, informa
     * sobre l'amplada de la pantalla.
     * @param h és el segon atribut de Logo, informa sobre
     * la llargada de la pantalla.
     */
    public Logo(int w, int h) {
        width = w;
        height = h;
    }
    /**
     * getWidth(). Getter
     * @return Int Retorna l'atribut width
     * (l'amplada de l'ambient).
     */
    public int getWidth() {
        return width;
    }
    /**
     * getHeight(). Getter
     * @return Int Retorna l'atribut height
     * (la llargada de l'ambient).
     */
    public int getHeight() {
        return height;
    }    
     /**
     * reset().
     * Restableix la posició i llapis de la tortuga. 
     */
    public void reset() {
        // coordenades x i y representen el punt central de la pantalla.
        int x = width/2;
        int y = height/2;
        // establim els components del vector unitari, la direcció de la
        // tortuga.
        int dirX  = 1;
        int dirY = 0;
        // Restablim la tortuga amb els valors definits.
        this.t = new Turtle(x, y, dirX, dirY);
        t.setPen(true);
    }
    /**
     * execute().
     * Procediment per executar un programa.
     * Agafa la instància d'un programa definit i l'objecte Graphics per 
     * representar l'execució de cada instrucció d'aquest en l'ambient 
     * (pantalla) usant la tortuga.
     * @param p (Classe Program, on habita el programa a executar)
     * @param g (Classe Grpahics on habiten els mètodes necessaris per
     * dibuixar)
     */
    public void execute(Program p, Graphics g) {

        if(p.isCorrect()) {
            p.restart();
            reset();
            while(!p.hasFinished()) {
                
                p.getNextInstruction();// obtenim la instrucció 
                
                // Observem si es tracta d'alguna instrucció que modifiqui 
                // l'ambient i, en cas afirmatiu, establim els comportaments
                // necessaris sobre la tortuga.
                
                if(p.getCurrentInstruction().getCode().equals("PEN")) {
                    
                    if(p.getCurrentInstruction().getParam() == 0) {
                        t.setPen(false);
                    }
                    if(p.getCurrentInstruction().getParam() == 1) {
                        t.setPen(true);
                    }
                }            
                if(p.getCurrentInstruction().getCode().equals("ROT")) {
                    
                    t.turn(p.getCurrentInstruction().getParam());
                    t.draw(g);
                }
                if(p.getCurrentInstruction().getCode().equals("FWD")) {
                    
                    t.forward(p.getCurrentInstruction().getParam(), g);          
                    t.draw(g);
                }                                                
            }
        }
        else {
            p.printErrors();
        }
    }
}

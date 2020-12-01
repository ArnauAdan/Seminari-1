package onlinestore;

/**
 *
 * @author Pau
 */

/**
 * Box. Classe filla de Package, encarregada de representar el paquet del tipus 
 * caixa.
 * 
 * Un paquet del tipus sobre caixa definit per la seva profunditat. Estarà 
 * caracteritzat també pels atributs llargada i amplada de la classe pare donada
 * la relació d'herència amb ella.
 */
public class Box extends Package {
    
    private int depth;
    
    /**
     * Box(w, h, d). Constructor de Package. 
     * @param w atribut de Package, informa sobre l'amplada del paquet.
     * @param h atribut de Package, informa sobre la llargada del paquet.
     * @param d atribut de Box, informa sobre la seva profunditat.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */ 
    public Box(int w, int h, int d){
        
        super(w, h);
        depth = d;
    }
    /**
     * getDepth(). Getter
     * @return int Retorna l'atribut depth
     * (indica la profunditat de la caixa).
     */       
    public int getDepth(){
        return depth;
    }
    /**
     * setDepth(). Setter
     * @param d int representant la profunditat
     * (estableix la profunditat de la caixa).
     */     
    public void setDepth(int d){
        depth = d;
    }
    /**
     * isSuitable(). 
     * @param size representant les dimensions d'un producte Item
     * @return boolean
     * (Estudia si la instància actual de caixa pot ser usada per enviar un 
     * producte amb les dimensions indicades per size. Estudiarà com es comporta
     * el paquet segons com s'introdueix el producte; si hi cap dins retorna
     * cert, fals altrament).
     * 
     * (Voldrem introduïr el producte dins el paquet de totes les maneres
     * possibles fins trobar la òptima. Per les n = 3 dimensions (amplada, 
     * llargada i profunditat) observarem les n! = 6 maneres diferents de
     * disposar-les (és a dir, de quantes maneres puc girar un objecte 3d) i 
     * comprovarem si alguna d'aquestes configuracions pel producte resulta 
     * adient pel tamany de la capsa, retornant així cert o fals).
     */     
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
    
    @Override
    public double getPrice(){
        return (15 * Math.log(( this.getHeight() * this.getWidth() * this.getDepth() ) * 0.001));
    }
}

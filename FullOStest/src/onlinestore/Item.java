package onlinestore;

import java.util.LinkedList;
import fullonlinestore.Taxable;

/**
 * Item. Classe encarregada de representar un producte de la OnlineStore.
 * Un producte o item estarà format pel seu nom, tipus, mida (amplada, llargada
 * i profunditat), cost i tipus de paquet; aquest últim repressentat per la 
 * classe Package.
 * 
 * Tenim tres tipus de productes: d'unitats, de pes i de subhasta. Representarem 
 * les característiques especials de cadascun implementant-los com a classes 
 * filles d'Item (UnitItem, WeightedItem i AuctionItem respectivament). Ara, pel 
 * lab 4 implementem la interfície Taxable, que ens permetrà dotar els productes 
 * d'iva i de certes funcions relacionades amb lìmpost. Declarem un atribut que 
 * ens ajudarà a mantenir en tot moment l'impost total en euros pels paquets. 
 * Per últim, aquesta classe implemena també comparable; interfície que ens 
 * permet, mitjançant un mètode, definir com voldrem més tard ordenar els 
 * objectes d'aquesta classe.
 */
public abstract class Item implements Taxable, Comparable {
    
    private String name;
    private String type;
    private double[] size = new double[3];
    private double cost;
    private Package pack;
    private double itemsTax = 0;
    
    /**
     * Item(). Constructor buit d'Item. 
     * Ens permet crear instàncies de la classe sense haver d'inicialitzar cap
     * atribut.
     */
    public Item(){
        
    }    
    /**
     * Item(n, t, s, c). Constructor d'Item. 
     * @param n atribut d'Item, informa sobre el nom del producte.
     * @param t atribut d'Item, informa sobre el tipus del producte.
     * @param s atribut d'Item, informa sobre les dimensions del producte.
     * @param c atribut d'Item, informa sobre el cost del producte.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */
    public Item(String n, String t, double[] s, double c){    
        name = n;
        type = t;
        size = s;
        cost = c;   
    }
    /**
     * getName(). Getter
     * @return String Retorna l'atribut name
     * (el nom del producte).
     */
    public String getName(){
        return name;
    }
    /**
     * getType(). Getter
     * @return String Retorna l'atribut type
     * (el tipus de producte).
     */    
    public String getType(){
        return type;
    }
    /**
     * getSize(). Getter
     * @return dpuble[] Retorna l'atribut size
     * (les dimensions del producte).
     */      
    public double[] getSize(){
        return size;
    }
    /**
     * getCost(). Getter
     * @return double Retorna l'atribut cost
     * (el cost en euros del producte).
     */     
    public double getCost(){
        return cost;
    }
    /**
     * getPackage(). Getter
     * @return Package Retorna l'atribut pack
     * (el paquet assignat al producte).
     */         
    public Package getPackage(){
        return pack;
    }
    /**
     * setName(). Setter
     * @param n nom del producte
     * (estableix el nom del producte).
     */     
    public void setName(String n){
        name = n;
    }
    /**
     * setType(). Setter
     * @param t tipus de producte
     * (estableix el tipus de producte).
     */     
    public void setType(String t){
        type = t;
    }
    /**
     * setSize(). Setter
     * @param s dimensions del producte
     * (estableix les dimensions del producte).
     */     
    public void setSize(double[] s){
        size = s;
    }
    /**
     * setCost(). Setter
     * @param c cost del producte
     * (estableix el cost del producte en euros).
     */     
    public void setCost(double c){
        cost = c;
    }
    /**
     * assignBestPackage().
     * @param lp llista enllaçada de paquets (de la classe Package) disponibles.
     * (Selecciona el millor paquet disponible per la instància actual d'Item
     * basant-se en dos condicions; primerament, si la profunditat del producte
     * és menor de 3, s'assignarà un sobre (classe Envelope, filla de Package), 
     * altrament, usa una capsa (classe Box, filla de Package). Després, 
     * selecciona també d'entre les varietats de sobres i capses la que millor
     * encaixa amb l'Item actual; tot basant-se en el seu volum i les maneres 
     * possibles d'introduir-lo al paquet (girant-lo de diverses maneres). Si no
     * podem assignar paquet ens ho indica).
     */     
    public void assignBestPackage(LinkedList< Package > lp){
        if(size[2] < 3){
            //use envelope
            double item_area = size[0] * size[1];
            for(int i = 0; i < 2; i++){
                Package envelope = lp.get(i);
                double envelope_area = envelope.getHeight() * envelope.getWidth();                
                if(envelope_area >= item_area){
                    pack = lp.get(i); 
                    break;
                }
            }
            String envelope_name = ((Envelope)pack).getName();
            
            if(((Envelope)pack).isSuitable(size)){
                System.out.println("Envelope " + envelope_name + " assigned to item " + name);            
            }
            else{
                System.out.println("No envelope available fits the item " + name);
            }            
        }
        else{
            //use box   
            double item_volume = size[0] * size[1] * size[2];
            for(int i = 3; i < lp.size(); i++){
                Package box = lp.get(i);
                double box_volume = box.getHeight() * box.getWidth() * ((Box)box).getDepth();
                if(box_volume >= item_volume){
                    pack = lp.get(i);
                    break;
                }
            }
            double box_h = ((Box)pack).getHeight();
            double box_w = ((Box)pack).getWidth();
            double box_d = ((Box)pack).getDepth();        
            if(((Box)pack).isSuitable(size)){
                System.out.println("Box with size {" + box_w + ", " + box_h + ", " + box_d + "} assigned to item " + name);
            }
            else{
                System.out.println("No box available fits the item " + name);
            }     
        }
    }
    /**
     * getPrice(). Abstract 
     * @return double preu del producte
     * (retornarà el preu pel producte actual. La seva implementació varia en
     * funció del tipus d'instància del producte (d'unitats, pes o subhasta),
     * cada tipus de producte el calcularà de manera diferent.)
     */   
    @Override
    public abstract double getPrice();
    /**
     * calculateProfit(). Abstract
     * @return double benefici en euros del producte
     * (retornarà el benefici pel producte actual. La seva implementació varia 
     * en funció del tipus d'instància del producte (d'unitats, pes o subhasta),
     * cada tipus de producte el calcularà de manera diferent.)
     */ 
    public abstract double calculateProfit();
    /**
     * getPriceOnlyTax(). double
     * @return double
     * (implementem el mètode de la interfície Taxable on obtenim l'import en 
     * euros del iva aplicat al producte actual)
     */     
    @Override
    public double getPriceOnlyTax(){
        return this.getPrice() * iva;
    }
    /**
     * getPricePlusTax(). double
     * @return double
     * (implementem el mètode de la interfície Taxable on obtenim l'import total
     * en euros del preu del producte juntament amb l'import d'iva)
     */      
    @Override
    public double getPricePlusTax(){
        return (this.getPrice() + (this.getPrice() * iva));
    }
    /**
     * sumTotalTax(). double
     * @return double
     * @param t objecte que implementi Taxable
     * (implementem el mètode de la interfície Taxable on obtenim la suma en 
     * euros de l'iva per cada producte)
     */     
    @Override
    public double sumTotalTax(Taxable t){
        return itemsTax += t.getPriceOnlyTax();
    }   
    /**
     * compareTo(). double
     * @return int
     * @param i objecte a considerar
     * (implementem el mètode de la interfície Comparable on definim la manera
     * de comparar dos objectes de tipus producte; ho farem segons el seu preu.
     * La funció permet comparar l'objecte actual amb l'objecte a considerar 
     * entrat pel paràmetre; retornarà un 0, enter negatiu o positiu si 
     * el preu de l'objecte actual és menor, igual o major que l'objecte entrat 
     * pel param.)
     */     
    @Override
    public int compareTo(Object i){
        int result;
        if(this.getPrice() < ((Item)i).getPrice()){
            result = -1;
        }
        else if(this.getPrice() > ((Item)i).getPrice()){
            result = 1;
        }
        else {
            result = 0;
        }
        return result;
    }
}

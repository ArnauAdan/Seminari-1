package fullonlinestore;
import onlinestore.Item;
import onlinestore.User;
import onlinestore.Package;
import java.util.Calendar;

/**
 * Sale. Classe encarregada de representar una venta de la OnlineStore.
 * Una venta estarà formada per: el producte venut, l'usuari que ha comprat 
 * aquest, el paquet assignat al mateix i les dates representant el dia de la
 * venta i de l'enviament del producte.
 * 
 * Implementem també la interfície Comparable per definir el mètode segons el 
 * qual més tard voldrem ordenar les ventes (segons la seva data).
 */
public class Sale implements Comparable {
    private Item saleItem;
    private User saleUser;
    private Package salePackage;
    private Calendar saleDate;
    private Calendar shippingDate;

    /**
     * Sale(i, u, p, sd, shd). Constructor d'Item. 
     * @param i atribut de Sale, informa sobre el producte de la venta (Item).
     * @param u atribut de Sale, informa sobre l'usuari de la venta (User).
     * @param p atribut de Sale, informa sobre el paquet assignat a la venta 
     * (Package).
     * @param sd atribut de Sale, informa sobre la data de la venta (Calendar).
     * @param shd atribut de Sale, informa sobre la data d'enviament (Calendar).
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */    
    public Sale(Item i, User u, Package p, Calendar sd, Calendar shd){
        saleItem = i;
        saleUser = u;
        salePackage = p;
        saleDate = sd;
        shippingDate = shd;
    }      

    //Definim els getters i setters per aquest objecte tot i que per aquest 
    //laboratori no ens faràn falta.
    
    public Item getSaleItem(){
        return saleItem;
    }
    
    public User getSaleUser(){
        return saleUser;
    }
    
    public Package getSalePackage(){
        return salePackage;
    }
    
    public Calendar getSaleDate(){
        return saleDate;
    }
    
    public Calendar getShippingDate(){
        return shippingDate;
    }
    
    public void setSaleItem(Item i){
        saleItem = i;
    }
    
    public void setSaleUser(User u){
        saleUser = u;
    }    
    
    public void setSalePackage(Package p){
        salePackage = p;
    }
    
    public void setSaleDate(Calendar sd){
        saleDate = sd;
    }
    
    public void setShippingDate(Calendar shd){
        shippingDate = shd;
    }
    /**
     * compareTo(). double
     * @return int
     * @param d objecte a considerar
     * (implementem el mètode de la interfície Comparable on definim la manera
     * de comparar dos objectes de tipus venta; ho farem segons la seva data.
     * La funció permet comparar l'objecte actual amb l'objecte a considerar 
     * entrat pel paràmetre; retornarà un 0, enter negatiu o positiu si 
     * la data de l'objecte actual és menor, igual o major que l'objecte entrat 
     * pel param.)
     */     
    @Override
    public int compareTo(Object d){
        //return ((Calendar)d).compareTo(this.saleDate);
        Calendar date = ((Sale)d).getSaleDate();
        return date.compareTo(this.saleDate);
    }    
}

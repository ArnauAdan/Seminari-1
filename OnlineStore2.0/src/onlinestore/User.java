package onlinestore;

/**
 *
 * @author Pau
 */

/**
 * User. Classe encarregada de representar un usuari de la OnlineStore.
 * Un usuari estarà format pel seu nom, identificador i contrassenya.
 * 
 * Tenim tres tipus d'usuaris: venedor, comprador i administrador. Representarem 
 * les característiques especials de cadascun implementant-los com a classes 
 * filles d'User (Seller, Buyer i Administrator respectivament).
 */
public class User {
    
    private String name;
    private String identifier;
    private String password;
    
    /**
     * User(n, id, pass). Constructor d'User. 
     * @param n atribut d'User, informa sobre el nom de l'usuari.
     * @param id atribut d'User, informa sobre l'identificador de l'usuari.
     * @param pass atribut d'User, informa sobre la contrassenya de l'usuari.
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */
    public User(String n, String id, String pass){
        
        name = n;
        identifier = id;
        password = pass;
    }
    /**
     * getName(). Getter
     * @return String Retorna l'atribut name
     * (el nom de l'usuari).
     */
    public String getName(){
        return name;
    }
    /**
     * getID(). Getter
     * @return String Retorna l'atribut identifier
     * (l'identificador de l'usuari).
     */
    public String getID(){
        return identifier;
    }
    /**
     * getPassword(). Getter
     * @return String Retorna l'atribut password
     * (contrassenya de l'usuari).
     */
    public String getPassword(){
        return password;
    }
    /**
     * setName(). Setter
     * @param n nom de l'usuari
     * (estableix el nom de l'usuari).
     */   
    public void setName(String n){
        name = n;
    }
    /**
     * login(). 
     * @return boolean
     * @param p contrassenya en forma d'string
     * (retorna cert si la contrassenya coincideix amb l'assignada per la 
     * instància d'usuari actual, fals altrament).
     */       
    public boolean login(String p){
        if(password.equals(p)){
            System.out.println( identifier + " user account login was successfull");
            return true;
        }
        else{
            System.out.println( identifier + " user account login failed, please try again");
            return false;
        }
    }
}

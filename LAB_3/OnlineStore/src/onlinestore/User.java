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
public class User {
    
    private String name;
    private String identifier;
    private String password;
    
    public User(String n, String id, String pass){
        
        name = n;
        identifier = id;
        password = pass;
    }
    
    public String getName(){
        return name;
    }
    
    public String getID(){
        return identifier;//PDF SHOWS INT RETURN TYPE
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public boolean login(String p){
        return true;//IMPLEMENT
    }
}

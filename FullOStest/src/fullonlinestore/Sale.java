/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullonlinestore;
import onlinestore.Item;
import onlinestore.User;
import onlinestore.Package;
import java.util.Calendar;

/**
 *
 * @author Pau
 */
public class Sale implements Comparable {
    private Item saleItem;
    private User saleUser;
    private Package salePackage;
    private Calendar saleDate;
    private Calendar shippingDate;

    public Sale(Item i, User u, Package p, Calendar sd, Calendar shd){
        saleItem = i;
        saleUser = u;
        salePackage = p;
        saleDate = sd;
        shippingDate = shd;
    }      
    
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
    
    @Override
    public int compareTo(Object d){
        //return ((Calendar)d).compareTo(this.saleDate);
        Calendar date = ((Sale)d).getSaleDate();
        return date.compareTo(this.saleDate);
    }    
}

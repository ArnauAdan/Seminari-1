/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pau
 */
public class OnlineStore {
    
    //private LinkedList<User> users;
    private LinkedList< Item > itemsSold = new LinkedList<Item>();
    private LinkedList< Item > itemsAvailable = new LinkedList<Item>();
    private LinkedList< Package > packages = new LinkedList< Package >();
    private double totalPrice = 0;
    private double totalProfit = 0;
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OnlineStore os = new OnlineStore();
        // declare list of users, items and packages
        // create instances for each of them
        // buy and sell items, expel users
        // calculate total price and benefit of the application
        
        // instantiate packages
        Envelope a3_envelope = new Envelope(29, 42, "A3");
        Envelope a4_envelope = new Envelope(21, 29, "A4");
        Envelope a5_envelope = new Envelope(21, 11, "A5");
        Box small = new Box(40, 30, 30);// 36000
        Box medium = new Box(50, 35, 35);// 61250
        Box large = new Box(60, 40, 40);// 96000
        Box maxi = new Box(80, 55, 60);// 264000
       
        // add packages 
        os.packages.add(a3_envelope);
        os.packages.add(a4_envelope);
        os.packages.add(a5_envelope);
        os.packages.add(small);
        os.packages.add(medium);
        os.packages.add(large);
        os.packages.add(maxi);
        
        // instantiate items
        double[] size = new double[3];
        size[0] = 144;
        size[1] = 12;
        size[2] = 40;
        UnitItem toy = new UnitItem("toy", "children", size, 2, 1, 1);
        Item item_toy = toy;//UPCAST
        item_toy.assignBestPackage(os.packages);
 

    }
    
}

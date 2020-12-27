/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

/**
 *
 * @author Arnau Adan
 */
//Marquem la relació d'herència amb la classe Patient 
public class Visitor extends Patient{
        //No fan falta atributs
        //El seu constructor directament serà amb la paraula clau super
	public Visitor( int id, String name, int age ){
            super(id,name,age);
	}
	
        //Mètode que ens serveix per a tenir la informació completa del
        // tipus String
	public String toString(){ 
            String i = String.valueOf(id);
            String a = String.valueOf(age);
            return i + " " + name + " ";
	}
}

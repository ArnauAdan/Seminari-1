/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
//Importem les dues llibreries que utilitzem dins dels mètodes    
import java.util.LinkedList;
import java.util.Date;
/**
 *
 * @author Arnau Adan
 */

//Marquem que la classe Patient hereda de la classe Person
public abstract class Patient extends Person implements Comparable<Patient>{
        protected Date admissionDate;
	protected Integer age;
	protected LinkedList< Visit > visits;
        
        //El constructor de la nostre classe que ve marcat per l'herència amb 
        // la classe Person
	public Patient( int id, String name, int age ){
            super (id,name);
            this.age=age;
	}
	
        //Mètode per afegir una visita a la nostre llista
	public void addVisit( Visit v ){
            visits.add(v);
	}
		
        //Els següents 4 mètodes que són els getters i setters de la nostre 
        // classe
	public void setAdmissionDate( Date d ){
            admissionDate=d;
	}
	
	public Date getAdmissionDate(){
            return admissionDate;
	}
	
	public void setAge( Integer age ){
            this.age=age;
	}
	
	public Integer getAge(){
            return age;
	}
        
        //Aquest és el mètode que utilitza la interfície 'comparable'
        // que està marcat dins del disseny del programa, però que 
        // ja ve dins del provi java
        @Override
	public int compareTo( Patient p ){
            if(this.age < p.getAge()){
                return -1;
            }
            if(this.age > p.getAge()){
                return 1;
            }
            else{
                return 0;
            }   
	}
	
        //De moment el deixarem marcat perquè ens passi l'edat a String
        @Override
	public abstract String toString();
}

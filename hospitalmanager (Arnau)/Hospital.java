/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
//Importem dues llibreries que ens serviran per implementar els mètodes
import java.util.LinkedList;
import java.util.Collections;
/**
 *
 * @author Arnau Adan
 */
public class Hospital {
        //Como a atributs tindrà 5 llistes i un nom
        private LinkedList< Administrative > admins;
	private LinkedList< Doctor > doctors;
	private LinkedList< Patient > patients;
	private LinkedList< Room > rooms;
	private LinkedList< Visit > visits;
	private String name;

        //Constructor per inicialitzar la classe
	public Hospital( String name ){
            this.name=name;
	}
	
        //Afegir un administratiu a les llistes de l'hospital
	public void addAdmin( Administrative a ){	
            admins.add(a);
	}

        //Saber quin és l'administratiu pel seu id dins de les llistes de 
        // l'hospital
	public Administrative getAdmin( int idx ){
            Administrative e = null;
            for(Administrative ads: admins){
                if(ads.equals(idx)){
                    e=ads;
                }
            }
            return e;
	}
	
        //Afegir un doctor a les llistes de l'hospital 
	public void addDoctor( Doctor d ){
            doctors.add(d);
	}

        //Saber quin doctor dins l'hospital té l'ID rebut
	public Doctor getDoctor( int idx ){
            Doctor d = null;
            for(Doctor doc: doctors){
                if(doc.equals(idx)){
                    d=doc;
                }
            }
            return d;
	}

        //Afegeix una habitació a les llistes de l'hospital a partir
        // de la identificació d'aquesta
	public void addRoom( int id ){
            Room r = new Room(id);
            rooms.add(r);
	}

        //Per saber quina és l'habitació a partir de la seva identificació
	public Room getRoom( int idx ){
            Room r = null;
            for(Room ro: rooms){
                if(ro.equals(idx)){
                    r=ro;
                }
            }
            return r;
	}	
	
	public LinkedList< Room > getRooms(){
		// Add code here	
	}
	
	public void addResident(  int id, String name, int age ){
            Resident r = new Resident(id,name,age);
            
	}
	
	public void addVisitor( int id, String name, int age ){
		// Add code here
	}
	
	public void addVisit( Visit v ){
		// Add code here
	}
	
	public Visit getVisit( int idx ){
		// Add code here	
	}
	
	public Patient getPatient( int idx ){
		// Add code here
	}

	public void deletePatient( int idx ){
		// Add code here
	}
	
	public void assignBeds( int adminIdx ){
		// Add code here
	}

	public void sortPatients(){
		// Add code here
	}
	
	public String toString(){
		// Add code here
	}
}

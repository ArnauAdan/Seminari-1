/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
//Importem la llibreria Date per a poder utilitzar-la al mètode corresponent
import java.util.Date;
import java.util.LinkedList;
/**
 *
 * @author Arnau Adan
 */

//La classe Administrative hereda de la classe Person
public class Administrative extends Person{
        //L'atribut concret de la classe
        private Hospital hospital;
	
        //El propi constructor de la classe, amb la paraula clau 
        // super ja que es fa a partir del cosntructor de Person
	public Administrative( int id, String name, Hospital hospital ){
           super (id,name);
           this.hospital=hospital;
	}
	
        //A partir de l'atribut hospital afegim la visita que creem 
        // amb els valor pels atributs de visita.
	public void addVisit( Date d, String s, Doctor doc, Patient p ){
            Visit vi = new Visit(d,s,doc,p);
            hospital.addVisit(vi);
	}
        
        //Aquest mètode ens permet saber si hi ha un llit lliure a una habitació
	public boolean assignBed( Resident resident  ){
            boolean f=false;
            LinkedList<Room> r =hospital.getRooms();
            for(Room ru: r){
                if(ru.isAvailable()==true){
                    resident.assignBed(ru.getAvailableBed());
                    f=true;
                    break;
                }
            }
            return f; 
	}
	
        //Ens serveix per saber el nom sencer de l'administratiu així com 
        // la seva identificació
	public String toString(){ 
            String p = String.valueOf(id);
            return p + " " + this.name + " " + hospital;
 	}
}

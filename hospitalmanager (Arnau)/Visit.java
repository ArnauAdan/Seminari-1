/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
//Importem la llibreria Date que utilitzarem dins dels nostres atributs
import java.util.Date;
/**
 *
 * @author Arnau Adan
 */

public class Visit {
        //Els atributs corrresponents a la classe 
        Date date;
	String summary;
	Doctor doctor;
	Patient patient;
        //El constructor que inicialitza la classe
	public Visit( Date d, String s, Doctor doc, Patient p ){
            date=d;
            summary=s;
            doctor=doc;
            patient=p;
	}
	//Getters dels atributs de la classe pertinents
	public Date getDate(){
            return date;
	}
	public String getSummary(){ 
            return summary;
	}
	public Doctor getDoctor(){ 
            return doctor;
	}
	public Patient getPatient(){ 
            return patient;
	}
	
        //Ens serveix per a tenir en un String tota la informació del 
        // visitant
	public String toString(){
            String d = String.valueOf(date);
            String r = doctor.name;
            String p = patient.name;
            return summary + " " + r + " " + " " + d + " " + p;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
//Importem la llibreria LinkedList per a utilitzar-la en els nostres mètodes
import java.util.LinkedList;
/**
 *
 * @author Arnau Adan
 */

//La classe Doctor hereda de la classe Person
public class Doctor extends Person{
        //Les dues llistes que utilitzen els nostres mètodes
        private LinkedList< String > specialities;
	private LinkedList< Visit > visits;
        

        //Constructor de la nostre classe fet a partir del constructor de Person
	public Doctor( int id, String name ){
            super (id,name);             
	}
	
        //Hem afegit a la llista l'especialitat que rep el mètode
	public void addSpeciality( String s ){
            specialities.add(s);            
	}
	
        //Hem afegit a la llista la visita que que rep el mètode
	public void addVisit( Visit v ){
            visits.add(v);
	}
	
        //Imprimim per pantalla la llista d'especialitats guardades
	public void listSpecialities(){
            for(String sp: specialities ){
                System.out.println("-" + sp + "\n");
            }
	}
	
        //Imprimim per pantalla la llista de visites guardades
	public void listVisits(){
            for(Visit vi: visits){
                System.out.println("-" + vi + "\n");
            }
	}
	
        //Ens serveix per modificar el tipus de la variable de l'atribut id
        @Override
	public String toString(){ 
            String p = String.valueOf(id);
            return p+" "+name;
	}
}

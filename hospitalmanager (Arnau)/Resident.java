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

//Marquem que la classe Resident hereda de Patient
public class Resident extends Patient{
        //Els seus dos atributs que té la classe
        private Room room;
	private Bed bed;
        
        //El seu constructor que al no tenir atributs propis només cal 
        // utilitzar la paraula clau super
	public Resident ( int id, String name, int age ){
            super (id,name,age);
	}
	
        //Equivalent de setters per a atributs que no formen part 
        // del constructor
	public void assignRoom( Room r ){
            room=r;
	}
	
	public void assignBed( Bed b ){
            bed=b;
	}
	
        //S'haurà de mirar com es feia per cridar de més amunt 
	public Doctor getDoctor(){
            return visits.get(0).getDoctor();
	}
        
	//Mètode per poder imprimir per pantalla el nom i la identificació
        // completa del resident
	@Override
        public String toString(){
            String t = String.valueOf(id);
            String f = String.valueOf(age);
            return t+" "+name+" "+f;
	}
}

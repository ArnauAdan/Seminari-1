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
public class Bed {
        //Els 3 atributs que utilitza la classe
        private int bedID;
	private Room room;
	private Resident resident;
		
        //El constructor que utilitza la classe
	public Bed( int id, Room r ){
            bedID=id;
            room=r;
	}
	
        //Equivalent del setRoom que necessita
	public void assignRoom( Room r ){
            room=r;
	}
	
        //Per donar valor al nou resident del llit
	public void assignResident( Resident r ){
            resident=r;
	}
	
        //Treiem el valor que pugui tenir el llit amb aquest mètode
	public void release(){
            resident=null;
	}
	
        //Ens permetrà saber la id del llit
	public int getBedID(){
            return bedID;
	}
        
        //Permet saber si el llit està disponible
	public boolean isAvailable(){
            boolean av=true;
            if(resident==null){av=false;}
            return av;
	}	
	
        //Ens permet tenir el amb el tipus String tots els atribut de Bed
	public String toString(){
            String p = String.valueOf(bedID);
            return p + " " + room.toString();
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
//Importem la llibreria necessària per utilitzar els nostres mètodes
import java.util.LinkedList;
/**
 *
 * @author Arnau Adan
 */
public class Room {
        //Els dos atributs necessàris dins de la nostre classe
        private LinkedList< Bed > beds;
	private int roomID;
	
        //El constructor per incialitzar la classe
	public Room( int roomID ){
            this.roomID=roomID;
	}
	
        //Mètode per afegir un llit a l'habitació
	public void addBed( int bedID ){
            Bed bed = new Bed(bedID,this);
            beds.add(bed);
	}
	
        //Ens retorna el llit que tingui aquesta identificació
	public Bed getBed( int idx ){
            Bed f=null;
            for(Bed b: beds){
                if(b.equals(idx)){
                    f=b;
                }
            }
            return f;
	}
	
        //Ens diu si hi ha algún llit disponible
	public Bed getAvailableBed(){
            Bed f=null;
            for(Bed b: beds){
                if(b.isAvailable()==true){
                    f=b;
                    break;
                }                
            }
            return f;
	}
        
	//Ens mira si l'habitació està disponible
	public boolean isAvailable(){
            boolean g=false;
            for(Bed b: beds){
                if(b.isAvailable()==true){
                    g=true;
                    break;
                }
            }
            return g;
	}
	
        //Ens retorna imprimint per pantalla els llits de l'habitació
	public String listBeds(){
           String list = null;
           for(Bed b: beds){
               list+=b.toString()+"\n";
           }
           return list;
	}
        
        //Com a totes les classes afegim per transforma l'int a String
	public String toString(){ 
            String f = String.valueOf(roomID);
            return f;
	}
}

import java.util.Calendar;
import java.util.LinkedList;

/**
 * Administrative. Classe filla de Person, encarregada de representar el tipus 
 * de persona administrador. El seu objectiu és administrar l'hospital 
 * afegint visites, assignant i llits als pacients.
 * 
 * Un administrador estarà format pels atributs identificador i nom 
 * de la classe pare donada la relació d'herència amb ella i l'hospital
 * al qual pertany.
 */
public class Administrative extends Person
{	
    private Hospital hospital;	
	
    /**
     * Administrative(id, name, hospital). Constructor de Administrative. 
     * @param id atribut de Person, informa sobre l'identificador de la persona.
     * @param name atribut de Person, informa sobre el nom de la persona.
     * @param hospital atribut d'Administrative, informa sobre l'hospital al que
     * pertany l'administrador.
     * 
     * Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets.
     */     
    public Administrative( int id, String name, Hospital hospital ){
        super(id, name);        
        this.hospital = hospital;
    }
    /**
     * addVisit(). 
     * @param d indicant la data de la visita donada per la classe Calendar.
     * @param s indicant un resum sobre la visita.
     * @param doc indicant el doctor que ha duut a terme la visita.
     * @param p indicant el pacient de la visita.
     * (S'encarrega d'instanciar una nova visita assignant-li la informació
     * indicada pels paràmetres).
     */     
    public void addVisit( Calendar d, String s, Doctor doc, Patient p ){
        Visit v = new Visit(d, s, doc, p);       
        doc.addVisit(v);
        p.addVisit(v);
        hospital.addVisit(v);
    }
    /**
     * assignBed(). 
     * @param resident representant el resident pel qual assignarem el llit.
     * @return boolean
     * (Cerca si existeix cap llit disponible per qualsevol de les habitacions 
     * de l'hospital al que pertany l'administrador. També informa per pantalla 
     * sobre el resultat de la cerca. Retorna cert si s'ha trobat cap llit i 
     * fals altrament).
     */
    public boolean assignBed( Resident resident ){
        boolean trigger = false;
        LinkedList<Room> rooms = hospital.getRooms();
        
        for(int i = 0; i < rooms.size(); i++){           
            Room room = rooms.get(i);
            
            // si tenim una habitació disponible
            if(room.isAvailable()){                
                Bed avBed = room.getAvailableBed();
                resident.assignBed(avBed);
                System.out.println(this.toString() + "has assigned bed to");
                System.out.println(resident.toString() + " is assigned to");                               
                
                // si tenim un doctor assignat pel resident
                if(resident.getDoctor() != null){
                    System.out.println(room.toString() + " " + avBed.toString() + " and " + resident.getDoctor().toString());                 
                }
                
                // si no tenim un doctor assignat pel resident
                if(resident.getDoctor() == null){
                    System.out.println(room.toString() + " " + avBed.toString() + " and has no doctor.");                
                }               
                trigger = true;
                break;
            }
            
            // si totes les habitacions estan ocupades
            else if(!rooms.get(rooms.size()-1).isAvailable() & i == rooms.size()-1){         
                System.out.println(this.toString() + "has not found bed for");
                System.out.println(resident.toString() + " and has no");
                System.out.println("room neither bed and has no doctor");
                break;
            }
        }
        return trigger;
    }
    /**
     * toString(). 
     * @return String
     * (S'encarrega de retornar en format d'String el nom i identificador de la
     * instància actual d'administrador).
     */	
    @Override
    public String toString(){ 
        return "Administrative " + name + " ( ID " + id + " )";
    }
}

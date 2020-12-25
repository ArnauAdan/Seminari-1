
import java.util.LinkedList;
import java.util.Date;

public class Administrative extends Person
{	
    private Hospital hospital;	
	
    public Administrative( int id, String name, Hospital hospital ){
        super(id, name);        
        this.hospital = hospital;
    }
	
    public void addVisit( Date d, String s, Doctor doc, Patient p ){
        Visit v = new Visit(d, s, doc, p);       
        doc.addVisit(v);
        p.addVisit(v);
    }


    public boolean assignBed( Resident resident ){
        boolean trigger = false;
        LinkedList<Room> rooms = hospital.getRooms();
        for(int i = 0; i < rooms.size(); i++){
            Room room = rooms.get(i);
            if(room.isAvailable()){
                resident.assignBed(room.getAvailableBed());
                trigger = true;
                break;
            }
        }
        return trigger;
    }
	

    @Override
    public String toString(){ 
        return "Administrative " + name + " ( ID " + id + " )";
    }
}

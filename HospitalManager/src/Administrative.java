
import java.util.LinkedList;
import java.util.Calendar;

public class Administrative extends Person
{	
    private Hospital hospital;	
	
    public Administrative( int id, String name, Hospital hospital ){
        super(id, name);        
        this.hospital = hospital;
    }
	
    public void addVisit( Calendar d, String s, Doctor doc, Patient p ){
        Visit v = new Visit(d, s, doc, p);       
        doc.addVisit(v);
        p.addVisit(v);
        hospital.addVisit(v);
    }


    public boolean assignBed( Resident resident ){
        boolean trigger = false;
        LinkedList<Room> rooms = hospital.getRooms();
        for(int i = 0; i < rooms.size(); i++){
            //System.out.println(i);
            Room room = rooms.get(i);
            if(room.isAvailable()){
                Bed avBed = room.getAvailableBed();
                resident.assignBed(avBed);
                System.out.println(this.toString() + "has assigned bed to");
                System.out.println(resident.toString() + " is assigned to");                
                if(resident.getDoctor() != null){

                    System.out.println(room.toString() + " " + avBed.toString() + " and " + resident.getDoctor().toString());//////printbed0                    
                }
                if(resident.getDoctor() == null){
                    System.out.println(room.toString() + " " + avBed.toString() + " and has no doctor.");                
                }
                trigger = true;
                break;
            }
            else if(!rooms.get(rooms.size()-1).isAvailable() & i == rooms.size()-1){
                System.out.println(this.toString() + "has not found bed for");
                System.out.println(resident.toString() + " and has no");
                System.out.println("room neither bed and has no doctor");
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

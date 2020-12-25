
import java.util.LinkedList;
import java.util.Collections;

public class Hospital{
	private LinkedList< Administrative > admins;
	private LinkedList< Doctor > doctors;
	private LinkedList< Patient > patients;
	private LinkedList< Room > rooms;
	private LinkedList< Visit > visits;
	private String name;

	public Hospital( String name ){
		this.name = name;
                admins = new LinkedList<>();
                doctors = new LinkedList<>();
                patients = new LinkedList<>();
                rooms = new LinkedList<>();
                visits = new LinkedList<>();
	}
	
	public void addAdmin( Administrative a ){	
		admins.add(a);
	}

	public Administrative getAdmin( int idx ){
		return admins.get(idx);
	}
	
	public void addDoctor( Doctor d ){
		doctors.add(d);
	}

	public Doctor getDoctor( int idx ){
		return doctors.get(idx);
	}

	public void addRoom( int id ){
            Room room = new Room(id);
            rooms.add(room);
	}

	public Room getRoom( int idx ){
		return rooms.get(idx);
	}	
	
	public LinkedList< Room > getRooms(){
		return rooms;	
	}
	
	public void addResident(  int id, String name, int age ){
		Resident red = new Resident(id, name, age);
                patients.add(red);
	}
	
	public void addVisitor( int id, String name, int age ){
		Visitor vis = new Visitor(id, name, age);
                patients.add(vis);
	}
	
	public void addVisit( Visit v ){
		visits.add(v);
	}
	
	public Visit getVisit( int idx ){
		return visits.get(idx);
	}
	
	public Patient getPatient( int idx ){
		return patients.get(idx);
	}

	public void deletePatient( int idx ){
		patients.remove(idx);
	}
	
	public void assignBeds( int adminIdx ){
		Administrative admin = admins.get(adminIdx);
                for(Patient patient : patients){
                    if(patient instanceof Resident){
                        admin.assignBed((Resident)patient);
                    }
                }
	}

	public void sortPatients(){
		// Add code here
	}
	
        @Override
	public String toString(){
		return "Hospital " + name + " Administratives: ...";
	}

}

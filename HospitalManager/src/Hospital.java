
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
            Collections.sort(patients);
            System.out.println("Patients sorted by age:");
            for(Patient patient : patients){
                System.out.println(patient.toString());
            }
	}
        
        public void sortVisits(){
            Collections.sort(visits);
            System.out.println("Visits sorted by date:");
            for(Visit visit : visits){
                System.out.println(visit.toString());
            }
        }
	
        @Override
	public String toString(){
            
            String ad = "Administratives: \n";
            for(Administrative admin : admins){
                ad += admin.toString() + "\n";
            }
 
            String doc = "Doctors: \n";
            for(Doctor doctor : doctors){
                doc += doctor.toString() + "\n";
            }

            String pat = "Patients: \n";
            for(Patient patient : patients){
                pat += patient.toString() + "\n";
            }     
            
            String roo = "Rooms: \n";
            for(Room room : rooms){
                roo += room.toString() + "\n" + room.listBeds();
            }     
            
            String vis = "Visits: \n";
            for(Visit visit : visits){
                vis += visit.toString() + "\n";
            }               
            
		return "Hospital " + name + "\n" + 
                        ad + "\n" +
                        doc + "\n" +
                        pat + "\n" +
                        roo + "\n" +
                        vis + "\n";
	}

}

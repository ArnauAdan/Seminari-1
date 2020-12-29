import java.util.LinkedList;
import java.util.Collections;

/**
 * Hospital. Classe encarregada de representar l'hospital.
 * L'hospital  estarà format pels seus administradors (classe Administrative), 
 * doctors (classe Doctor), pacients (classe Patient), habitacions (classe Room)
 * , visites (Classe Visit) i finalment el seu nom.
 * 
 * El seu objectiu és permetre afegir personal, pacients, habitacions i visites. 
 * També permetre assignar llits, acomiadar pacients, ordenar visites i pacients 
 * per data i edat respectivament i, finalment, informar sobre 
 * l'estat de l'hospital.
 */
public class Hospital{
	private LinkedList< Administrative > admins;
	private LinkedList< Doctor > doctors;
	private LinkedList< Patient > patients;
	private LinkedList< Room > rooms;
	private LinkedList< Visit > visits;
	private String name;

    /**
     * Hospital(name). Constructor de Hospital. 
     * @param name informa sobre el nom de l'hospital.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */                    
    public Hospital( String name ){
        this.name = name;
        admins = new LinkedList<>();
        doctors = new LinkedList<>();
        patients = new LinkedList<>();
        rooms = new LinkedList<>();
        visits = new LinkedList<>();
    }
    /**
     * addAdmin().
     * @param a instància de la classe Administrative.
     * (Afegeix un administrador a la llista d'administradors de l'hospital).
     */ 	
    public void addAdmin( Administrative a ){	
        admins.add(a);
    }
    /**
     * getAdmin().
     * @param idx índex
     * @return Administrative
     * (Retorna d'entre la llista d'administradors de l'hospital l'indicat per
     * l'índex).
     */
    public Administrative getAdmin( int idx ){
        return admins.get(idx);
    }
    /**
     * addDoctor().
     * @param d instància de la classe Doctor.
     * (Afegeix un doctor a la llista doctors de l'hospital).
     */	
    public void addDoctor( Doctor d ){
        doctors.add(d);
    }
    /**
     * getDoctor().
     * @param idx índex
     * @return Doctor
     * (Retorna d'entre la llista de doctors de l'hospital l'indicat per
     * l'índex).
     */
    public Doctor getDoctor( int idx ){
        return doctors.get(idx);
    }
    /**
     * addRoom().
     * @param id identificador de l'habitació.
     * (Afegeix una habitació amb l'id especificat a la llista d'habitacions de
     * l'hospital).
     */	
    public void addRoom( int id ){
        Room room = new Room(id);
        rooms.add(room);
    }
    /**
     * getRoom().
     * @param idx índex
     * @return Room
     * (Retorna d'entre la llista d'habitacions de l'hospital la indicada per
     * l'índex).
     */    
    public Room getRoom( int idx ){
        return rooms.get(idx);
    }	
    /**
     * getRoom().
     * @return LinkedList
     * (Retorna la llista d'habitacions de l'hospital).
     */    	
    public LinkedList< Room > getRooms(){
        return rooms;	
    }
    /**
     * addResident().
     * @param id identificador del resident.
     * @param name nom del resident.
     * @param age edat del resident
     * (Afegeix un resident amb la informació especificada pels paràmetres a la
     * llista de pacients de l'hospital).
     */		
    public void addResident(  int id, String name, int age ){
        Resident red = new Resident(id, name, age);
        patients.add(red);        
    }
    /**
     * addVisitor().
     * @param id identificador del visitant.
     * @param name nom del visitant.
     * @param age edat del visitant
     * (Afegeix un visitant amb la informació especificada pels paràmetres a la
     * llista de pacients de l'hospital).
     */		
    public void addVisitor( int id, String name, int age ){
        Visitor vis = new Visitor(id, name, age);
        patients.add(vis);
    }
    /**
     * addVisit().
     * @param v Instància de la classe Visit.
     * (Afegeix la visita indicada pel paràmetre al registre de visites de 
     * l'hospital).
     */	
    public void addVisit( Visit v ){
        visits.add(v);
    }
    /**
     * getVisit().
     * @param idx índex.
     * @return Visit
     * (Retorna d'entre el registre de visites de l'hospital la indicada per
     * l'índex).
     */	
    public Visit getVisit( int idx ){
        return visits.get(idx);
    }
    /**
     * getVisit().
     * @param idx índex.
     * @return Patient
     * (Retorna d'entre el registre de pactients de l'hospital l'indicat per
     * l'índex).
     */		
    public Patient getPatient( int idx ){
        return patients.get(idx);
    }
    /**
     * deletePatient().
     * @param idx índex.
     * (Esborra el pacient indicat per l'índex del registre de pacients de 
     * l'hospital).
     */	
    public void deletePatient( int idx ){
        patients.remove(idx);
    }
    /**
     * assignBeds().
     * @param adminIdx índex.
     * (Mitjançant l'administrador seleccionat amb l'índex del paràmetre la 
     * funció s'encarrega d'assignar un llit a cada pacient del tipus resident).
     */	        
    public void assignBeds( int adminIdx ){
        Administrative admin = admins.get(adminIdx);
        for(Patient patient : patients){
            if(patient instanceof Resident){
                admin.assignBed((Resident)patient);                        
                }
        }               
    }
    /**
     * sortPatients().
     * (Mitjançant el mètode compareTo definit pels pacients ordenarà la
     * llista d'aquests que figuren a l'hospital).
     */	        
    public void sortPatients(){
        Collections.sort(patients);
        System.out.println("Patients sorted by age:");
        for(Patient patient : patients){
            System.out.println(patient.toString());
        }
    }
    /**
     * sortVisits().
     * (Mitjançant el mètode compareTo definit per les visites ordenarà la
     * llista d'aquestes que figuren a l'hospital).
     */	         
    public void sortVisits(){
        Collections.sort(visits);
        System.out.println("Visits sorted by date:");
        for(Visit visit : visits){
            System.out.println(visit.toString());
        }
    }
    /**
     * toString(). 
     * @return String
     * (S'encarrega de retornar en format d'String la informació sobre 
     * l'hospital).
     */	
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

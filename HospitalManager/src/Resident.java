public class Resident extends Patient
{
	private Room room;
	private Bed bed;

	public Resident ( int id, String name, int age ){
		super(id, name, age);
	}
	
	public void assignRoom( Room r ){
		room = r;         
	}
	
	public void assignBed( Bed b ){
		bed = b;
                b.assignResident(this);
	}
	
	public Doctor getDoctor(){
            if(visits.size() > 0){
                return visits.get(0).getDoctor();
            }
            else{
               return null; 
            }
            
	}
	
        @Override
	public String toString(){
		return "Resident " + name + " ( ID " + id + ", age " + age + " )";
	}
}


import java.util.LinkedList;

public class Doctor extends Person
{
	private LinkedList< String > specialities;
	private LinkedList< Visit > visits;

	public Doctor( int id, String name ){
		super(id, name);
                
                specialities = new LinkedList<>();
                visits = new LinkedList<>();
	}
	
	public void addSpeciality( String s ){
		specialities.add(s);
	}
	
	public void addVisit( Visit v ){
		visits.add(v);	
	}
	
	public void listSpecialities(){
		for(int i = 0; i < specialities.size(); i++){
                    System.out.println(specialities.get(i) + "%n");
                }
	}
	
	public void listVisits(){
		for(int i = 0; i < visits.size(); i++){
                    System.out.println(visits.get(i).toString() + "%n");
                }
	}
	
        @Override
	public String toString(){ 
		return "Doctor " + name + " ( ID " + id + " )";
	}
}

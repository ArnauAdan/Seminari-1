
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
            System.out.println(toString() + " has specialities: ");
            for(int i = 0; i < specialities.size(); i++){
                System.out.println(specialities.get(i));
            }
	}
	
	public void listVisits(){
            System.out.println(toString() + " has the following visits: ");
            for(int i = 0; i < visits.size(); i++){             
                System.out.println(visits.get(i).toString());
            }
	}
	
        @Override
	public String toString(){ 
            return "Doctor " + name + " ( ID " + id + " )";
	}
}

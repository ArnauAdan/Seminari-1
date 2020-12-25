
import java.util.LinkedList;
import java.util.Date;

public abstract class Patient extends Person implements Comparable<Patient>
{
    protected Date admissionDate;
    protected Integer age;
    protected LinkedList< Visit > visits;

    public Patient( int id, String name, int age ){
        super(id, name);
        this.age = age;
        visits = new LinkedList<>();
    }
	
    public void addVisit( Visit v ){
	visits.add(v);
    }
		
    public void setAdmissionDate( Date d ){
        this.admissionDate = d;
    }
	
    public Date getAdmissionDate(){
        return admissionDate;
    }
	
    public void setAge( Integer age ){
        this.age = age;	
    }
            
    public Integer getAge(){
        return age;	
    }
    
    @Override
    public int compareTo( Patient p ){
        if(this.age < p.getAge()){
            return -1;
        }
        if(this.age > p.getAge()){
            return 1;
        }
        else{
            return 0;
        }
    }
	
    @Override
    public abstract String toString();
}

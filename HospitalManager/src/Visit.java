
import java.util.Date;

public class Visit implements Comparable<Visit>{
	Date date;
	String summary;
	Doctor doctor;
	Patient patient;

	public Visit( Date d, String s, Doctor doc, Patient p ){
		date = d;
                summary = s;
                doctor = doc;
                patient = p;
	}
	
	public Date getDate(){
		return date;	
	}
	public String getSummary(){ 
		return summary;
	}
	public Doctor getDoctor(){ 
		return doctor;
	}
	public Patient getPatient(){ 
		return patient;	
	}
        
        @Override
        public int compareTo(Visit v){
           return this.date.compareTo(v.date); 
        }
	
        @Override
	public String toString(){ 
		return date.toString() + " " + doctor.toString() + " " + patient.toString() + " " + "Summary: " + summary;
	}
}
